package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsService {
    private final AccountRepository accountRepository;
    private final UserService userService;

    public AccountsService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Account account : accounts) {
            accountDtos.add(convertAccountToAccountDto(account));
        }
        return accountDtos;
    }

    public void saveAccount(AccountDto accountDto, Long userid) {

        Account account = null;

        if (accountDto.getId().equals(0L)) {
            account = convertAccountDtoToAccount(accountDto, account);
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
        accountDto.setBalance(account.getBalance()==null ? Double.valueOf(0) : account.getBalance());
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
                balance = balance - transaction.getAmount();
            }

        }
        accountBase.setBalance(balance);
        accountRepository.save(accountBase);
    }
}
