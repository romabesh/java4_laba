package com.company;

import java.io.Serializable;

public class Triangle implements Serializable {
    private double lenght_ab;
    private double lenght_bc;
    private double lenght_ca;

    private double perimetr;
    private double radian = 57.2958;

    public double getLenght_ab() { return lenght_ab; }
    public double getLenght_bc() { return lenght_bc; }
    public double getLenght_ca() { return lenght_ca; }

    public void setLenght_ab(double lenght_ab) { this.lenght_ab = lenght_ab; }
    public void setLenght_bc(double lenght_bc) { this.lenght_bc = lenght_bc; }
    public void setLenght_ca(double lenght_ca) { this.lenght_ca = lenght_ca; }


    public static boolean CheckingIsoscelesTriangle(double lenght_ab,double lenght_bc,double lenght_ca){
        boolean bool;
        if(lenght_ab == lenght_bc && lenght_bc == lenght_ca){
            return bool = true;
        }
        else {
            return bool = false;
        }
    }

    public static boolean CheckingExistenceTriangle(double lenght_ab,double lenght_bc,double lenght_ca){
        boolean bool;
        if(lenght_ab + lenght_bc > lenght_ca && lenght_ab + lenght_ca > lenght_bc && lenght_bc + lenght_ca > lenght_ab ){
            return bool = true;
        }
        else {
            return bool = false;
        }
    }

    public double Perimetr(double lenght_ab,double lenght_bc,double lenght_ca) {
        perimetr = lenght_ab + lenght_bc + lenght_ca;
        return perimetr;
    }

    public double AreaTriangle(double lenght_ab,double lenght_bc,double lenght_ca){
        double p = perimetr/2;//полупериметр
        double area = Math.sqrt(p * (p - lenght_ab) * (p - lenght_bc) * (p - lenght_ca));
        return area;
    }

    public double CalculateAngle_A(double a,double b,double c) {
        double Angle_A = ((a * a) + (c * c) - (b * b)) / (2 * a * c);
        return Math.acos(Angle_A) * radian;
    }

    public double CalculateAngle_B(double a,double b,double c){
        double Angle_B = ((a * a) + (b * b) - (c * c)) / (2 * a * b);
        return Math.acos(Angle_B) * radian;
    }

    public double CalculateAngle_C(double a,double b,double c){
        return 180 - CalculateAngle_A(a, b, c) - CalculateAngle_B(a, b, c);
    }
}
