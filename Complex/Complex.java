import java.text.DecimalFormat;

import static java.lang.Math.*;


public class Complex {
    
    private double real_part;

    public double getReal_part()
    {
        return this.real_part;
    }

    public void setReal_part(double real_part)
    {
        this.real_part = real_part;
    }
    private double im_part;
    public double getIm_part()
    {
        return this.im_part;
    }
    public void setIm_part(double im_part)
    {
        this.im_part=im_part;
    }


    Complex(){
        real_part = 1;
        im_part = 1;
    }

    Complex(double re, double im){
        real_part = re;
        im_part = im;
    }

    public double Abs() {
        return sqrt(pow(this.im_part, 2) + pow(this.real_part, 2));
    }

    public double Argum(){
        if (this.real_part < 0){
            if (this.im_part > 0) {
                return PI + atan(this.im_part / this.real_part);
            }
            else{
                return -PI +atan(this.im_part / this.real_part);
            }
        }
        else
        {
            return atan(this.im_part / this.real_part);
        }
    }

    public void PrTrigForm(){

        Power(1);
    }

    public void Power(double n) {
        DecimalFormat df = new DecimalFormat();
        String ABS = df.format(this.Abs() * n);
        String ARGUM = df.format(this.Argum() * n);
        System.out.println(ABS + " *"+ " (" +"cos(" + ARGUM + ")" + " + " +"sin(" + ARGUM + ")" + "i" + ")");
    }

    public Complex add(Complex b)
    {
        Complex temp = new Complex();
        temp.im_part = this.im_part + b.im_part;
        temp.real_part = this.real_part + b.real_part;
        return temp;
    }

    public Complex sub(Complex b)
    {
        Complex temp = new Complex();
        temp.im_part = this.im_part - b.im_part;
        temp.real_part = this.real_part - b.real_part;
        return temp;
    }

    public Complex div(Complex b)
    {
        Complex temp = new Complex();
        temp.im_part = ((this.im_part * b.real_part) - (this.real_part * b.im_part))/(pow(b.real_part, 2) + pow(b.im_part, 2));
        temp.real_part = ((b.real_part * this.real_part) + (this.im_part * b.im_part))/(pow(b.real_part, 2) + pow(b.im_part, 2));
        return temp;
    }

    public Complex mul(Complex b)
    {
        Complex temp = new Complex();
        temp.im_part = (this.real_part * b.im_part) + (this.im_part * b.real_part );
        temp.real_part = (this.real_part * b.real_part) - (this.im_part * b.im_part);
        return temp;
    }

    public void PrAbsForm()
    {
        System.out.print(this.real_part + " + " + this.im_part + "i" + " ");
    }

}


