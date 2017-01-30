/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.forth;

/**
 *
 * @author Alesha
 */
public class BaseException {
    
    public static double sqrt(double x) {
            if (x<0)
                throw new java.lang.IllegalArgumentException ("Expected non-negative number, got " + Double.toString(x));

            return java.lang.Math.sqrt(x);
    }    
}

/**
 * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. 
 * Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
 * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
 * 
 */
class Test {
        public static void main(String[] args) {
            System.out.println(getCallerClassAndMethodName());
            anotherMethod();
        }

        private static void anotherMethod() {
            System.out.println(getCallerClassAndMethodName());
        }

        public static String getCallerClassAndMethodName() {
            StackTraceElement ste[] = new Exception().getStackTrace();
            if (ste.length<3)
                return null;
            else {
                return ste[2].getClassName()+"#"+ste[2].getMethodName();
            }
        }
}
        
