package com;

public class ComplexNumber {

    //for real and imaginary parts of complex numbers
    double real, img;

    //constructor to initialize the complex number
    ComplexNumber(double r, double i){
        this.real = r;
        this.img = i;
    }


    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2)
    {
        //creating a temporary complex number to hold the sum of two numbers
        ComplexNumber temp = new ComplexNumber(0, 0);

        temp.real = c1.real + c2.real;
        temp.img = c1.img + c2.img;

        //returning the output complex number
        return temp;
    }
}
