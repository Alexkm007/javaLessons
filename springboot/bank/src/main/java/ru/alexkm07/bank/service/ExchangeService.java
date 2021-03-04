package ru.alexkm07.bank.service;

import org.springframework.stereotype.Service;
import ru.alexkm07.bank.dto.ExchangeRateDto;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.ExchangeRate;
import ru.alexkm07.bank.repository.ExchangeRateRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<ExchangeRateDto> getAll(){
        List<ExchangeRate> allByDateAsc = exchangeRateRepository.findAllByOrderByDateDesc();
        List<ExchangeRateDto> exchangeRateDtos = new ArrayList<>();
        for(ExchangeRate exchangeRate:allByDateAsc){
            exchangeRateDtos.add(convertExchangeRateToExchangeRateDto(exchangeRate));
        }
        return exchangeRateDtos;
    }

    public void addExchangeRecord(ExchangeRateDto exchangeRateDto){
        ExchangeRate exchangeRate = convertExchangeRateDtoToExchangeRate(exchangeRateDto);
        exchangeRateRepository.save(exchangeRate);
    }

    public Double returnRate(Currency currency){
        ExchangeRate exchangeRate = exchangeRateRepository.findFirstByCurrencyOrderByDateDesc(currency);
        if( exchangeRate!=null )  return exchangeRate.getRate();
        return 0D;
    }

    public void deleteRecord(Long id){
        exchangeRateRepository.deleteById(id);
    }

    private ExchangeRateDto convertExchangeRateToExchangeRateDto(ExchangeRate exchangeRate){
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setRate(exchangeRate.getRate());
        exchangeRateDto.setCurrency(exchangeRate.getCurrency());
        exchangeRateDto.setId(exchangeRate.getId());
        exchangeRateDto.setDate(exchangeRate.getDate());
        return exchangeRateDto;
    }

    private ExchangeRate convertExchangeRateDtoToExchangeRate(ExchangeRateDto exchangeRateDto){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setRate(exchangeRateDto.getRate());
        exchangeRate.setCurrency(exchangeRateDto.getCurrency());
        exchangeRate.setId(exchangeRateDto.getId());
        exchangeRate.setDate(exchangeRateDto.getDate());
        return exchangeRate;
    }


}
