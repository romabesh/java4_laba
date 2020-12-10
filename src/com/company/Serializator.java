package com.company;

import java.io.*;

public class Serializator {

    public void  serialization(Triangle triangle){
        File file = new File("Serialization.txt");
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if(fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(triangle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Triangle deserialization() throws InvalidObjectException {
        File file = new File("Serialization.txt");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                Triangle triangle = (Triangle) ois.readObject();
                return triangle;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException(" ");
    }
}


