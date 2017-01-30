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
public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = {":(", "=(", ":|"};
    
    public NegativeTextAnalyzer(){
        
    };
    
    @Override
    public  String[] getKeywords() {
        return keywords;
    }
    
    @Override
    protected Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
    
}
