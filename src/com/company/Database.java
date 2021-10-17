package com.company;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

public abstract class Database<E> {
    ArrayList<E> list;

    public void save(ArrayList<E> list, String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.list);
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(String path) {
        try {
            if (new File(path).exists() == true || new File(path).length() != 0) {
                FileInputStream fileIn = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                this.list = (ArrayList<E>) in.readObject();

                in.close();
                fileIn.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
        }
    }

    public void fastJSave(String path) throws IOException {
        FileWriter outStream = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write(JSON.toJSONString(this.list));
        bw.close();
        outStream.close();
    }

    public void fastJLoad(String path) throws FileNotFoundException {
    }
}