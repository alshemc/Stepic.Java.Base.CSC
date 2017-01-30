/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.sixth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Alesha
 */
public class Streams {

    /*
    Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
        1. Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
        2. Первый элемент последовательности устанавливается равным этому числу.
        3. Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn^2),
        где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
    Например, mid(123456)=345
    
    Пример:
        pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
    13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

    //int i = (234/10 % 1000);
    //pseudoRandomStream(13).limit(30).mapToObj(x->" "+x).forEachOrdered(System.out::print);
    */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n->(int)((n*n)/10 % 1000));
    }

    private static IntStream mid(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
    Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
        minMaxConsumer.accept(min, max);
    Если стрим не содержит элементов, то вызовите
        minMaxConsumer.accept(null, null);    
    */
    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

        T s_min = null;
        T s_max = null;
        T[] streamArray;
        
        //сортируем поток в соответствии с Comparator и преобразуем в массив
        streamArray = (T[]) stream.sorted(order).toArray();
        
        if (streamArray.length==1){
            s_min = streamArray[0];
            s_max = streamArray[0];
            minMaxConsumer.accept(s_min, s_max);
        } else if (streamArray.length>1){
            s_min = streamArray[0];
            s_max = streamArray[streamArray.length-1];
            minMaxConsumer.accept(s_min, s_max);
        } else            
            minMaxConsumer.accept(s_min, s_max);
    }

    /*
    Напишите программу, читающую из System.in текст в кодировке UTF-8,
        подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
    Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
        Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
    Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
        Выводите слова в нижнем регистре.
    Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
    Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
        то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке. 
    
    //String s = "Мама мыла-мыла-мыла раму!";
    //String ss = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
    //checkBigText(ss);
    */
    private static void checkBigText(String str){
        Charset charset = Charset.forName("UTF-8");
        Reader reader = new InputStreamReader(System.in, charset);
        BufferedReader bufferedReader = new BufferedReader(reader);
  
        Stream<String> stream = bufferedReader.lines();
        Map<String, Long> collect =
            stream.map(line->line.split("[^\\pL\\pM\\p{Nd}\\p{Nl}\\p{Pc}[\\p{InEnclosedAlphanumerics}&&\\p{So}]]"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                //.forEach(System.out::println);
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
                //.flatMap(Map::entrySet().stream())
               
        collect.entrySet().stream().sorted((e1, e2) -> {
                int comp = e2.getValue().compareTo(e1.getValue());
                if (comp == 0) {
                    return -e2.getKey().compareTo(e1.getKey());
                }
                return comp;})
                .limit(11)
                .forEach(x -> System.out.println(x.getKey()));

        System.out.println(collect);
    }
    
    
}
