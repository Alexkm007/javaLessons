package ru.alexkm07.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.dto.UserDto;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.service.AccountsService;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountsService accountsService;
    private final UserService userService;

    public AccountsController(AccountsService accountsService, UserService userService) {
        this.accountsService = accountsService;
        this.userService = userService;
    }

    @GetMapping()
    public String getAllAccounts(Model model) {
        List<AccountDto> accounts = accountsService.getAll();
        model.addAttribute("accounts", accounts);
        return "accounts_page";
    }


    @GetMapping("add")
    public String addAccount(Model model){
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        List<UserDto> userList = userService.findAll();
        AccountDto accountDto = new AccountDto();
        model.addAttribute("account",accountDto);
        model.addAttribute("userlist",userList);
        model.addAttribute("addaccount",true);
        model.addAttribute("currencylist", currencylist);
        model.addAttribute("openingDate",ControllerUtils.dateToString(accountDto.getOpeningDate(),"yyyy-MM-dd"));
        return "account";
    }

    @PostMapping("add")
    public String saveNewAccount(Model model, @Valid AccountDto accountDto, BindingResult bindingResult, @RequestParam("user") Long idUser){
        if(bindingResult.hasErrors()){
            model = ControllerUtils.getErrors(bindingResult,model);
            model.addAttribute("account",accountDto);
            List<String> currencylist = Arrays.stream(Currency.values()).
                    map(currency -> currency.name()).
                    collect(Collectors.toList());
            List<UserDto> userList = userService.findAll();
            model.addAttribute("openingDate",ControllerUtils.dateToString(accountDto.getOpeningDate(),"yyyy-mm-dd"));
            model.addAttribute("addaccount",true);

            if(accountDto.getCurrency() != null){
                String nameCurrency = accountDto.getCurrency().name();
                String selectedCurrency = String.format("value=\"%s\">%s",nameCurrency,nameCurrency);
                model.addAttribute("selectedcurrency",selectedCurrency);
                for(String currency:currencylist){
                    if(currency.equals(accountDto.getCurrency().name())){
                        currencylist.remove(currency);
                        break;
                    }
                }
            }

            if(idUser != 0){
                UserDto userDto= userService.getById(idUser);
                String selectedUser = String.format("value=\"%d\">%s",idUser,userDto.getUsername());
                model.addAttribute("selecteduser",selectedUser);
                for(UserDto userToDelete:userList){
                    if(userToDelete.getId().equals(idUser)){
                        userList.remove(userToDelete);
                        break;
                    }
                }
            }
            model.addAttribute("currencylist", currencylist);
            model.addAttribute("userlist",userList);
            return "account";
        }

        return "redirect:/accounts";
    }

}
