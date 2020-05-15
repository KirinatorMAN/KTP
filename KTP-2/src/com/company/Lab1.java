package com.company;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input Point");
        Point3d A = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println("Input Point");
        Point3d B = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println("Input Point");
        Point3d C = new Point3d(in.nextDouble(), in.nextDouble(), in.nextDouble());
        if (A.equals(B)||B.equals(C)||C.equals(A))
            System.out.println("Ошибка: Есть равные точки");
        else
            System.out.println("Площадь треугольника = " + computeArea(A, B, C));

    }
    public static double computeArea(Point3d first, Point3d second, Point3d third){
        double a = Math.sqrt(Math.pow(first.getX()  - second.getX() , 2) + Math.pow(first.getY()  - second.getY(), 2) + Math.pow(first.getZ()  - second.getZ(), 2));
        double b = Math.sqrt(Math.pow(second.getX()  - third.getX() , 2) + Math.pow(second.getY()  - third.getY(), 2) + Math.pow(second.getZ()  - third.getZ(), 2));
        double c = Math.sqrt(Math.pow(first.getX()  - third.getX() , 2) + Math.pow(first.getY()  - third.getY(), 2) + Math.pow(first.getZ()  - third.getZ(), 2));
        double p = (a + c + b) / 2;
        return Math.sqrt(p * (p - a) * (p - c) * (p - b));

    }
}
