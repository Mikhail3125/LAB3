//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//4 вариант
//   Базовый уровень
//   Вывести данные о книгах, тираж которых не превышает 10000 экземпляров.
//    Поля класса: Автор, Жанр, Название, Тираж
//      Средний уровень
//      Вывести наименование товара и конечную дату применения (годен до:).
//       Поля класса: Наименование, Дата производства, Срок годности, Цена, № серии
//Лаба 3
//Реализовать сериализацию данных в файл на диске для Задания №1 или №2 в виде отдельного класса с методами Save и Load.
// Использовать 2 способа: внешнюю библиотеку и нативную сериализацию.
// Предусмотреть автоматическое создание резервной копии файла данных при каждом запуске программы и восстановления данных из созданной копии при запуске.
//Выгрузить проект в репозиторий GitHub и добавить к нему описание в README (кратко, несколько строк пояснений по каждому заданию)
//Прикрепить ссылку на репозиторий в виде ответа на задание

package com.company;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static Random r = new Random();

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Введите количество книг:");
        int num = InputQuantity();
        Database db = new Database();
        Dictionaries dict = new Dictionaries();
        for (int i = 0; i < num; ++i) {
            Book book = new Book();
            book.setAuthor(dict.getSurnames()[r.nextInt(dict.getSurnames().length)]);
            book.setGenre(dict.getGenres()[r.nextInt(dict.getGenres().length)]);
            book.setName(dict.getNames()[r.nextInt(dict.getNames().length)]);
            book.setEdition(r.nextInt(15000) + 1);
            System.out.println("\nКнига №" + (i + 1) + ":" + book);
            db.addBook(book);

        }

        db.save("db.txt");
        db.clear();
        db.load("db.txt");
        db.serialize("db_s.txt");
        db.clear();
        db.deserialize("db_s.txt");
        db.jacksonSerialize("db_s.txt");
        db.clear();
        db.jacksonDeserialize("db_s.txt");
        num = r.nextInt(3) + 1;
        System.out.println("\n\n\nКоличество продуктов: " + num);
        Product[] product = new Product[num];
        Input_OutputProduct(product, num);
        System.out.println("\n" + db);

    }

    public static int InputQuantity() {
        int num = 0;
        Scanner amount = new Scanner(System.in);

        do {
            String number = amount.nextLine();

            try {
                num = Integer.parseInt(number);
            } catch (Exception var4) {
                System.out.println("Неверный ввод");
            }

            if (num < 1) {
                System.out.println("Неверный ввод");
            }
        } while (num < 1);

        amount.close();
        return num;
    }

    public static void InputData(Book[] books, int num) {
        Dictionaries dict = new Dictionaries();
        for (int i = 0; i < num; ++i) {
            books[i] = new Book();
            books[i].setAuthor(dict.getSurnames()[r.nextInt(dict.getSurnames().length)]);
            books[i].setGenre(dict.getGenres()[r.nextInt(dict.getGenres().length)]);
            books[i].setName(dict.getNames()[r.nextInt(dict.getNames().length)]);
            books[i].setEdition(r.nextInt(15000) + 1);
            System.out.println("\nКнига №" + (i + 1) + ":" + books[i]);

        }

    }

    //   Базовый уровень
    //   Вывести данные о книгах, тираж которых не превышает 10000 экземпляров.

    public static void OutputData(Book[] books, int num) {
        System.out.println("\n\nКнига тираж которой не превышает 10000: ");

        for (int i = 0; i < num; ++i) {
            if (books[i].getEdition() < 10000) {
                System.out.println("\n" + books[i]);

            }
        }

    }


    //      Средний уровень
//      Вывести наименование товара и конечную дату применения (годен до:).
    public static void Input_OutputProduct(Product[] product, int num) {
        Dictionaries dict = new Dictionaries();
        for (int i = 0; i < num; ++i) {
            product[i] = new Product();
            product[i].name = dict.getProducts()[r.nextInt(dict.getProducts().length)];

            System.out.println("\nНазвание товара: " + product[i].name);
            product[i].term = r.nextInt(363) + 1;
            int month = r.nextInt(9) + 1;
            int year = 2021;
            int day = r.nextInt(28) + 1;

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-M-y");

            product[i].produceDate = LocalDateTime.of(year, month, day, 0, 0);
            System.out.println("Срок: " + product[i].term);
            LocalDateTime var10001 = product[i].produceDate;
            System.out.println("Дата производства: " + var10001.format(dateFormatter));
            var10001 = product[i].produceDate;
            LocalDateTime L = var10001.plusDays(product[i].term);
            System.out.println("Годен до: " + L.format(dateFormatter));
            product[i].price = r.nextInt(500) + 1;
            product[i].N = r.nextInt(100000000) + 1;
            System.out.println("Цена:" + product[i].price);
            System.out.println("Серия:" + product[i].N);
        }

    }
}
