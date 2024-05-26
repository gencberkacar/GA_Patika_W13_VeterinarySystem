package dev.patika.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
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

    @Column(name = "phone", length = 100)
    private String phone;


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    @JsonIgnore // List olarak tuttuğumuz class'a tekrar dönmesini istemediğimiz yere yazarız.
    private List<Animal> animal;

}