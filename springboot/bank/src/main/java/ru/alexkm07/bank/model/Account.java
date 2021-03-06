package ru.alexkm07.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq")
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date openingDate;
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User owner;
    private Currency currency;
    private Double balance;

}
