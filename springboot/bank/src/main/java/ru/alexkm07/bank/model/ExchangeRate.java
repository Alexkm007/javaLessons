package ru.alexkm07.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exch_seq")
    @SequenceGenerator(name = "exch_seq", sequenceName = "exch_seq")
    private Long id;
    private Currency currency;
    private Double Rate;
    private Double Ratio;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date date;
}
