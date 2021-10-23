package com.company;

public class Dictionaries {
    private static String[] surnames = {
            "Толкин",
            "Дик",
            "Стендаль",
            "Лавкрафт",
            "Стивенс"
    };
    private static String[] genres = {
            "Фентези",
            "Научная Фанстастика",
            "Реализм",
            "Хоррор",
            "Приключение"
    };
    private static String[] names = {
            "Хоббит",
            "Марионетки мироздания",
            "Арманс",
            "Зов Ктулху",
            "Остров сокровищ"
    };
    private static String[] products = {
            "Курица",
            "Масло",
            "Рыба",
            "Яблоко",
            "Груша",
            "Молоко",
            "Конфеты",
            "Печенье",
            "Помидор",
            "Картошка"
    };

    public static String[] getSurnames() {
        return surnames;
    }

    public static String[] getGenres() {
        return genres;
    }

    public static String[] getNames() {
        return names;
    }

    public static String[] getProducts() {
        return products;
    }
}
