/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

/**
 *Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. 
 * По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.
 *
 * Класс AsciiCharSequence должен:
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 *
 * P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
 * 
 * AsciiCharSequence acs = new AsciiCharSequence(sqc);
 * System.out.println(acs.length());
 * System.out.println(acs.charAt(100));
 * System.out.println(acs.subSequence(0, 100));
 * System.out.println(acs.toString());
 * 
 * @author Alesha
 */
    
public class AsciiCharSequence implements java.lang.CharSequence /* extends/implements */ {
        // implementation
        private byte[] asciiCharSequence;
        public AsciiCharSequence(byte[] ByteSequence){
            asciiCharSequence = ByteSequence;
        }
        
        public int length(){
            return asciiCharSequence.length;
        }
        
        @Override
        public char charAt(int index) {
            return (char)asciiCharSequence[index];
        }
        
        @Override
        public CharSequence subSequence(int start,
                         int end){
            int size = (end-start);
            int j = 0;
            byte [] bss = new byte[size];
            for (int i=start; i<end; i++){
                bss[j]=asciiCharSequence[i];
                j++;
            }
            AsciiCharSequence cs = new AsciiCharSequence(bss);
            return cs;
        }
        
        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (int idx=0; idx<asciiCharSequence.length; idx++){
                str.append((char)asciiCharSequence[idx]);
            }
            return str.toString();
        } 
        
}    

