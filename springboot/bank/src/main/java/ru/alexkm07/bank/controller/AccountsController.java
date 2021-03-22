package ru.alexkm07.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.dto.AccountDto;
import ru.alexkm07.bank.dto.UserDto;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.AccountsService;
import ru.alexkm07.bank.service.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    public String getAllAccounts(Model model,@AuthenticationPrincipal User activeUser) {
        List<AccountDto> accounts = accountsService.getAll(activeUser);
        model.addAttribute("accounts", accounts);
        model.addAttribute("isAdmin",activeUser.isAdmin());
        return "accounts";
    }


    @GetMapping("add")
    public String addAccount(Model model,@AuthenticationPrincipal User activeUser){
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
        model.addAttribute("isAdmin",activeUser.isAdmin());
        if(!activeUser.isAdmin()){
            model.addAttribute("owner",activeUser.getId());
        }
        return "account";
    }

    @PostMapping("add")
    public String saveNewAccount(Model model, @Valid AccountDto accountDto, BindingResult bindingResult,
                                 @RequestParam("user") Long idUser,
                                 @AuthenticationPrincipal User activeUser){
        if(accountDto.getId().equals(0D)) {
            model.addAttribute("addaccount", true);
        }else {
            model.addAttribute("addaccount", false);
        }
        if(bindingResult.hasErrors()){
            model = ControllerUtils.getErrors(bindingResult,model);
            model.addAttribute("account",accountDto);
            List<String> currencylist = Arrays.stream(Currency.values()).
                    map(currency -> currency.name()).
                    collect(Collectors.toList());
            List<UserDto> userList = userService.findAll();
            model.addAttribute("openingDate",ControllerUtils.dateToString(accountDto.getOpeningDate(),"yyyy-MM-dd"));


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
            if(!activeUser.isAdmin()){
                model.addAttribute("owner",activeUser.getId());
            }
            model.addAttribute("isAdmin",activeUser.isAdmin());
            return "account";
        }

        if(accountDto.getId().equals(0D)){
            log.info("User " + activeUser.getUsername() + " add account");
        } else {
            log.info("User " + activeUser.getUsername() + " edit account with id " + accountDto.getId());
        }
        accountsService.saveAccount(accountDto,idUser);
        return "redirect:/accounts";
    }

    @GetMapping("edit/{id}")
    public String editAccount(Model model, @PathVariable("id") Long id,@AuthenticationPrincipal User activeUser){
        AccountDto accountDto = accountsService.getAccountDtoById(id);
        model.addAttribute("account",accountDto);
        model.addAttribute("addaccount",false);
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        List<UserDto> userList = userService.findAll();
        model.addAttribute("openingDate",ControllerUtils.dateToString(accountDto.getOpeningDate(),"yyyy-MM-dd"));
        model.addAttribute("editaccount",true);
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
        Long  idUser =  accountDto.getOwner().getId();
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
        model.addAttribute("isAdmin",activeUser.isAdmin());
        if(!activeUser.isAdmin()){
            model.addAttribute("owner",activeUser.getId());
        }
        return "account";
    }

    @PostMapping("edit/{id}")
    public String upDateAccount(Model model, @Valid AccountDto accountDto, BindingResult bindingResult,
                                @RequestParam("user") Long idUser,@AuthenticationPrincipal User activeUser){
        return saveNewAccount(model,accountDto,bindingResult,idUser,activeUser);
    }

    @GetMapping("delete/{id}")
    public String deleteAccount(@PathVariable Long id,@AuthenticationPrincipal User activeUser){
        log.info(" User " + activeUser.getUsername() + " delete account id " + id);
        accountsService.deleteAccount(id);
        return "redirect:/accounts";
    }

}
