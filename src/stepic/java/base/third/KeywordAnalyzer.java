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
public abstract class KeywordAnalyzer implements TextAnalyzer {
    
    /**
     *
     * @return 
     */
    protected abstract String[] getKeywords();
    
    protected abstract Label getLabel();
    
    @Override
    public Label processText(String text) {
        String[] keywords = getKeywords();
        String[] textArray = text.split("[-!\"#$%&')*+,./;<>?@_`{}~]|[\\\\]|[\\s]|[\\t]");
        for (String keyword: keywords){
            for (String word: textArray)
                if (word.equalsIgnoreCase(keyword))
                    return getLabel();
        }
        return Label.OK;
    }
    
}
