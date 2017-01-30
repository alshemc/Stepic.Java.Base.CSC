/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.second;

import java.math.BigInteger;

/**
 *
 * @author Alesha
 */
public class BaseSyntaxis {

    /**
     * Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые).Во всех остальных случаях метод должен возвращать false.
     * Воспользуйтесь шаблоном кода, который предлагает система. Ввод-вывод будет сделан за вас.
     * Вам надо только проанализировать переданные в метод booleanExpression значения (a, b, c, d) и вернуть результат.
     * Попробуйте составить формулу с использованием булевых операторов.
     * Если не получается, вернитесь к этому заданию после просмотра степов про условные операторы и циклы.
     * @param a
     * @param b
     * @param c
     * @param d
     * @return 
     */
    public boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a&b&(!c)&(!d))^(a&(!b)&c&(!d))^(a&(!b)&(!c)&d)^
                ((!a)&b&c&(!d))^((!a)&b&(!c)&d)^((!a)&(!b)&c&d));
    }
    
    /**
     * В Григорианском календаре год является високосным в двух случаях:
     *  либо он кратен 4, но при этом не кратен 100, либо кратен 400.
     * Реализуйте метод, вычисляющий количество високосных лет с начала нашей эры (первого года) до заданного года включительно.
     * На самом деле Григорианский календарь был введен значительно позже, но здесь для упрощения мы распространяем его действие на всю нашу эру.
    */
    public static int leapYearCount(int year) {
        int leapYear = year/4 - year/100 + year/400;
        return leapYear;
    }    
    
    /**
    * @param a
     * @param b
     * @param c
     * @return 
     */
    public long longExpression(int a, int b, int c) {
        return ((100000000000L % a)) >> b | (100 / c);
    }
    
    /**
     * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
     * Допустимая погрешность – 0.0001 (1E-4)
     * @param a
     * @param b
     * @param c
     * @return 
     */
    public boolean doubleExpression(double a, double b, double c) {
        /*
           double temp = a+b;
            BigDecimal decimal = new BigDecimal(temp);
            decimal = decimal.setScale(1, BigDecimal.ROUND_DOWN);
            if (decimal.doubleValue()==c){
                return true;
            }else {
                return false;
            }*/
            if ((a+b)-((a+b)%0.0000000000000001)==c) {
                return true;
            } else {return false;}
        //turn a + b == c;
    }    
    
    /**
     * Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
     * Данная задача актуальна, например, при работе с битовыми полями.
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return (value^((int)Math.pow(2,(bitIndex-1)))); // put your implementation here
    }    
 
    /**
     * Реализуйте метод, который возвращает букву,
     * стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
     */
    public char charExpression(int a) {
        return ((char)('\\' + a));
    }
    
    /**
     * Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
     * 
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        double src = Math.log(Math.abs(value))/Math.log(2);
        int res = (int)src; //целая часть
        double dres = src - res; //дробная часть
        return (dres == 0); // you implementation here
    }

    /**
     * Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
     * Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
     * При определении "палиндромности" строки должны учитываться только буквы и цифры.
     * А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
     * Гарантируется, что в метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).
     * Т.е. русских, китайских и прочих экзотических символов в строке не будет.
     * 
     * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
     * Подсказки (не читайте, если хотите решить сами):
     *  для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением "[^a-zA-Z0-9]";
     *  найдите в классе String метод, выполняющий замену по регулярному выражению;
     *  для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(), который находится в классе StringBuilder;
     *  в классе String есть методы для преобразования всей строки в верхний и нижний регистр.
     */
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^A-Za-z1-9]+", "");
        java.lang.StringBuilder sbtext = new java.lang.StringBuilder(text);
        String rtext = sbtext.reverse().toString();
        return text.equalsIgnoreCase(rtext);
    }
    
    /**
     * Реализуйте метод, вычисляющий факториал заданного натурального числа.
     *  Факториал N
     *  вычисляется как 1⋅2⋅...⋅N
     * Поскольку это очень быстро растущая функция, то даже для небольших N
     *  вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
     * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
     * @param value
     * @return 
     */
    //вычисление факториала
    public static BigInteger factorial(int value) {
        // your implementation here
        BigInteger answ = BigInteger.ONE;
        if (value==1){
            return answ;
        }
        if (value<=0){
            answ = BigInteger.ZERO;
            return answ;
        }
        answ = BigInteger.valueOf(value);
        BigInteger bigIntegerRes = answ.multiply(factorial(value-1));
        return bigIntegerRes; 
    }
    
    /**
     * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив.
     *  Массивы могут быть любой длины, в том числе нулевой.
     * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
     *  он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
     *  Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
     *  К сожалению, автоматически это не проверить, так что это остается на вашей совести.
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
            if (a1 == null)
                    return a2;
            if (a2 == null)
                    return a1;
            int[] r = new int[a1.length + a2.length];
            int j1 = 0;
            int j2 = 0;
            for (int i=0; i<r.length; i++){
                if ( (j1<a1.length) && (j2<a2.length) ){
                    if (a1[j1] < a2[j2]){
                        r[i] = a1[j1];
                        j1++;
                    } else {
                        r[i] = a2[j2];
                        j2++;                        
                    }
                } else if (j1<a1.length) {
                    r[i] = a1[j1];
                    j1++;
                } else if (j2<a2.length) {
                    r[i] = a2[j2];
                    j2++; 
                }
            }
            //System.arraycopy(a1, 0, r, 0, a1.length);
            //System.arraycopy(a2, 0, r, a1.length, a2.length);
            //java.util.Arrays.sort(r);
            return r;
    }
    
    /**
     * Вам дан список ролей и сценарий пьесы в виде массива строчек.
     * Каждая строчка сценария пьесы дана в следующем виде:
     *  Роль: текст
     *  Текст может содержать любые символы.
     * Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:
     * Роль:
     *  i) текст
     *  j) текст2
     *  ...
     *  ==перевод строки==
     *  i и j -- номера строк в сценарии. Индексация строчек начинается с единицы,
     *  выводить группы следует в соответствии с порядком ролей. Переводы строк между группами обязательны,
     *  переводы строк в конце текста не учитываются.
     * Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно,
     *  неправильная сборка результирующей строчки может выйти за ограничение по времени.
     * Обратите внимание еще на несколько нюансов:
     *  имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
     *  название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
     *  роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
     *  в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
     *  будьте внимательны, не добавляйте лишних пробелов в конце строк.
     * @param roles
     * @param textLines
     * @return 
     */
    static private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder answ = new StringBuilder();
        String sRole, sText;
        StringBuilder bRole, bText;
        int sizeRoles = roles.length;
        int sizeTexts = textLines.length;
        int i,j;
        for (i=0; i<sizeRoles; i++){
            bRole = new StringBuilder(roles[i]);
            bRole.append(":");
            sRole = bRole.toString();
            bRole.append('\n');
            answ.append(bRole.toString());
            for (j=0; j<sizeTexts; j++){
                if (textLines[j].length()>=sRole.length()){
                    sText = textLines[j].substring(0, sRole.length());
                    if (sText.compareTo(sRole)==0) {
                        bText = new StringBuilder(textLines[j]);
                        bText.replace(0, sRole.length(), String.valueOf(j+1)+")");
                        bText.append('\n');
                        answ.append(bText.toString());
                    }
                }
            }
            answ.append('\n');
        }
        return answ.toString();
    }
    
}
