package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.TransactionDto;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountsService accountsService;

    public TransactionService(TransactionRepository transactionRepository, AccountsService accountsService) {
        this.transactionRepository = transactionRepository;
        this.accountsService = accountsService;
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
        transactionRepository.save(transaction);
    }

    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }
    public TransactionDto getById(Long id){
     return convertTransactionToTransactionDto(transactionRepository.findById(id).get());
    }

    private Transaction convertTransactionDtoToTransaction(TransactionDto transactionDto, Transaction transaction){
        transaction.setCurrency(transactionDto.getCurrency());
        transaction.setDate(transactionDto.getDate());
        transaction.setFromAccount(transactionDto.getFromAccount());
        transaction.setToAccount(transactionDto.getToAccount());
        transaction.setAmount(transactionDto.getAmount());
        return transaction;
    }

    private TransactionDto convertTransactionToTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setCurrency(transaction.getCurrency());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setFromAccount(transaction.getFromAccount());
        transactionDto.setToAccount(transaction.getToAccount());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }

}
