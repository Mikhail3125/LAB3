package com.company;

import java.io.Serializable;

public class Book implements Serializable {
    private String author;
    private String genre;
    private String name;
    private int edition;

    public Book() {
    }

    public Book(String author, String genre, String name, int edition) {
        this.author = author;
        this.genre = genre;
        this.name = name;
        this.edition = edition;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdition() {
        return this.edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "{" + "Автор: '" + this.author +
                "\nЖанр: " + this.genre +
                "\nНазвание книги:" + this.name +
                "\nТираж:" + this.edition + '}';
    }
}
