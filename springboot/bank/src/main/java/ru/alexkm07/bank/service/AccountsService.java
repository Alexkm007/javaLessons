package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsService {
    private final AccountRepository accountRepository;

    public AccountsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(convertAccountToAccountDto(account));
        }
        return accountDtos;
    }

    private AccountDto convertAccountToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setOwner(account.getOwner());
        accountDto.setOpeningDate(account.getOpeningDate());
        accountDto.setTransaction(account.getTransactions());
        accountDto.setBalance(account.returnBalance());
        return accountDto;
    }

}
