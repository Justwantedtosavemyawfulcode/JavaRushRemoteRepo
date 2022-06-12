package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.Util;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        boolean deletedOrNot = modelData.isDisplayDeletedUserList();
        if (deletedOrNot == false) {
            System.out.println("All users:");
            for (User user:modelData.getUsers()) {
                System.out.println(String.format("\tUser{name='%s', id=%d, level=%d}", user.getName(), user.getId(), user.getLevel()));
            }
        }
        else {
            System.out.println("All deleted users:");
            for (User user:modelData.getUsers()) {
                if (Util.isUserDeleted(user)) {
                    System.out.println(String.format("\tUser{name='%s', id=%d, level=%d}", user.getName(), user.getId(), user.getLevel()));
                }
            }
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.setEditUserView(new EditUserView());
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


}
