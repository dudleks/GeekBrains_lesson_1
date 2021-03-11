package com.gb.adudarev.level2.lesson7.server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {


    private class UserData {
        String login;
        String nickName;
        String password;

        public UserData(String login, String nickName, String password) {
            this.login = login;
            this.nickName = nickName;
            this.password = password;
        }
    }

    List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new UserData("login" + i, "nickName" + i, "password" + i));
        }
        users.add(new UserData("asd", "alex", "123"));
        users.add(new UserData("qwe", "pavel", "123"));
        users.add(new UserData("zxc", "vladimir", "123"));
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        for (UserData user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.nickName;
            }

        }
        return null;
    }

}
