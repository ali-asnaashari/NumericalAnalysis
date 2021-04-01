package com;

import java.lang.Math;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class Polynomial{

    private List<Double> coefficient;

    public Polynomial(List<Double> coefficient) {
        this.coefficient = coefficient;
    }

    public List<Double> getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(List<Double> coefficient) {
        this.coefficient = coefficient;
    }

    public double len(){

        double size =  this.coefficient.size() - 1;

        return size;
    }


    public static List<ComplexNumber> find_quadratic_root(double a, double b, double c){

        double delta = (b*b) -  (4 * a * c );

        List<ComplexNumber> roots = new ArrayList<>();

        if (delta < 0) {

            ComplexNumber r1 = new ComplexNumber(-b / (2 * a), Math.sqrt(Math.abs(delta)) / ( 2 * a ) );

            ComplexNumber r2 = new ComplexNumber(-b / (2 * a), -1*Math.sqrt(Math.abs(delta)) / ( 2 * a ) );

            roots.add(r1);
            roots.add(r2);
        }
        else if ( delta == 0 ) {

            ComplexNumber r = new ComplexNumber(-b/ ( 2 * a ), 0);

            roots.add(r);
        }

        else {

            ComplexNumber r1 = new ComplexNumber(-b / ( 2 * a ) + Math.sqrt(Math.abs(delta)/ ( 2 * a )), 0);
            ComplexNumber r2 = new ComplexNumber(-b / ( 2 * a ) - Math.sqrt(Math.abs(delta)/ ( 2 * a )), 0);

            roots.add(r1);
            roots.add(r2);

        }


        return roots;
    }


    public static Polynomial division(Polynomial poly_dividend, Polynomial poly_divisor){

        List<Double> dividend = poly_dividend.getCoefficient();
        List<Double> divisor = poly_divisor.getCoefficient();

        List<Double> out = dividend;


        double normalizer = divisor.get(0);

        int i = 0;
        for ( i = 0 ; i < (dividend.size() - (divisor.size() - 1)) ; ++i ) {

            double temp = out.get(i);

            temp /= normalizer;

            out.set(i, temp);

            double coef = out.get(i);

            if ( coef != 0 ) {
                 int j = 0 ;
                 for ( j = 1 ; j < divisor.size() ; ++j  ){

                     temp  = out.get(i + j);

                     temp += -1 * divisor.get(j) * coef;

                     out.set(i + j, temp);

                 }
            }

        }

        int sep = (divisor.size() - 1);

        int index = out.size() - sep;

        Polynomial result = new Polynomial(out.subList(0, index));

        return  result;

    }

}