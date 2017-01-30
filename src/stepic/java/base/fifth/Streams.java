/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.fifth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Alesha
 */
public class Streams {

    /*
    По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
    На Unix-системах конец строки обозначается символом с кодом 10 ('\n'), на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').

    Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
    Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out.
    На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.

    Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'.
    Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.

    Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13.
    Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.

    Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush().
    Иначе часть выведенных вами данных не будет видна проверяющей системе.    
    */
    public static void main(String[] args) throws IOException {
        byte nChr, lChr;
            int i = 0;
            while ((nChr = (byte) System.in.read()) != -1){
                //nChr = buffer[i];
                if (nChr == 13){
                    lChr = nChr;
                    i++;
                    nChr = (byte) System.in.read();//buffer[i];
                    if (nChr == 10)
                        System.out.write(nChr);
                    else if (nChr != -1){
                        System.out.write(lChr);
                        System.out.write(nChr);
                    }
                } else if (nChr != -1){
                    System.out.write(nChr);
                    i++;
                }
            }
            System.out.flush();
    }    
    
    /*
    Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
    Контрольная сумма данных вычисляется по следующему алгоритму:
    1. Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
    2. Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле: Cn+1=rotateLeft(Cn) xor bn+1,
       где Cn — контрольная сумма первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево
       (чтобы не изобретать велосипед, используйте Integer.rotateLeft), bn - n-ный байт данных.
    Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
    Выброшенное из методов InputStream исключение должно выбрасываться из метода.    
    */
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int n, C = 0;
        while ((n = inputStream.read()) != -1) {
            C = Integer.rotateLeft(C,1)^n;
        }
        return C; 
    }    
    
    /*
    Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
    Массив байт устроен следующим образом. Сначала идет число типа int,
    записанное при помощи ObjectOutputStream.writeInt(size).
    Далее подряд записано указанное количество объектов типа Animal,
    сериализованных при помощи ObjectOutputStream.writeObject(animal).

    Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
    то метод должен бросить исключение java.lang.IllegalArgumentException.    
    */
    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        // your implementation here
        ArrayList<Animal> animalList = new ArrayList();
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            int cnt = ois.readInt();
            while (cnt>0){
                animalList.add((Animal)ois.readObject());
                cnt--;
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        
        Animal[] animalArray = new Animal[animalList.size()];
        for (int i = 0; i < animalList.size(); i++){
            animalArray[i] = animalList.get(i);
        }
        
        return animalArray;
    }
   
}
