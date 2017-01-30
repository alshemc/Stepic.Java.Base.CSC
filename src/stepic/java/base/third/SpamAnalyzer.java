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
public class SpamAnalyzer extends KeywordAnalyzer{

    private String[] keywords;
    
    //должен конструироваться от массива строк с ключевыми словами.
    //Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
    public SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }
    
    @Override
    public  String[] getKeywords() {
        return keywords;
    }
    
    @Override
    protected Label getLabel(){
        return Label.SPAM;
    }
    
}
