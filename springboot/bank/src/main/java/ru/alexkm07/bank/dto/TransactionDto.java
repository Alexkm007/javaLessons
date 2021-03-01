package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;

@Getter
@Setter
public class TransactionDto {
    Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;
    @ManyToOne
    Account fromAccount;
    @ManyToOne
    Account toAccount;
    @NonNull
    Currency currency;
    @NonNull
    Double amount;

    public TransactionDto() {
        id = Long.valueOf(0);
        currency = Currency.RU;
        date = new Date();
        fromAccount = new Account();
        toAccount = new Account();
        amount = Double.valueOf(0);
    }
}
