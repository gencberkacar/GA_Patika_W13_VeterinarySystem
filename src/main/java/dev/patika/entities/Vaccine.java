package dev.patika.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "Vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    // We define our entity tables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name", length = 100, unique = true)

    private String name;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "vaccineStartDate", length = 100)
    private LocalDate protectionStartDate;

    @Column(name = "vaccineFinishDate", length = 100)
    private LocalDate protectionFinishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;

}