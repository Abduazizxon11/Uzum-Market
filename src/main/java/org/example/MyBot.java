package org.example;

import org.example.States.BotState;
import org.example.States.Lang;
import org.example.States.Roles;
import org.example.model.User;
import org.example.service.BotButtonService;
import org.example.service.impl.UserServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
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
                User user = new User(chatId, update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName(), update.getMessage().getFrom().getUserName(), BotState.LANG, Roles.USER, null);
                try {
                    userService.create(user);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                users.add(user);
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
                            user.setLang(Lang.UZ);
                            SendMessage txt = new SendMessage();
                            txt.setText("Yaxshi endi registratsiyani davom ettirish uchun botga qanday maqsadda kirganingizni tanlang");
                            txt.setChatId(chatId);
                            txt.setReplyMarkup(buttonService.sales());
                            try {
                                execute(txt);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (text.equals("Русский язык \uD83C\uDDF7\uD83C\uDDFA")) {

                        }
                    }case MAIN -> {
                        if (user.getLang().equals(Lang.UZ) && user.getRole().equals(Roles.ADMIN)){
                            SendMessage message = new SendMessage();
                            message.setChatId(chatId);
                            message.setReplyMarkup(buttonService.mainMenuAdminUz());
                            message.setText("Amalni tanlang");
                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (user.getLang().equals(Lang.RU) && user.getRole().equals(Roles.ADMIN)) {
                            SendMessage message = new SendMessage();
                            message.setChatId(chatId);
                            message.setReplyMarkup(buttonService.mainMenuAdminRu());
                            message.setText("Выберите действие");
                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getMessage().getChatId();
            String data = update.getCallbackQuery().getMessage().getText();
            User user = userService.get(chatId);

            if (data.equals("seller")) {
                user.setRole(Roles.ADMIN);
                SendMessage message = new SendMessage();
                message.setText("seller");
                message.setChatId(chatId);
                System.out.println(user.toString());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else if(data.equals("Mijoz")){
                user.setRole(Roles.USER);
            }
            userService.update(chatId,user);
        }
    }

    @Override
    public String getBotUsername() {
        return "grape_market_bot";
    }
}
