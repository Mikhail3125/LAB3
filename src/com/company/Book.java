package com.company;

public class Book {
    String author;
    String genre;
    String name;
    int edition;

    public Book() {
        String author;
        String genre;
        String name;
        int edition;
    }

    public Book(String author, String genre, String name, int edition) {
        this.author = author;
        this.genre = genre;
        this.name = name;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "{" + "Автор: '" + author +
                "\nЖанр: " + genre +
                "\nНазвание книги:" + name +
                "\nТираж:" + edition + '}';
    }
}
