package com.company;

import java.util.ArrayList;
import java.io.Serializable;

public class ArrayTriangle {

    public static ArrayList<Double> perimetr = new ArrayList<Double>();
    public static ArrayList<Double> angleA = new ArrayList<Double>();
    public static ArrayList<Double> angleB = new ArrayList<Double>();
    public static ArrayList<Double> angleC = new ArrayList<Double>();
    public static ArrayList<Double> sideAB = new ArrayList<Double>();
    public static ArrayList<Double> sideBC = new ArrayList<Double>();
    public static ArrayList<Double> sideCD = new ArrayList<Double>();
    public static ArrayList<Double> square = new ArrayList<Double>();

    public static void Initialization(Triangle triangle){
        //side
        sideAB.add(triangle.getLenght_ab());
        sideBC.add(triangle.getLenght_bc());
        sideCD.add(triangle.getLenght_ca());
        //периметр
        perimetr.add(triangle.Perimetr(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()));
        //площадь
        square.add(triangle.AreaTriangle(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()));
        //angle
        angleA.add(triangle.CalculateAngle_A(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()));
        angleB.add(triangle.CalculateAngle_B(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()));
        angleC.add(triangle.CalculateAngle_C(triangle.getLenght_ab(), triangle.getLenght_bc(), triangle.getLenght_ca()));
    }
}
