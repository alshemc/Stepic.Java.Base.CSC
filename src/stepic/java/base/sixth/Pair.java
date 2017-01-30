/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.sixth;

import java.util.Objects;
import java.util.Optional;

/**
 * Реализуйте generic-класс Pair, похожий на Optional,
 * но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
 * а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
 * 
 * С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
 * Pair<Integer, String> pair = Pair.of(1, "hello");
 * Integer i = pair.getFirst(); // 1
 * String s = pair.getSecond(); // "hello"
 * 
 * Pair<Integer, String> pair2 = Pair.of(1, "hello");
 * boolean mustBeTrue = pair.equals(pair2); // true!
 * boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
 * 
 * @author Alesha
 * @param <F>
 * @param <S>
 */
public class Pair<F, S> {
    private Pair (F fval, S sval){
        this.fValue = fval;
        this.sValue = sval;
    }            
    private F fValue;
    private S sValue;
    
    public F getFirst(){
        return fValue;
    }
    public S getSecond(){
        return sValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!Objects.equals(this.fValue, other.fValue)) {
            return false;
        }
        if (!Objects.equals(this.sValue, other.sValue)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.fValue);
        hash = 43 * hash + Objects.hashCode(this.sValue);
        return hash;
    }
    
    public static <F, S> Pair<F, S> of(F fV, S sV){
        return new Pair<> (fV, sV);
        /*if ((sValue==sV)&&(fV==fValue))
            return this;
        else
            return null;
        */
        
    }

}
