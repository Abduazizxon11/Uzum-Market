package org.example;

import org.example.States.BotState;
import org.example.States.Roles;
import org.example.model.User;
import org.example.service.BotButtonService;
import org.example.service.impl.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    UserServiceImpl userService = new UserServiceImpl();
    BotButtonService buttonService = new BotButtonService();
    List<User> users = new ArrayList<>();
    public MyBot(String botToken){
        super(botToken);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText() && update.hasMessage()){
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if (text.equals("/start") || text.equals("Orqaga")){
//                User user = new User(chatId, update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getUserName(), update.getMessage().getText(), BotState.LANG, Roles.USER);
//                try {
//                    userService.create(user);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                users.add(user);
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Assalomu aleykum. Tilni tanlang\n\n" +
                        "Привет. Выберите язык");
                message.setReplyMarkup(buttonService.language());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else {
                User user = userService.get(chatId);
                switch (user.getState()){

                    case LANG -> {
                        if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili")){
                            SendMessage txt = new SendMessage();
                            txt.setText("Yaxshi endi registratsiyani davom ettirish uchun botga qanday maqsadda kirganingizni yozing");
                            txt.setChatId(chatId);
                            txt.setReplyMarkup(buttonService.sales());
                            try {
                                execute(txt);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (text.equals("Русский язык \uD83C\uDDF7\uD83C\uDDFA")) {

                        }
                    }case REGISTRATION -> {

                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String data = update.getCallbackQuery().getMessage().getText();
            if (data.equals("Sotuvchi mijoz")) {
                userService.update(chatId, new User(chatId, "", "", "", null, Roles.ADMIN));
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Yaxshi. Endi akkauntingiz uchun parol kiriting");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                String pass = update.getMessage().getText();
                userService.update(chatId, new User(chatId, "", "", pass, null, Roles.ADMIN));
            }else if(data.equals("Mijoz")){
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("Yaxshi. Endi akkauntingiz uchun parol kiriting");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                String pass = update.getMessage().getText();
                userService.update(chatId, new User(chatId, "", "", pass, null, Roles.USER));
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "grape_market_bot";
    }
}
