package dev.patika.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    // We define our entity tables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;


    @Column(name = "appointmentDate")
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

}