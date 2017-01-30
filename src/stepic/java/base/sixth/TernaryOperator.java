/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.sixth;

import java.util.function.Function;
import java.util.function.Predicate;


/**
 *
 * @author Alesha
 */
public class TernaryOperator {

    /*
    Давайте научимся комбинировать функции в более сложные функции.
    Для примера построим следующую комбинацию. Дан предикат condition и две функции ifTrue и ifFalse.
    Напишите метод ternaryOperator, который из них построит новую функцию,
        возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.

    Пример использования метода (можно было все свернуть в одну строчку,
        но для наглядности все элементы вынесены в отдельные переменные):
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);    
    Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.
    */
    public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {

        return (T x)->{
            if (condition.test(x)) 
                return ifTrue.apply(x);
            else
                return ifFalse.apply(x);
        };     
    }
}
