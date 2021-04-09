package ru.alexkm07.shop.model.products;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fld_seq")
    @SequenceGenerator(name = "fld_seq", sequenceName = "fld_seq")
    private Long id;
    private String name;
    @OneToOne
    private Folder parent;
}
