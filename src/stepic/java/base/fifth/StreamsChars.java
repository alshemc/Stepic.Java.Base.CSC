/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.fifth;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author Alesha
 */
public class StreamsChars {
    
    /*
    Напишите программу, читающую текст из System.in и выводящую в System.out
    сумму всех встреченных в тексте вещественных чисел с точностью до шестого знака после запятой.
    Числом считается последовательность символов,
    отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
    */
    public static void main(String[] args) {
        double sum = 0;
        try (Scanner scan = new Scanner(System.in)) {
            while(scan.hasNext()){
                if (scan.hasNextDouble()) {
                    sum += Double.parseDouble(scan.next());
                } else {
                    scan.next();
                }
            }
            System.out.printf("%.6f", sum);
        } catch(Exception e) {
            System.out.printf("%.6f", 0);
        }        
    }    

    /*
    Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку,
    используя заданную кодировку.
    */
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        java.io.BufferedReader buff = new java.io.BufferedReader( new InputStreamReader (inputStream, charset));
        StringBuffer strBuff = new StringBuffer();
        int c;

        while ( ( c = buff.read() ) != -1 ) {
            strBuff.append( ( char )c );
        }
        return strBuff.toString();
    }    
    
}
