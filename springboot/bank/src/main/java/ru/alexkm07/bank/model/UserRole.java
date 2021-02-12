package ru.alexkm07.bank.model;

import javax.persistence.*;
import java.io.PrintWriter;
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq")
    private Long id;
    @OneToOne
    private User user;
    private Role role;
}
