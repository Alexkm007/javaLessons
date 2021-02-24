package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    private UserDto owner;
    private Set<TransactionDto> transaction;

    public AccountDto() {
        id = Long.valueOf(0);
        name = "";
        openingDate = new Date();
        owner = new UserDto();
        transaction = new HashSet<>();
    }
}
