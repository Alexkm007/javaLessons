package ru.alexkm07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Setter
    @Getter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Setter
    @Getter
    @Column(name = "name")
    private String name;
    @Setter
    @Getter
    private String address;

}
