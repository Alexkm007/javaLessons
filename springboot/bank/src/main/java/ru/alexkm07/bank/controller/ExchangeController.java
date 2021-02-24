package ru.alexkm07.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.bank.dto.ExchangeRateDto;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.service.ExchangeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping()
    public String getExchangeHistory(Model model) {
        List<ExchangeRateDto> exchangeRateDtoList = exchangeService.getAll();
        model.addAttribute("exchangerate", exchangeRateDtoList);
        return "exchange_history";
    }

    @GetMapping("/add")
    public String newExchangeRecord(Model model) {
        List<String> currencylist = Arrays.stream(Currency.values()).
                map(currency -> currency.name()).
                collect(Collectors.toList());
        model.addAttribute("currencylist", currencylist);
        model.addAttribute("addexchange", "addexchange");
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();

        model.addAttribute("exchange", exchangeRateDto);
        return "exchange";
    }

    @PostMapping("/add")
    public String addExchangeRecord(Model model, @Valid ExchangeRateDto exchangeRateDto, BindingResult bindingResult,
                                    @AuthenticationPrincipal User activeUser) {
        model.addAttribute("exchange", exchangeRateDto);
        if (bindingResult.hasErrors()) {
            List<String> currencylist = Arrays.stream(Currency.values()).
                    map(currency -> currency.name()).
                    collect(Collectors.toList());
            model.addAttribute("currencylist", currencylist);
            model = ControllerUtils.getErrors(bindingResult, model);
            return "exchange";
        }
        log.info(activeUser + " add record data " + exchangeRateDto);
        exchangeService.addExchangeRecord(exchangeRateDto);
        return "redirect:/exchange";

    }

    @GetMapping("delete/{id}")
    public String deleteRecord(@PathVariable("id") Long id, @AuthenticationPrincipal User activeUser) {
        exchangeService.deleteRecord(id);
        log.info(activeUser + " delete record data with id " + id);
        return "redirect:/exchange";
    }


}
