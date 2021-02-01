package ru.alexkm07.spdata.model;

import lombok.*;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.UUID;

@Setter
@Getter
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    //@Column(name = "id")
    private Long id;
    //@Column(name = "name")
    private String name;
    //@Column(name = "address")
    private String address;

}
