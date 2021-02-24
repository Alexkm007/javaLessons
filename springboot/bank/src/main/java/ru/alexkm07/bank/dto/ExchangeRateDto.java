package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alexkm07.bank.model.Currency;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class ExchangeRateDto {
    private Long id;
    @NonNull
    private Currency currency;
    @NonNull
    private Double rate;
    @NonNull
    private Double ratio;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NonNull
    private Date date;

    public ExchangeRateDto() {
        id = Long.valueOf(0);
        rate = Double.valueOf(0);
        ratio = Double.valueOf(1);
        date = new Date();
    }

    @Override
    public String toString() {
        return "ExchangeRateDto{" +
                "id=" + id +
                ", currency=" + currency.name() +
                ", rate=" + rate +
                ", ratio=" + ratio +
                ", date=" + date +
                '}';
    }
}
