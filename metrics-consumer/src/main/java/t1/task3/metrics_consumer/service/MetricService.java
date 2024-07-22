package t1.task3.metrics_consumer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import t1.task3.metrics_consumer.model.Metric;
import t1.task3.metrics_consumer.repository.MetricRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MetricService {

    private final MetricRepository metricRepository;

    @KafkaListener(topics = "metrics-topic", groupId = "group_id")
    public void consumeMetric(Metric metric) {
        log.info("Received listen1: {}", metric);
        metricRepository.save(metric);
    }

    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    public Metric getMetricById(Long id) {
        return metricRepository.findById(id).orElse(null);
    }
}