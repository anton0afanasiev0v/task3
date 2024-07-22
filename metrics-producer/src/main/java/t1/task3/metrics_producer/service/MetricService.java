package t1.task3.metrics_producer.service;


import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import t1.task3.metrics_producer.modell.Metric;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MetricService {

    private static final String TOPIC = "metrics-topic";

    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final MeterRegistry meterRegistry;

    public MetricService(KafkaTemplate<Object, Object> kafkaTemplate,
                         MeterRegistry meterRegistry) {
        this.kafkaTemplate = kafkaTemplate;
        this.meterRegistry = meterRegistry;
    }

    public void sendMetric(Object object) {
        kafkaTemplate.send(TOPIC, object);
    }

    @Scheduled(fixedRate = 60000) // Send metrics every minute
    public void sendMetrics() {
        for (Meter meter : meterRegistry.getMeters()) {
            Meter.Id id = meter.getId();

            Map<String, Object> metricData = new HashMap<>();
            metricData.put("name", id.getName());
            metricData.put("type", id.getType().name());
            metricData.put("description", id.getDescription());
            metricData.put("baseUnit", id.getBaseUnit());
            metricData.put("tags", id.getTags());

            for (Measurement measurement : meter.measure()) {
                metricData.put(measurement.getStatistic().name(), measurement.getValue());
            }

            Metric metric = new Metric(id.getName(), metricData.toString());
            this.sendMetric(metric);
            log.info("Metric send with name = '{}' and data '{}' ", id.getName(), metricData.toString());
        }
    }
}