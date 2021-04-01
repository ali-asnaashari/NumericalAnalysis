package com;

import java.util.ArrayList;
import java.util.List;

public class Bairstow {

    private double r;
    private List<Double> c;
    private List<Double> b;
    private double s;
    private Polynomial poly;


    public Bairstow(double r, double s, Polynomial poly) {
        this.r = r;
        this.s = s;
        this.poly = poly;

        this.c = new ArrayList<Double>();
        this.b = new ArrayList<Double>();
    }


    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public Polynomial getPoly() {
        return poly;
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
    }


    public double calculate_b(int k) {

        int n = poly.getCoefficient().size() - 1;


        if ( k == ( n + 1 ) || k == ( n + 2 )){

            return 0;
        }


        double result = poly.getCoefficient().get(poly.getCoefficient().size() -1 - k) + r * calculate_b( k + 1 ) + s * calculate_b(k + 2);


        return result;
    }


    public double calculate_c(int k) {

        int n = poly.getCoefficient().size() - 1;

        if ( k == ( n + 1 ) || k == ( n + 2 )){

            return 0;
        }

        double result = calculate_b(k) + r * calculate_c( k + 1 ) + s * calculate_c(k + 2);


        return result;
    }


    public double calculate_d() {


        return this.c.get(0) * this.c.get(2) - Math.pow(this.c.get(1), 2);
    }


    public double calculate_d1() {

        return -this.b.get(0) * this.c.get(2) + this.c.get(1) * this.b.get(1);
    }


    public double calculate_d2() {

        return -this.c.get(0) * this.b.get(1) + this.c.get(1) * this.b.get(0);
    }


    public void update_values(){

        this.c = new ArrayList<>();
        this.b = new ArrayList<>();

        this.b.add(calculate_b(0));
        this.b.add(calculate_b(1));
        this.c.add(calculate_c(1));
        this.c.add(calculate_c(2));
        this.c.add(calculate_c(3));

    }

    public void do_iter() {


        update_values();




        double d = calculate_d();
        double d1 = calculate_d1();
        double d2 = calculate_d2();



        this.r = this.r + d1 / d;
        this.s = this.s + d2 / d;


    }


}
