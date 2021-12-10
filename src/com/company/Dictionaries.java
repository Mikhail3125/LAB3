package com.company;

public class Dictionaries {
    private String[] surnames = {
            "Толкин",
            "Дик",
            "Стендаль",
            "Лавкрафт",
            "Стивенс"
    };
    private String[] genres = {
            "Фентези",
            "Научная Фанстастика",
            "Реализм",
            "Хоррор",
            "Приключение"
    };
    private String[] names = {
            "Хоббит",
            "Марионетки мироздания",
            "Арманс",
            "Зов Ктулху",
            "Остров сокровищ"
    };
    private String[] products = {
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

    public String[] getSurnames() {
        return this.surnames;
    }

    public String[] getGenres() {
        return this.genres;
    }

    public String[] getNames() {
        return names;
    }

    public String[] getProducts() {
        return products;
    }
}
