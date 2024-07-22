package t1.task3.metrics_producer.modell;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Metric {
    private String name;
    private String value;

    public String toString() {
        return name + ": " + value;
    }
}