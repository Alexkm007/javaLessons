package ru.alexkm07.shop.model.reference;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ctg_seq")
    @SequenceGenerator(name = "ctg_seq", sequenceName = "ctg_seq")
    private Long id;
    private String Name;
}
