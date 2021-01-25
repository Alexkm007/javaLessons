package ru.alexkm07.spdata.model;

import lombok.*;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.UUID;

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
    @Setter
    @Getter
    @GeneratedValue
    //@Column(name = "id")
    private UUID id;
    @Setter
    @Getter
    //@Column(name = "name")
    private String name;
    @Setter
    @Getter
    //@Column(name = "address")
    private String address;

}
