/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.forth;

import java.util.function.DoubleUnaryOperator;

/**
 *
 * @author Alesha
 */
public class StackTrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte[] sqc = new byte[128]; 
        for (byte i=0; i<127; i++){
            sqc[i]=i;
        }
        
    }

    /*
    Реализуйте метод sqrt(), вычисляющий квадратный корень числа.
    В отличие от Math.sqrt(), это метод при передаче отрицательного параметра
    должен бросать исключение java.lang.IllegalArgumentException с сообщением "Expected non-negative number, got ?"
    */
    public static double sqrt(double x) {
        if (x<0)
            throw new java.lang.IllegalArgumentException ("Expected non-negative number, got "+Double.toString(x));
        return java.lang.Math.sqrt(x);
    }    
    
    /*
    Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
    Метод getCallerClassAndMethodName() должен возвращать имя класса и метода,
    откуда вызван метод, вызвавший данный утилитный метод.
    Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
    Это актуально, например, в библиотеках логирования,
    где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.    
    */
    public static String getCallerClassAndMethodName() {
        StackTraceElement ste[] = new Exception().getStackTrace();
        if (ste.length<3)
            return null;
        else {
            return ste[2].getClassName()+"#"+ste[2].getMethodName();
        }
    }
    
}
