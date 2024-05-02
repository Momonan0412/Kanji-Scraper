package com.example.kanjiscraper;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<JapaneseKanjiData> data = DatabaseUtilities.getKanjiData("Level 10");
//        for(JapaneseKanjiData d : data){
//            System.out.println(d.toString());
//        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("KanjiArray.txt"));
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("KanjiArray.txt"));
            ArrayList<Object> data2 = (ArrayList<Object>) objectInputStream.readObject();
            for(Object d : data2){
                System.out.println("READ! -> " + d.toString());
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
