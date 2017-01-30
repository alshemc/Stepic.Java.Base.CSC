/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.forth;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 *
 * @author Alesha
 */
public class ConfigureLogging {
    //В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
    //Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.
    private static void configureLogging() {
        // your implementation here
        Logger classA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger classB = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger classJ = Logger.getLogger("org.stepic.java");
        classA.setLevel(Level.ALL);
        classB.setLevel(Level.WARNING);
        classJ.setLevel(Level.ALL);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());

        classJ.addHandler(consoleHandler);
        classJ.setUseParentHandlers(false);
        
    }
}
