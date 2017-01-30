/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

import java.util.function.DoubleUnaryOperator;

/**
 *
 * @author Alesha
 */
public class ObjectClassesPackage {

    /**
     * Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.
     * 
     * Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
     * Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
     * 
     * Интервал интегрирования задается его конечными точками a и b, причем a<=b.
     * Для получения достаточно точного результата используйте шаг сетки не больше 10−6.
     * @param f
     * @param a
     * @param b
     * @return 
     */
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int n = 10000000;
        double dx = (b - a) * 1.0 / n;
        double  x, Integral = 0;
        for(int i = 0; i < n ; i++)
        {
            x = a + i * dx;
            Integral += f.applyAsDouble(x)*dx;
        }
        return Integral;
    }
    
}
