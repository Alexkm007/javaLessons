package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alexkm07.bank.model.Account;
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
    @NotEmpty(message = "Name cannot be Empty")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openingDate;
    private User owner;
    @NonNull
    private Currency currency;
    private Set<Transaction> transaction;
    private String balance;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.openingDate = account.getOpeningDate();
        this.owner = account.getOwner();
        this.currency = account.getCurrency();
        this.balance = account.getBalance().toString();
    }

    public AccountDto() {
        id = Long.valueOf(0);
        name = "";
        openingDate = new Date();
        owner = new User();
        transaction = new HashSet<>();
        balance = "0.0";
    }
}
