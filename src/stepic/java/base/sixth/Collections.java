/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.sixth;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author Alesha
 */
public class Collections {

    /*
    Напишите программу, которая прочитает из System.in последовательность целых чисел,
        разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
        и затем выведет получившуюся последовательность в обратном порядке в System.out.
    Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
    В этом задании надо написать программу целиком.    
    */
    public static void main(String[] args) throws IOException {
            Integer ielem;
            int i=0;
            ArrayDeque ad = new ArrayDeque();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) {
                ielem = sc.nextInt();
                if (i%2 != 0)
                    ad.add(ielem);
                i++;
            }
            Iterator <Integer> di = ad.descendingIterator();
            while (di.hasNext()){
                ielem = di.next();
                System.out.print(ielem.toString() + " ");
            } 
            System.out.flush();
    }      
    
    /*
    Реализуйте метод, вычисляющий симметрическую разность двух множеств.
    Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
    Пример:
    Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
    */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> words1 = new HashSet<T>(set1);
        words1.removeAll(set2);//retainAll(set2)
        Set<T> words2 = new HashSet<T>(set2);
        words2.removeAll(set1);//retainAll(set2)
        words1.addAll(words2);
        return words1;

        /*  нативный вариант      
        Set <T> setres = new HashSet<>();
        T element;
        
        Iterator <? extends T> it = set1.iterator();
        while (set1.iterator().hasNext ()){
            element = it.next();
            if (!set2.contains(element))
                setres.add(element);
        }
        
        it = set2.iterator();
        while (set2.iterator().hasNext ()){
            element = it.next();
            if (!set1.contains(element))
                setres.add(element);
        }        
        return setres;
        */        
    }        
    
}
