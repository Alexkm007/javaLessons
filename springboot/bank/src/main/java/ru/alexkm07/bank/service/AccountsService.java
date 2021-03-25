package ru.alexkm07.bank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AccountsService {
    private final AccountRepository accountRepository;
    private final UserService userService;

    public AccountsService(AccountRepository accountRepository, @Lazy UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public List<AccountDto> getAll(User user) {
        List<Account> accounts;

        if(user.isAdmin()){
            accounts = accountRepository.findAll();}
        else {
            accounts =  accountRepository.findAllByOwner(user);
        }
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(convertAccountToAccountDto(account));
        }
        return accountDtos;
    }

    public void saveAccount(AccountDto accountDto, Long userid) {

        Account account = null;

        if (accountDto.getId() == 0) {
            account = convertAccountDtoToAccount(accountDto, null);
        } else {
            account = accountRepository.findById(accountDto.getId()).get();
            account = convertAccountDtoToAccount(accountDto, account);
        }
        account.setOwner(userService.getUserbyId(userid));
        accountRepository.save(account);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

    public AccountDto getAccountDtoById(Long id){
        return convertAccountToAccountDto(accountRepository.findById(id).get());
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).get();
    }

    public AccountDto convertAccountToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setOwner(account.getOwner());
        accountDto.setOpeningDate(account.getOpeningDate());
        accountDto.setBalance(String.format("%.2f",account.getBalance()==null ? Double.valueOf(0) : account.getBalance()));
        return accountDto;
    }

    public Account convertAccountDtoToAccount(AccountDto accountDto, Account account) {

        if (account == null) {
            account = new Account();
        }

        account.setCurrency(accountDto.getCurrency());
        account.setName(accountDto.getName());
        account.setOpeningDate(accountDto.getOpeningDate());
        account.setOwner(accountDto.getOwner());

        return account;
    }

    public void updateBalance(Account account, List<Transaction> transactions) {
        Account accountBase = accountRepository.findById(account.getId()).get();
        Double balance = Double.valueOf(0);
        for(Transaction transaction:transactions){
            if(transaction.getToAccount().getId().equals(account.getId())){
                balance = balance +  transaction.getAmount();
            }

            if(transaction.getFromAccount().getId().equals(account.getId())){
                balance = balance - transaction.getAmount()*transaction.getRate();
            }

        }
        accountBase.setBalance(balance);
        accountRepository.save(accountBase);
    }
}
