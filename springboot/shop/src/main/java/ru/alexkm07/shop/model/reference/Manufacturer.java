package ru.alexkm07.shop.model.reference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.alexkm07.shop.model.reference.Country;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mnf_seq")
    @SequenceGenerator(name = "mnf_seq", sequenceName = "mnf_seq")
    private Long id;
    private String name;
    @OneToOne
    private Country country;
}
