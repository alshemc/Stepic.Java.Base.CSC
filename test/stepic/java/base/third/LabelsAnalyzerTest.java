/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alesha
 */
public class LabelsAnalyzerTest {
    
    private LabelsAnalyzer labelAnalyzer;
    
    public LabelsAnalyzerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkLabels method, of class LabelsAnalyzer.
     */
    @Test
    public void testCheckLabels() {
        System.out.println("checkLabels");
        TextAnalyzer[] analyzers = new TextAnalyzer[3];
        String[] kw = {"first", "second"};
        analyzers[0] = new SpamAnalyzer(kw);
        analyzers[1] = new NegativeTextAnalyzer();
        analyzers[2] = new TooLongTextAnalyzer(20);
        String text = "this is first test, and it is spam";
        LabelsAnalyzer instance = new LabelsAnalyzer();
        Label expResult = Label.SPAM;
        Label result = instance.checkLabels(analyzers, text);
        assertEquals(expResult, result);
        
        text = "this is sad :(";
        expResult = Label.NEGATIVE_TEXT;
        result = instance.checkLabels(analyzers, text);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
