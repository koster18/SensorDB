package ru.sterkhovkv.SensorDB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Integer sensorId;

    @Column(name = "name", unique = true, nullable = false)
    @Size(min = 3, max = 30)
    private String name;

    @OneToMany(mappedBy = "sensor")
    private List<Measure> measures;
}