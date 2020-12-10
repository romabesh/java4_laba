package com.company;

public class EquilateralTriangle {
    public static void Equilateral(ArrayTriangle arrayTriangle){
        int sizemasiv = ArrayTriangle.perimetr.size();
        double maxPerimetr = 0;
        double earea = 0;
        double num = 0;
        double averagearea = 0;

        for(int i = 0; i < sizemasiv; i++) {
            if (ArrayTriangle.sideAB.get(i).equals(ArrayTriangle.sideBC.get(i)) && ArrayTriangle.sideBC.get(i).equals(ArrayTriangle.sideCD.get(i))){
                System.out.println("Треугольник " + (1 + i));
                System.out.println("Сторона AB " + ArrayTriangle.sideAB.get(i));
                System.out.println("Сторона BC " + ArrayTriangle.sideBC.get(i));
                System.out.println("Сторона CB " + ArrayTriangle.sideCD.get(i));
                System.out.println("Периметр " + ArrayTriangle.perimetr.get(i) +"\n");

                if(ArrayTriangle.square.get(i) > maxPerimetr)
                    maxPerimetr = ArrayTriangle.square.get(i);
            }
            else {
                num++;
                earea = earea + ArrayTriangle.square.get(i);
                averagearea = earea / num;

            }
        }
        System.out.println("Самый большой равносторонний треугольник " + maxPerimetr);
        System.out.println("Средняя площадь треугольников " + averagearea);
    }
}
