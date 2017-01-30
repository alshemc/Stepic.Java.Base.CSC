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
public class Timer {
    
    public long measureTime(Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }
}

