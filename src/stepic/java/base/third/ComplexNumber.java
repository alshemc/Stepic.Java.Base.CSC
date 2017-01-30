/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

/**
 *
 * @author Alesha
 */
public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + (int) (Double.doubleToLongBits(this.re) ^ (Double.doubleToLongBits(this.re) >>> 32));
            hash = 37 * hash + (int) (Double.doubleToLongBits(this.im) ^ (Double.doubleToLongBits(this.im) >>> 32));
            return hash;
        }
        
        @Override
        public boolean equals(Object anObject) {
            if (this == anObject)
                return true;
            if (anObject instanceof ComplexNumber) {   
                if ((this.re == ((ComplexNumber)anObject).re)&&(this.im == ((ComplexNumber)anObject).im))
                       return true; 
            }
            return false;
        }
}

