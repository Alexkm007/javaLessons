package ru.alexkm07.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexkm07.shop.model.products.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
