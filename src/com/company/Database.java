package com.company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public ArrayList<Book> list = new ArrayList<>();

    public Database() {
    }

    public void add(Book book) {
        this.list.add(book);
    }

    public Book get(int index) {
        return this.list.get(index);
    }

    public Book remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public String toString() {
        return "Database{" + list + '}';
    }

    public void save(String LAB3) throws IOException {
        FileWriter outStream = new FileWriter(LAB3);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Book book : this.list) {
            try {
                bw.write(book.getAuthor());
                bw.write(System.lineSeparator());
                bw.write(book.getGenre());
                bw.write(System.lineSeparator());
                bw.write(book.getName());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(book.getEdition()));
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        bw.close();
        outStream.close();
    }

    public void load(String LAB3) throws IOException {
        this.clear();
        //this.list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(LAB3));
        String author = "";
        String genre = "";
        String name = "";
        int edition = -1;
        while (scanner.hasNextLine()) {
            author = scanner.nextLine();
            genre = scanner.nextLine();
            name = scanner.nextLine();
            edition = Integer.parseInt(scanner.nextLine());
            this.list.add(new Book(author, genre, name, edition));
        }
        scanner.close();
    }

    public void clear() {
        this.list.clear();
    }

    public void serialize(String LAB3) {
        try {
            FileOutputStream fileOut = new FileOutputStream(LAB3);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.list);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deserialize(String LAB3) {
        try {
            FileInputStream fileIn = new FileInputStream(LAB3);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.list = (ArrayList<Book>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }
    }

    public void jacksonSerialize(String LAB3) throws IOException {
        new ObjectMapper().writeValue(new File(LAB3), this);
    }

    public void jacksonDeserialize(String LAB3) throws IOException {
        Database db1 = new ObjectMapper().readValue(new File(LAB3), Database.class);
        this.list = db1.list;
    }
    
    public void serializeFastJSON(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write(JSON.toJSONString(this.list));
        bw.close();
        outStream.close();
    }

    public void deserializeFastJSON(String LAB3) throws IOException {
        Scanner scanner = new Scanner(new FileReader(LAB3));
        this.clear();
        ArrayList<JSONObject> JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            this.add(new Book(st.getString("author"), st.getString("genre"), st.getString("name"), st.getIntValue("edition")));
        }
        scanner.close();
    }

    public void addBook(Book book) {
        this.list.add(book);
    }


}