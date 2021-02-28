package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.TransactionDto;
import ru.alexkm07.bank.model.Transaction;
import ru.alexkm07.bank.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDto> giveAllTransactionDto(){
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for(Transaction transaction:transactions){
            transactionDtos.add(convertTransactionToTransactionDto(transaction));
        }
        return transactionDtos;
    }

    private TransactionDto convertTransactionToTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setCurrency(transaction.getCurrency());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setFomAccount(transaction.getFomAccount());
        transactionDto.setToAccount(transaction.getToAccount());
        return transactionDto;
    }

}
