package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.model.Product;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final String fileName = "users.txt";


    List<User> users = new ArrayList<>();
    List<Product> products = new ArrayList<>();


    @Override
    public void create(User user) throws IOException {
        User user1 = new User(user.getChatId(), user.getFullName(), user.getUsername(), user.getState(), user.getRole(), user.getLang());
        users.add(user1);
    }

    @Override
    public void update(long chatId, User user) {
        for (int i = 0; i < users.size(); i++) {
            User user2 = users.get(i);
            if(chatId == user2.getChatId()){
                if(!user.getFullName().isEmpty()){
                    user2.setFullName(user.getFullName());
                }
                if(!user.getUsername().isEmpty()){
                    user2.setUsername(user.getUsername());
                }
                if(!user.getLang().equals(null)){
                    user2.setLang(user.getLang());
                }
                if(!user.getRole().equals(null)){
                    user2.setRole(user.getRole());
                }
                if(user.getState().equals(null)){
                    user2.setState(user.getState());
                }
                users.set(i, user2);
            }
        }
    }

    @Override
    public void delete(long chatId) {
        User temp = null;
        for (User user:users) {
            if (user.getChatId() == chatId){
                temp = user;
            }
        }if (temp != null){
            users.remove(temp);
        }
    }

    @Override
    public User get(long chatId) {
        for (int i = 0; i < users.size(); i ++){
            if (chatId == users.get(i).getChatId()) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public List<Product> basket() {
        return products;
    }
}
