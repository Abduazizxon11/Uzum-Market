package org.example.model;

import org.example.States.BotState;
import org.example.States.Lang;
import org.example.States.Roles;

public class User {
    private long chatId;
    private String fullName;
    private String username;
    private BotState state;
    private Roles role;
    private Lang lang;

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public BotState getState() {
        return state;
    }

    public void setState(BotState state) {
        this.state = state;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public User(long chatId, String fullName, String username, BotState state, Roles role, Lang lang) {
        this.chatId = chatId;
        this.fullName = fullName;
        this.username = username;
        this.state = state;
        this.role = role;
        this.lang = lang;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", state=" + state +
                ", role=" + role +
                ", lang=" + lang +
                '}';
    }
}
