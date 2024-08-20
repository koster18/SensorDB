package ru.sterkhovkv.SensorDB.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measure")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measure_id")
    private Integer measureId;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Column(name = "value", nullable = false)
    @Min(value = -100)
    @Max(value = 100)
    private Double value;

    @Column(name = "raining", nullable = false)
    private Boolean raining;

    @Column(name = "measurement_time", nullable = false)
    private LocalDateTime measurementTime;
}
