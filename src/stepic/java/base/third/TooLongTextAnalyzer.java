/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

/**
 *
 * @author Alesha
 */
public class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;
    
    //должен конструироваться от int'а с максимальной допустимой длиной комментария.
    //Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.
    public TooLongTextAnalyzer(int maxLength){
        this.maxLength = maxLength;
    }
    
    @Override
    public Label processText(String text) {
        if (text.length()>maxLength)
            return Label.TOO_LONG;
        else
            return Label.OK;
    }
    
}
