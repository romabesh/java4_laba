package com.company;
import java.io.File;
import java.io.InvalidObjectException;
import java.util.Scanner;

public class Main {
    public static Triangle triangle = new Triangle();
    public static ArrayTriangle arrayTriangle = new ArrayTriangle();
    public static EquilateralTriangle equilateralTriangle = new EquilateralTriangle();

    public static String name = "triangles.txt";
    public static File fileName = new File(name);

    public static boolean bool = true;

    public static void main(String[] args) {
        WriteToFile.copyFile(fileName,WriteToFile.date(),"src/autosave/");
        for (; ; ) {
            Scanner in = new Scanner(System.in);

            if (bool == true) {
                Menu.ToString();
                int Menu = in.nextInt();
                switch (Menu) {
                    case 1://ввод
                        System.out.println("Введите стороны AB BC CD");
                        double numberforside_ab;
                        double numberforside_bc;
                        double numberforside_ca;
                        while (true) {
                            try {
                                numberforside_ab = Double.parseDouble(in.next());
                                if (numberforside_ab > 0) {
                                    break;
                                } else {
                                    System.out.println("Пожалуйста повторите попытку!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Пожалуйста повторите попытку!");
                            }
                        }
                        triangle.setLenght_ab(numberforside_ab);
                        while (true) {
                            try {
                                numberforside_bc = Double.parseDouble(in.next());
                                if (numberforside_bc > 0) {
                                    break;
                                } else {
                                    System.out.println("Пожалуйста повторите попытку!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Пожалуйста повторите попытку!");
                            }
                        }
                        triangle.setLenght_bc(numberforside_bc);
                        while (true) {
                            try {
                                numberforside_ca = Double.parseDouble(in.next());
                                if (numberforside_ca > 0) {
                                    break;
                                } else {
                                    System.out.println("Пожалуйста повторите попытку!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Пожалуйста повторите попытку!");
                            }
                        }
                        triangle.setLenght_ca(numberforside_ca);

                        if (Triangle.CheckingExistenceTriangle(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()) == true) {
                            arrayTriangle.Initialization(triangle);
                        } else {
                            System.out.println("Это не треугольник");
                        }
                        WriteToFile.Load(arrayTriangle);
                        Serializator serializator = new Serializator();
                        serializator.serialization(triangle);
                        try {
                           Triangle triangle = serializator.deserialization();
                            System.out.println(triangle.getLenght_ab());
                            System.out.println(triangle.getLenght_bc());
                            System.out.println(triangle.getLenght_ca());
                        } catch (InvalidObjectException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 2://вывод
                        WriteToFile.Read(fileName);
                        break;
                    case 3://удаление
                        System.out.println("Выберете нужный столбец для удаления :");

                        int remove = in.nextInt() - 1;
                        ArrayTriangle.sideAB.remove(remove);
                        ArrayTriangle.sideBC.remove(remove);
                        ArrayTriangle.sideCD.remove(remove);
                        ArrayTriangle.angleA.remove(remove);
                        ArrayTriangle.angleB.remove(remove);
                        ArrayTriangle.angleC.remove(remove);
                        ArrayTriangle.square.remove(remove);
                        ArrayTriangle.perimetr.remove(remove);
                        WriteToFile.Load(arrayTriangle);
                        break;
                    case 4:
                        equilateralTriangle.Equilateral(arrayTriangle);
                        break;
                    case 5://выход
                        WriteToFile.Read2();
                        break;
                    case 6://выход
                        bool = false;
                        break;
                }
            } else
                break;
        }
    }
}