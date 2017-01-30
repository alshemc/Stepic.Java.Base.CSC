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
public class LabelsAnalyzer {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label result = Label.OK;
        for (TextAnalyzer analyzer: analyzers){
            result = analyzer.processText(text);
            if (result != Label.OK)
                break;
        }
        return result;
    }
}
