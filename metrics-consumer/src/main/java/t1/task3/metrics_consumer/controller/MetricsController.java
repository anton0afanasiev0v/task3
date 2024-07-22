package t1.task3.metrics_consumer.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.task3.metrics_consumer.model.Metric;
import t1.task3.metrics_consumer.service.MetricService;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@AllArgsConstructor
public class MetricsController {

    private final MetricService metricService;

    @GetMapping
    public List<Metric> getAllMetrics() {
        return metricService.getAllMetrics();
    }

    @GetMapping("/{id}")
    public Metric getMetricById(@PathVariable Long id) {
        return metricService.getMetricById(id);
    }
}