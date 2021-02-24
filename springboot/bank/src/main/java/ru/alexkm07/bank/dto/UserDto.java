package ru.alexkm07.bank.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alexkm07.bank.model.Account;
import ru.alexkm07.bank.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;
    @NotEmpty(message = "Username cannot be Empty")
    private String username;
    @NotEmpty(message = "Password cannot be Empty")
    private String password;
    @NotEmpty(message = "Email cannot be Empty")
    @Email(message = "Email is not correct")
    private String email;
    private Boolean active;
    private Set<Account> accountSet;
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
