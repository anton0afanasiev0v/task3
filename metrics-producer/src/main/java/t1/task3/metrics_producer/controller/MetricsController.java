package t1.task3.metrics_producer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.task3.metrics_producer.modell.Metric;
import t1.task3.metrics_producer.service.MetricService;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController {

    private final MetricService metricService;

    @PostMapping
    public void sendMetric(@RequestBody Metric metric) {
        metricService.sendMetric(metric);
    }

}