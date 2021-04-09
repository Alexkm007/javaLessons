package ru.alexkm07.shop.model.warehouses;

import java.time.LocalDateTime;
import java.util.Set;

public class Сounterparty {
    private Long id;
    private String number;
    private LocalDateTime date;
    Set<ItemShipingOrder> items;
}
