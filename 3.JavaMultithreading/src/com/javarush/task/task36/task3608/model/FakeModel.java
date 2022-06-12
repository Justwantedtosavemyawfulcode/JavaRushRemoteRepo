package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        ArrayList<User> list = new ArrayList<>();
        User test1 = new User("test1", 1L, 1);
        User test2 = new User("test2", 2L, 2);
        list.add(test1);
        list.add(test2);
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void loadUserById(long userId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void changeUserData(String name, long id, int level) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
