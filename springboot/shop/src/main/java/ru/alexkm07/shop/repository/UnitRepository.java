package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.reference.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
