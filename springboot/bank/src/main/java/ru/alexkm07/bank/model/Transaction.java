package ru.alexkm07.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_seq")
    @SequenceGenerator(name = "tran_seq", sequenceName = "tran_seq")
    private Long id;
    @DateTimeFormat(pattern = "yyyy.mm.dd")
    private Date date;
    @ManyToOne()
    private Account fromAccount;
    @ManyToOne()
    private Account toAccount;
    private Currency currency;
    private Double amount;
}
