package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.alexkm07.bank.model.Currency;
import ru.alexkm07.bank.model.ExchangeRate;

import java.util.List;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
    public List<ExchangeRate> findAllByOrderByDateDesc();

    public ExchangeRate findFirstByCurrencyOrderByDateDesc(Currency currency);

}
