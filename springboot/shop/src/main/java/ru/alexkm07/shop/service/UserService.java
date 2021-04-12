package ru.alexkm07.shop.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.alexkm07.shop.model.documents.users.User;
import ru.alexkm07.shop.repository.mongo.UserRepository;
import ru.alexkm07.shop.service.util.SequenceService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SequenceService sequenceService;

    public UserService(UserRepository userRepository, SequenceService sequenceService) {
        this.userRepository = userRepository;
        this.sequenceService = sequenceService;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        user.setDateCreation(LocalDateTime.now());
        user.setId(sequenceService.generateSequence(User.SEQUENCE_NAME));
        userRepository.save(user);
        return user;
    }

    public User update(User user){
        User userFromDb = userRepository.findById(user.getId()).get();
        BeanUtils.copyProperties(user,userFromDb,"id");
        userRepository.save(userFromDb);
        return userFromDb;
    }



}
