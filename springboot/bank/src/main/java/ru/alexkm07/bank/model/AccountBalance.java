package ru.alexkm07.bank.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class AccountBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acbal_seq")
    @SequenceGenerator(name = "acbal_seq", sequenceName = "acbal_seq")
    private Long id;
    @OneToOne
    private Account account;
    private Currency currency;
    private Double balance;
}
