package ru.alexkm07.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.alexkm07.bank.model.ExchangeRate;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
}
