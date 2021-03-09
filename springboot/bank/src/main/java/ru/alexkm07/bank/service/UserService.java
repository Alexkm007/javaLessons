package ru.alexkm07.bank.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.alexkm07.bank.dto.UserDto;
import ru.alexkm07.bank.model.Role;
import ru.alexkm07.bank.model.User;
import ru.alexkm07.bank.repository.UserRepository;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto findByName(String userName) {
        return convertUserToUserDto(userRepository.findByUsername(userName));
    }

    public boolean addUser(UserDto user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        saveUser(user);
        return true;
    }

    public void saveUser(UserDto user) {
        userRepository.saveAndFlush(convertUserDtoToUser(user));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName);
    }

    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user:userList){
            userDtos.add(convertUserToUserDto(user));
        }
        return userDtos;
    }

    public UserDto getById(Long id) {
        return convertUserToUserDto(userRepository.findById(id).get());
    }

    public Model getDateForView(UserDto rowUser, Model model, Long id) {
        model.addAttribute("user", rowUser);
        Map<String, String> roles = new HashMap<>();
        if (!id.equals(0L)) {
            UserDto userFromBd = getById(id);
            for (Role role : Role.values()) {
                if (userFromBd.getRoles().contains(role)) {
                    roles.put(role.name(), "checked");
                } else {
                    roles.put(role.name(), "");
                }
            }
        } else {
            if(rowUser.getActive() == null) rowUser.setActive(false);
            if(rowUser.getEmail()==null) rowUser.setEmail("");
            if(rowUser.getUsername()==null) rowUser.setUsername("");
            if(rowUser.getRoles() == null) rowUser.setRoles(new HashSet<Role>());
            for (Role role : Role.values()) {
                if (rowUser.getRoles().contains(role)) {
                    roles.put(role.name(), "checked");
                } else {
                    roles.put(role.name(), "");
                }
            }
            model.addAttribute("adduser","true");

        }
        model.addAttribute("user", rowUser);
        model.addAttribute("roles", roles.entrySet());
        if (rowUser.getActive()) {
            model.addAttribute("active", "checked");
        } else {
            model.addAttribute("active", "");
        }

        return model;
    }

    public void updateUser(UserDto rowUser) {
        User userForUpdadte = userRepository.findById(rowUser.getId()).get();
        userForUpdadte.setActive(rowUser.getActive());
        userForUpdadte.setRoles(rowUser.getRoles());
        userForUpdadte.setUsername(rowUser.getUsername());
        userForUpdadte.setPassword(passwordEncoder.encode(rowUser.getPassword()));
        userForUpdadte.setEmail(rowUser.getEmail());
        userRepository.saveAndFlush(userForUpdadte);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserbyId(Long id){
        return userRepository.findById(id).get();
    }

    private User convertUserDtoToUser(UserDto userDto){

        User user = null;
        if(userDto.getId() != null && !userDto.getId().equals(0)){
            user = userRepository.findById(userDto.getId()).get();
        }

        if (user==null){
            user = new User();
        }

        if (user.getId().equals(0)) user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setRoles(userDto.getRoles());
        user.setActive(userDto.getActive());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto convertUserToUserDto(User user){

        UserDto userDto = new UserDto();
        if(user == null) return null;

        if(user.getId() != null){
        userDto.setId(user.getId());}
        userDto.setUsername(user.getUsername());
        userDto.setRoles(user.getRoles());
        userDto.setActive(user.getActive());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;

    }

}
