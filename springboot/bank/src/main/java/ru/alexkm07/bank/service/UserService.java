package ru.alexkm07.bank.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.repository.UserRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByName(String userName){
        return userRepository.findByUsername(userName);
    }

    public boolean addUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        saveUser(user);
        return true;
    }

    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public Model getDateForView(User rowUser, Model model, Long id){
        model.addAttribute("user", rowUser);
        Map<String,String> roles = new HashMap<>();
        User userFromBd = getById(id);
        for(Role role:Role.values()){
            if(userFromBd.getRoles().contains(role)){
                roles.put(role.name(),"checked");
            } else {
                roles.put(role.name(),"");
            }
        }
        model.addAttribute("user",rowUser);
        model.addAttribute("roles",roles.entrySet());
        if(rowUser.getActive()){
            model.addAttribute("active","checked");
        } else {
            model.addAttribute("active","");
        }

        return model;
    }

    public void updateUser(User rowUser){
        User userForUpdadte = userRepository.findById(rowUser.getId()).get();
        userForUpdadte.setActive(rowUser.getActive());
        userForUpdadte.setRoles(rowUser.getRoles());
        userForUpdadte.setUsername(rowUser.getUsername());
        userForUpdadte.setPassword(passwordEncoder.encode(rowUser.getPassword()));
        userForUpdadte.setEmail(rowUser.getEmail());
        userRepository.saveAndFlush(userForUpdadte);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
