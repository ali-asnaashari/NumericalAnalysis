package com;

import com.sun.xml.internal.ws.server.sei.EndpointResponseMessageBuilder;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class RootFinder {

    private double epsilon;
    private Polynomial poly;
    private double  r;
    private double s;
    private List<ComplexNumber> roots;

    public RootFinder(double epsilon, Polynomial poly, double r, double s) {
        this.epsilon = epsilon;
        this.poly = poly;
        this.r = r;
        this.s = s;
        this.roots = new ArrayList<>();
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public Polynomial getPoly() {
        return poly;
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
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


    public void do_iteration() {
        Bairstow bairstow = new Bairstow(this.r, this.s, this.poly);


        while (true) {

            double r = bairstow.getR();
            double s = bairstow.getS();
            bairstow.do_iter();


            if ( Math.abs(bairstow.getR() - r) < this.epsilon || Math.abs(bairstow.getS() - s) < this.epsilon){

                break ;

            }
        }


        List<ComplexNumber> poly_roots = Polynomial.find_quadratic_root(1, -bairstow.getR(), -bairstow.getS());

        this.roots.addAll(poly_roots);



        List<Double> temp = new ArrayList<>();
        temp.add(1.0);
        temp.add(-bairstow.getR());
        temp.add(-bairstow.getS());
        Polynomial res = new Polynomial(temp);
        this.poly = Polynomial.division(this.poly, res);



    }

    public boolean is_done(){
        if (this.poly.getCoefficient().size() - 1 == 0){
            return false;
        }
        return true;
    }

    public List<ComplexNumber> find(){


        while (true) {

            if ( !is_done() ){
                break;
            }

            if ((this.poly.getCoefficient().size() - 1 < 2)){

                this.roots.add(new ComplexNumber(-this.poly.getCoefficient().get(this.poly.getCoefficient().size() - 1 - 0) / this.poly.getCoefficient().get(this.poly.getCoefficient().size() - 1 - 1) , 0));
                break;
            }
            do_iteration();
        }

        return this.roots;
    }

}
