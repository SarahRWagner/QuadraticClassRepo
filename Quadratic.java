/**
 * @author Sarah Wagner
 * @version 1.0
 * This class builds the Quadratic object. It has an a, b and c value. It can use a quadratic formula
 * to find different roots, derivatives and graph the equation. It also uses the Apache Commons Complex
 * package in order to deal with the complex numbers that could potentially come up.
 */
import org.apache.commons.math3.complex.Complex;


public class Quadratic
{
    // The data
    private double a;
    private double b;
    private double c;

    /**
     * This is the default constructor. It sets the quadratic to these values because these values for a, b and c will
     * always have real roots.
     */
    //Constructors
    public Quadratic()
    {
        this.a = 1.0;
        this.b = 2.0;
        this.c = 1.0;
    } // end of Quadratic class

    /**
     * This is the constructor that allows the user to create their own quadratic formula with different values for a, b
     * and c.
     * @param a  quadratic term
     * @param b  linear term
     * @param c  constant or y-intercept
     */
    public Quadratic(double a,double b, double c)
    {
        setA(a);
        setB(b);
        setC(c);
    } // end of customizable Quadratic class

    /**
     * This method gets the value of a from the user and returns it.
     * @return a
     */
    //getter
    public double getA()
    {
        return a;
    } // end of getA method

    /**
     * This method gets the value of b from the user and returns it.
     * @return b
     */
    public double getB()
    {
        return b;
    } // end of getB method

    /**
     * This method gets the value of c from the user and returns it.
     * @return c
     */
    public double getC()
    {
        return c;
    } // end of getC method

    /**
     * This method takes in a value for a from the user and sets a to that value.
     * @param a
     */
    //setter
    public void setA(double a)
    {
        this.a = a;
    } // end of setA method

    /**
     * This method takes in a value for b from the user and sets b to that value.
     * @param b
     */
    public void setB(double b)
    {
        this.b = b;
    } // end of setB method

    /**
     * This method takes in a value for c from the user and sets c to that value.
     * @param c
     */
    public void setC(double c)
    {
        this.c=c;
    } // end of setC method


    //toString

    /**
     * This method prints out the quadratic for the user to see.
     * @return String
     */
    public String toString()
    {
        return "This is the equation y=" + this.a + "x^2 +" + this.b + "x + " + this.c;
    } // end of toString method



    //Methods

    /**
     * This method determines if the root of the quadratic will be real or complex.
     * @return boolean
     */
    public boolean realOrComplexRoot()
    {
        double discriminant = (Math.pow(b, 2))-(4*a*c); // this will determine the discriminant, or the value under the radical
        if(discriminant < 0 || a == 0) // if the discriminant is 0 or the a value is 0 then the root will be complex
        {
            return false; // the root is complex because a negative under a radical is not a real number, or in the case that a is 0, you cannot divide by 0
        }
        else
        {
            return true; // the root is real because the discriminant is positive and a is not 0
        }
    } // end of realOrComplexRoot method

    /**
     * This method determines if the discriminant is negative or positive.
     * @return boolean
     */
    public boolean negativeOrPositive()
    {
        double discriminant = (Math.pow(b, 2))-(4*a*c); // this is finding the value of the discriminant
        if(discriminant < 0)
        {
            return false; // the discriminant is negative
        }
        else
        {
            return true; // the discriminant is positive
        }
    } // end of negativeOrPositive method

    /**
     * This method will find the derivative of the quadratic equation.
     * @param x  the x value will be the point on the line you wish to find
     * @return double  this is the derivative, or slope, value
     */
    public double derivative(double x)
    {

        return (2*a*x)+ b;
    } // end of derivative method

    /**
     * This method will find the roots of the equation, whether the roots will be real or complex.
     * @return realComplexRoots  this is the Complex array that will hold the root values
     */
    public Complex[] findRoots()
    {


        Complex [] realComplexRoots = new Complex[2]; // creating the Complex array


        if(realComplexRoots.equals(false)) // the method above finds if root will be complex, in this case if it is then do this...
        {
            double discriminant = (Math.pow(b, 2)) - (4 * a * c);  // find the value of the discriminant
            double realPart = -b / (2 * a); // this is the real number that makes up the first part of the quadratic formula

            // because the quadratic subtracts AND adds the discriminant, there need to be two different imaginary parts
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a); // this is when you add the discriminant
            double imaginaryPartTwo = -(Math.sqrt(-discriminant) / (2 * a)); // this is when you subtract the discriminant

            Complex complex1 = new Complex(realPart, imaginaryPart); // the first root
            Complex complex2 = new Complex(realPart, imaginaryPartTwo); // the second root

            realComplexRoots[0] = complex1; // add the two roots into an array, so that both can be
            realComplexRoots[1] = complex2; // passed back to main
        }
        else { // if the method above finds the roots are real...


            double realRoot = (-b + Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a); // this is adding the discriminant
            double realRootTwo = (-b - Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a); // this is subtracting the discriminant

            Complex real1 = new Complex(realRoot, 0); // because the method will only return a complex array the real roots need to go into a
            Complex real2 = new Complex(realRootTwo, 0); // complex array as well. A real number is technically an imaginary, just i = 0

            realComplexRoots[0] = real1; // add the two roots into the array
            realComplexRoots[1] = real2;
        } // end of if
        return realComplexRoots; // return the array back to main


    } // end of findRoots method






} // end of class


