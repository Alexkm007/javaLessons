package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.TransactionDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountsService accountsService;
    private final ExchangeService exchangeService;

    public TransactionService(TransactionRepository transactionRepository, AccountsService accountsService, ExchangeService exchangeService) {
        this.transactionRepository = transactionRepository;
        this.accountsService = accountsService;
        this.exchangeService = exchangeService;
    }

    public List<TransactionDto> giveAllTransactionDto(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for(Transaction transaction:transactions){
            transactionDtos.add(convertTransactionToTransactionDto(transaction));
        }
        return transactionDtos;
    }

    public void saveTransaction(TransactionDto transactionDto, Long fromAccountId, Long toAccountId){
        Transaction transaction = null;
        if(!transactionDto.getId().equals(Long.valueOf(0))){
            transaction = transactionRepository.findById(transactionDto.getId()).get();
        }else {
            transaction = new Transaction();
        }
        transaction = convertTransactionDtoToTransaction(transactionDto,transaction);
        transaction.setFromAccount(accountsService.getAccountById(fromAccountId));
        transaction.setToAccount(accountsService.getAccountById(toAccountId));
        Double rateFrom = exchangeService.returnRate(transaction.getFromAccount().getCurrency());
        Double rateTo = exchangeService.returnRate(transaction.getToAccount().getCurrency());
        Double rate;
        if(!rateTo.equals(0D)){
            rate = rateTo/rateFrom;
        } else {
            rate = 0D;
        }
        transaction.setRate(rate);
        transactionRepository.save(transaction);
        accountsService.updateBalance(transaction.getToAccount(),
                transactionRepository.findAllByFromAccountOrToAccount(transaction.getToAccount(),
                        transaction.getToAccount()));
        accountsService.updateBalance(transaction.getFromAccount(),
                transactionRepository.findAllByFromAccountOrToAccount(transaction.getFromAccount(),
                        transaction.getFromAccount()));;
    }

    public void deleteById(Long id){
        Transaction transaction = transactionRepository.findById(id).get();
        Account from = transaction.getFromAccount();
        Account to   = transaction.getToAccount();
        transactionRepository.deleteById(id);
        accountsService.updateBalance(from,findAllByAccount(from));
        accountsService.updateBalance(to,findAllByAccount(to));
    }

    public TransactionDto getById(Long id){
        return convertTransactionToTransactionDto(transactionRepository.findById(id).get());
    }

    public List<Transaction> findAllByAccount(Account account){
        return transactionRepository.findAllByFromAccountOrToAccount(account,account);
    }

    private Transaction convertTransactionDtoToTransaction(TransactionDto transactionDto, Transaction transaction){
        transaction.setDate(transactionDto.getDate());
        transaction.setFromAccount(transactionDto.getFromAccount());
        transaction.setToAccount(transactionDto.getToAccount());
        transaction.setAmount(transactionDto.getAmount());
        return transaction;
    }

    private TransactionDto convertTransactionToTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setFromAccount(transaction.getFromAccount());
        transactionDto.setToAccount(transaction.getToAccount());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }

}
