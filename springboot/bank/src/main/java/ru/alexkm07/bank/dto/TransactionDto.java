package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Currency;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class TransactionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_seq")
    @SequenceGenerator(name = "tran_seq", sequenceName = "tran_seq")
    Long id;
    @DateTimeFormat(pattern = "yyyy.mm.dd HH:mm:ss")
    Date date;
    @ManyToOne
    Account fomAccount;
    @ManyToOne
    Account toAccount;
    Currency currency;
    Double Rate;
    Double Summa;
}
