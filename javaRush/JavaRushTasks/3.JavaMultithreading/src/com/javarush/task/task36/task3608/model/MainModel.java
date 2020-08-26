package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    public void loadDeletedUsers() {
        modelData.setUsers(userService.getAllDeletedUsers());
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void loadUsers() {
        //modelData.setUsers(userService.getUsersBetweenLevels(1,100));
        modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }

    private List<User> getAllUsers(){
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name,id,level);
        loadUsers();
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        loadUsers();
    }
}
