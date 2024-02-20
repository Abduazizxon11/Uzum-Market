package org.example.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BotButtonService {
    public ReplyKeyboardMarkup language() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83C\uDDFA\uD83C\uDDFF O'zbek tili");
        row.add(button1);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Русский язык \uD83C\uDDF7\uD83C\uDDFA");
        row.add(button2);

        rowList.add(row);
        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);

        return markup;
    }

    public InlineKeyboardMarkup sales() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setCallbackData("seller");
        button1.setText("Sotuvchi");
        row.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Sotib oluvchi");
        button2.setCallbackData("Mijoz");
        row.add(button2);

        rowList.add(row);
        markup.setKeyboard(rowList);

        return markup;
    }

    public InlineKeyboardMarkup cart() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Savatchani ko'rish");
        row.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Savatchadan olib tashlash");
        row.add(button2);

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Bosh sahifa");
        row.add(button3);

        return markup;
    }

    public static ReplyKeyboardMarkup mainMenuUserUz() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Katalogni ko'rish 📇");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Saralanganlar ❤️");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Savatchani ko'rish 🛒");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("💟 Buyurtmalarim");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("🙌 Support");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("🌐 Tilni o'zgartirish");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);


        return markup;
    }
    public static ReplyKeyboardMarkup mainMenuAdminUz() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Yangi maxsulot qo'shish");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Yangi Bo'lim qo'shish");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Barcha bo'limlar");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Men sotayotgan maxsulotlar");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);


        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);


        return markup;
    }
    public static ReplyKeyboardMarkup mainMenuAdminRu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Добавить новый продукт");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Добавить новый раздел");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Все разделы");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("Продукты, которые я продаю");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);


        rows.add(row1);
        rows.add(row2);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);


        return markup;
    }
    public static ReplyKeyboardMarkup mainMenuUserRu() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Посмотреть каталог 📇");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Квалифицирован ❤\uFE0F");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("Посмотреть корзину \uD83D\uDED2");

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83D\uDC9F Мои заказы");

        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83D\uDE4C Поддержка");

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF10 Изменить язык");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        markup.setKeyboard(rows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);

        return markup;
    }
}
