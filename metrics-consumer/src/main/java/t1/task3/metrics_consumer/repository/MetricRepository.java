package t1.task3.metrics_consumer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.task3.metrics_consumer.model.Metric;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
}