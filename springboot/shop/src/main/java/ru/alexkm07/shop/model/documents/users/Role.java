package ru.alexkm07.shop.model.documents.users;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Manager,
    Customer,
    Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}
