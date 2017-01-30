/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.third;

/**
 *Представим, вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости, видео-хостинг, а может даже для системы онлайн-обучения :)
 * 
 * Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.
 * 
 * Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
 * Спам будем фильтровать по наличию указанных ключевых слов в тексте.
 * Негативное содержание будем определять по наличию одного из трех смайликов – :( =( :|
 * Слишком длинные комментарии будем определять исходя из данного числа – максимальной длины комментария.
 * 
 * @author Alesha
 */
public interface TextAnalyzer {
   Label processText(String text); 
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}
