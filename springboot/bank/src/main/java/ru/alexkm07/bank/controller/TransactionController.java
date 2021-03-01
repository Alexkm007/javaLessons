package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.dto.TransactionDto;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.service.AccountsService;
import ru.alexkm07.bank.service.TransactionService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public String getAllTransactions(Model model){
        model.addAttribute("transactions",transactionService.giveAllTransactionDto());
        return "transactions_page";
    }

    @GetMapping("add")
    public String addTransaction(Model model){
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        List<AccountDto> accountsDto = accountsService.getAll();
        TransactionDto transactionDto = new TransactionDto();
        model.addAttribute("transaction",transactionDto);
        model.addAttribute("accountslistFrom",accountsDto);
        model.addAttribute("accountslistTo",accountsDto);
        model.addAttribute("addtransaction",true);
        model.addAttribute("currencylist", currencylist);
        model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
        return "transaction";
    }

    @PostMapping("add")
    public String saveTransaction(Model model, @Valid TransactionDto transactionDto, BindingResult bindingResult,
                                  @RequestParam("toAccount") Long toAccountId,@RequestParam("fromAccount") Long fromAccountId){
        if(bindingResult.hasErrors()){
            model = ControllerUtils.getErrors(bindingResult,model);
            model.addAttribute("transaction",transactionDto);
            List<String> currencylist = Arrays.stream(Currency.values()).
                    map(currency -> currency.name()).
                    collect(Collectors.toList());
            model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
            model.addAttribute("addaccount",true);
            List<AccountDto> accountsDtoTo = accountsService.getAll();
            List<AccountDto> accountsDtoFrom = accountsService.getAll();

            if(transactionDto.getCurrency() != null){
                String nameCurrency = transactionDto.getCurrency().name();
                String selectedCurrency = String.format("value=\"%s\">%s",nameCurrency,nameCurrency);
                model.addAttribute("selectedcurrency",selectedCurrency);
                for(String currency:currencylist){
                    if(currency.equals(transactionDto.getCurrency().name())){
                        currencylist.remove(currency);
                        break;
                    }
                }
            }

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
            model.addAttribute("accountslistto",accountsDtoTo);
            return "transaction";
        }
        transactionService.saveTransaction(transactionDto,fromAccountId,toAccountId);
        return "redirect:/transactions";
    }

    @GetMapping("edit/{id}")
    public String editTransaction(Model model, @PathVariable("id") Long id){
        TransactionDto transactionDto = transactionService.getById(id);
        model.addAttribute("transaction",transactionDto);
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        model.addAttribute("transactionDate",ControllerUtils.dateToString(transactionDto.getDate(),"yyyy-MM-dd"));
        List<AccountDto> accountsDtoTo = accountsService.getAll();
        List<AccountDto> accountsDtoFrom = accountsService.getAll();
         String nameCurrency = transactionDto.getCurrency().name();
            String selectedCurrency = String.format("value=\"%s\">%s",nameCurrency,nameCurrency);
            model.addAttribute("selectedcurrency",selectedCurrency);
            for(String currency:currencylist){
                if(currency.equals(transactionDto.getCurrency().name())){
                    currencylist.remove(currency);
                    break;
                }
            }

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
        model.addAttribute("accountslistto",accountsDtoTo);

        return "transaction";
    }

    @PostMapping("edit/{id}")
    public String updateTransaction(Model model, @Valid TransactionDto transactionDto, BindingResult bindingResult,
                                    @RequestParam("toAccount") Long toAccountId,@RequestParam("fromAccount") Long fromAccountId){
        return saveTransaction(model,transactionDto,bindingResult,toAccountId,fromAccountId);
    }

    @GetMapping("delete/{id}")
    public String deleteTransaction(Model model, @PathVariable("id") Long id){
        transactionService.deleteById(id);
        return "redirect:/transactions";
    }


}
