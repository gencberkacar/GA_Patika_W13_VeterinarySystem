package dev.patika.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    // We define our entity tables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Email
    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "address", unique = true)
    private String address;

    @Column(name = "city", unique = true)
    private String city;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDateList;


}