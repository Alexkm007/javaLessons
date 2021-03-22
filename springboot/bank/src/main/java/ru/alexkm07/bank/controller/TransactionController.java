package ru.alexkm07.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.dto.TransactionDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.AccountsService;
import ru.alexkm07.bank.service.TransactionService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountsService accountsService;

    public TransactionController(TransactionService transactionService, AccountsService accountsService) {
        this.transactionService = transactionService;
        this.accountsService = accountsService;
    }

    @GetMapping()
    public String getAllTransactions(Model model, @AuthenticationPrincipal User activeUser){
        model.addAttribute("transactions",transactionService.giveAllTransactionDto());
        model.addAttribute("isAdmin",activeUser.isAdmin());
        return "transactions";
    }

    @GetMapping("add")
    public String addTransaction(Model model, @AuthenticationPrincipal User activeUser){
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        List<AccountDto> accountsDto = accountsService.getAll(activeUser);
        TransactionDto transactionDto = new TransactionDto();
        model.addAttribute("transaction",transactionDto);
        model.addAttribute("accountslistFrom",accountsDto);
        model.addAttribute("accountsListTo",accountsDto);
        model.addAttribute("addtransaction",true);
        model.addAttribute("currencylist", currencylist);
        model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
        model.addAttribute("isAdmin",activeUser.isAdmin());
        return "transaction";
    }

    @PostMapping("add")
    public String saveTransaction(Model model, @Valid TransactionDto transactionDto, BindingResult bindingResult,
                                  @RequestParam("toAccount") Long toAccountId,
                                  @RequestParam("fromAccount") Long fromAccountId,
                                  @AuthenticationPrincipal User activeUser){
        if(bindingResult.hasErrors()){
            model = ControllerUtils.getErrors(bindingResult,model);
            model.addAttribute("transaction",transactionDto);
            List<String> currencylist = Arrays.stream(Currency.values()).
                    map(currency -> currency.name()).
                    collect(Collectors.toList());
            model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
            model.addAttribute("addaccount",true);
            List<AccountDto> accountsDtoTo = accountsService.getAll(activeUser);
            List<AccountDto> accountsDtoFrom = accountsService.getAll(activeUser);


            if(toAccountId != 0){
                AccountDto accountDtoTo= accountsService.getAccountDtoById(toAccountId);
                String selectedAccount = String.format("value=\"%d\">%s",toAccountId,accountDtoTo.getName());
                model.addAttribute("selectedaccountTo",selectedAccount);
                for(AccountDto accountDto:accountsDtoTo){
                    if(accountDto.getId().equals(toAccountId)){
                        accountsDtoTo.remove(accountDto);
                        break;
                    }
                }
            }

            if(fromAccountId != 0){
                AccountDto accountDtoFrom= accountsService.getAccountDtoById(toAccountId);
                String selectedAccount = String.format("value=\"%d\">%s",fromAccountId,accountDtoFrom.getName());
                model.addAttribute("selectedaccountFrom",selectedAccount);
                for(AccountDto accountDto:accountsDtoFrom){
                    if(accountDto.getId().equals(toAccountId)){
                        accountsDtoTo.remove(accountDto);
                        break;
                    }
                }
            }

            model.addAttribute("currencylist", currencylist);
            model.addAttribute("accountslistFrom",accountsDtoFrom);
            model.addAttribute("accountsListTo",accountsDtoTo);
            model.addAttribute("isAdmin",activeUser.isAdmin());
            return "transaction";
        }
        transactionService.saveTransaction(transactionDto,fromAccountId,toAccountId);
        if (transactionDto.getId().equals(0D)) {
            log.info("User " + activeUser.getUsername() + " add new transaction ");
        } else {
            log.info("User " + activeUser.getUsername() + " edit new transaction with id " + transactionDto.getId());
        }
        return "redirect:/transactions";
    }

    @GetMapping("edit/{id}")
    public String editTransaction(Model model, @PathVariable("id") Long id, @AuthenticationPrincipal User activeUser){
        TransactionDto transactionDto = transactionService.getById(id);
        model.addAttribute("transaction",transactionDto);
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
        List<AccountDto> accountsDtoTo = accountsService.getAll(activeUser);
        List<AccountDto> accountsDtoFrom = accountsService.getAll(activeUser);

            Account accountTo= transactionDto.getToAccount();
            String selectedAccount = String.format("value=\"%d\">%s",accountTo.getId(),accountTo.getName());
            model.addAttribute("selectedaccountTo",selectedAccount);
            for(AccountDto accountDto:accountsDtoTo){
                if(accountDto.getId().equals(accountTo.getId())){
                    accountsDtoTo.remove(accountDto);
                    break;
                }
            }

            Account accountFrom= transactionDto.getFromAccount();
            selectedAccount = String.format("value=\"%d\">%s",accountFrom.getId(),accountFrom.getName());
            model.addAttribute("selectedaccountFrom",selectedAccount);
            for(AccountDto accountDto:accountsDtoFrom){
                if(accountDto.getId().equals(accountFrom.getId())){
                    accountsDtoTo.remove(accountDto);
                    break;
                }
            }

        model.addAttribute("currencylist", currencylist);
        model.addAttribute("accountslistFrom",accountsDtoFrom);
        model.addAttribute("accountsListTo",accountsDtoTo);
        model.addAttribute("isAdmin",activeUser.isAdmin());
        return "transaction";
    }

    @PostMapping("edit/{id}")
    public String updateTransaction(Model model, @Valid TransactionDto transactionDto, BindingResult bindingResult,
                                    @RequestParam("toAccount") Long toAccountId,
                                    @RequestParam("fromAccount") Long fromAccountId,
                                    @AuthenticationPrincipal User activeUser){
        return saveTransaction(model,transactionDto,bindingResult,toAccountId,fromAccountId,activeUser);
    }

    @GetMapping("delete/{id}")
    public String deleteTransaction(Model model, @PathVariable("id") Long id,@AuthenticationPrincipal User activeUser){
        log.info("User " + activeUser.getUsername() + " delete Transaction id " + id);
        transactionService.deleteById(id);
        return "redirect:/transactions";
    }


}
