package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();


        n += 1;
        List<Double> list = new ArrayList<Double>();
        while (n != 0) {
                list.add(scanner.nextDouble());
                --n;
        }



        Polynomial poly = new Polynomial(list);


        RootFinder rootFinder = new RootFinder(Math.pow(10,-6),poly, -2.1, -1.9 );




        List<ComplexNumber> roots = rootFinder.find();


        double real_sum = 0;
        double img_sum = 0;




        for (ComplexNumber root : roots) {
            if (root.getImg() >= 0 ) {
                real_sum += root.getReal();
                img_sum += root.getImg();

            }
        }


        System.out.println(real_sum + " " +  img_sum);
    }
}
