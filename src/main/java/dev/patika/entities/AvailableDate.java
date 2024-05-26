package dev.patika.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "availabledate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {
    // We define our entity tables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;


    @Column(name = "available_date")
    private LocalDate availableDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
}