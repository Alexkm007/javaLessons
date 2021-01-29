package ru.alexkm07.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alexkm07.repos.UsersRepo;

@Service
public class UserService implements UserDetailsService {

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    private final UsersRepo usersRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepo.findByUsername(username);
    }
}
