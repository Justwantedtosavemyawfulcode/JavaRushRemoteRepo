package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.Util;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
////        List<User> users = userService.getAllDeletedUsers();
//        List<User> deletedUsers = new ArrayList<>();
//        for (User user : modelData.getUsers()) {
//            if (Util.isUserDeleted(user)) {
//                deletedUsers.add(user);
//            }
//        }
//        modelData.setUsers(deletedUsers);

    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
//        List<User> updatedUserList = new ArrayList<>(getAllUsers());
//        List<User> copy = new ArrayList<>(updatedUserList);
//        for (User user: copy) {
//            if (user.getId() == id) {
//                updatedUserList.remove(user);
//                User u = userService.deleteUser(id);
//                updatedUserList.add(u); // adding marked "deleted" User to updatedList
//            }
//        }
        modelData.setUsers(getAllUsers());
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(users);
    }


}
