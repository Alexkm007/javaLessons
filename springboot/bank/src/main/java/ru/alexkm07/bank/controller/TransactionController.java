package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexkm07.bank.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public String getAllTransactions(Model model){
        model.addAttribute("transactions",transactionService.giveAllTransactionDto());
        return "transactions_page";
    }

}
