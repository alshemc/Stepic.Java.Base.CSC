package stepic.java.base.forth;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
 * 
 * @author Alesha
 */
public interface MailService {
    Sendable processMail(Sendable mail);    
}
