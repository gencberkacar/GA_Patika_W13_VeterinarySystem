package dev.patika.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Animal")
@Data
public class Animal {
    // We define our entity tables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "breed", length = 100)
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GENDER gender;

    @Column(name = "colour")
    private String colour;

    @Column(name = "species")
    private String species;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    public enum GENDER {
        MALE,
        FEMALE
    }

}