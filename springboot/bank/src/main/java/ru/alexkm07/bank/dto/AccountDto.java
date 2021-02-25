package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.model.User;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AccountDto {
    @NonNull
    private Long id;
    @NonNull
    @NotEmpty
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date openingDate;
    @NonNull
    private User owner;
    private Currency currency;
    private Set<Transaction> transaction;
    private Double balance;

    public AccountDto() {
        id = Long.valueOf(0);
        name = "";
        openingDate = new Date();
        owner = new User();
        transaction = new HashSet<>();
        balance = Double.valueOf(0);
    }
}
