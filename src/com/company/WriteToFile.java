package com.company;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WriteToFile {
    public static String name = "triangles.txt";
    public static File fileName = new File(name);
    public static void Load(ArrayTriangle arrayTriangle){
        try
        {
            FileWriter writer = new FileWriter(fileName);
            int sizemasiv = ArrayTriangle.perimetr.size();
            for(int i = 0; i < sizemasiv; i++) {
                writer.write("Треугольник " + (1 + i) + ":"
                        + " AB "+ ArrayTriangle.sideAB.get(i)
                        + " BC " + ArrayTriangle.sideBC.get(i)
                        + " CA " + ArrayTriangle.sideCD.get(i)
                        + " A " + ArrayTriangle.angleA.get(i)
                        + " B " + ArrayTriangle.angleB.get(i)
                        + " C " + ArrayTriangle.angleC.get(i)
                        + " Площадь " + ArrayTriangle.square.get(i)
                        + " Периметр " + ArrayTriangle.perimetr.get(i) + "\n");
            }
            writer.close();
        }catch (Exception ex){

        }
    }

    public static void Read(File fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void Read2()
    {
        File dir = new File("src/autosave");
        File list [] = dir.listFiles();
        if(dir.isDirectory())
        {
            int i = 0;
            for(File item : list){
                if(item.isDirectory()){
                    System.out.println(i + "\t\t" + "Папка" + "\t\t" + item.getName() + "\t");
                }
                else{
                    System.out.println(i +"\t\t"+ "Фаил" +"\t\t"+ item.getName() + "\t");
                }
                i++;
            }
        }
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        if(num >= 0 && num <= list.length) {
            System.out.println(list[num]);
            Read(list[num]);
            copyFile(list[num], name,"");
            System.out.println("Файлы загружены.\n");
        }
        else {
            System.out.println("");
        }
    }
    public static String date(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss z");
        String dF = dateFormat.format( currentDate );
        return dF + ".txt";
    }

    public static void copyFile(File inputFile , String outputFile , String pathname) {
        try{
            FileInputStream inputStream = new FileInputStream(inputFile);
            File directory = new File(pathname);
            if(!directory.exists()){
                directory.mkdir();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(  pathname  + outputFile);
                byte [] bytes = new byte[inputStream.available()];
                int length;

                while ((length = inputStream.read(bytes)) != -1){
                    fileOutputStream.write(bytes,0,length);
                }
            } catch (Exception exception){
                System.out.println(exception);
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }
}
