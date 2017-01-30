/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.sixth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Alesha
 */
public class StreamsMail {

    /*
    В этой задаче вам предстоит самостоятельно написать набор классов таким образом,
        чтобы данный код успешно компилировался и выполнялся.
    Вам предстоит использовать новые знания про generics, коллекции и Stream API.
    В приведенном коде используется оператор assert. Этот оператор используется для того,
        чтобы проверять определенные инварианты в коде.
        С помощью него возможно писать небольшие тесты и следить за корректностью своей программы
        (в обычной ситуации предпочтительно для этих целей использовать библиотеки для модульного тестирования, которые выходят за рамки базового курса).
    Оператор выглядит следующим образом:
        assert предикат: сообщение;
        Предикат – выражение с типом boolean. Если выражение является ложным,
        то в программе возникает исключение AssertionError с соответствующим сообщением.
    По-умолчанию данная функциональность отключена. Чтобы ее включить,
        необходимо передать специальный ключ -ea в параметры виртуальной машины.
        Сделать это можно прямо при запуске в консоли с помощью программы java,
        либо указав этот ключ в настройках запуска программы в вашей IDE.
        В случае IntellijIDEA, например, эта опция указывается в поле
        Run -> Edit Configurations... -> конфигурация запуска вашей программы -> VM Options.
    Код, который необходимо заставить успешно работать:
        //checkMail();
    */
    private static void checkMail(){
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно. 
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft"): "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        //Получение и проверка словаря "почтового ящика",
        //где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ): "wrong mailService mailbox content (1)";

        System.out.println(mailBox.get("Christopher Nolan"));
        
        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ): "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(java.util.Collections.<String>emptyList()): "wrong mailService mailbox content (3)";

        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        System.out.println(salaries.get(salary1.getTo()));
        System.out.println(Arrays.asList(1));
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)): "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)): "wrong salaries mailbox content (3)";    
    }
    
    public interface Sendable<T>{
        public String getTo();
        public T getContent();
    }
    /*    
    public abstract class Sendable<T>{
        public String getTo(){return null;};
        public T getContent(){return null;};
    }
    */    
    //public static class MailMessage extends Sendable {
    public static class MailMessage implements Sendable<String> {
        private String sFrom; 
        private String sTo;
        private String sContent;
        public String getFrom(){
            return sFrom;
        }
        @Override
        public String getTo(){
            return sTo;
        }
        @Override
        public String getContent(){
            return sContent;
        }
        public MailMessage (String From, String To, String Content){
            sFrom = From; 
            sTo = To;
            sContent = Content;
        }
    }
    
    //public static class Salary extends Sendable {
    public static class Salary implements Sendable<Integer> {
        private String sJob; 
        private String sName;
        private Integer iSalary;
        
        public Salary(String Job, String Name, Integer Salary){
            sJob = Job;
            sName = Name;
            iSalary = Salary;
        }
        @Override
        public String getTo(){
            return sName;
        }

        @Override
        public Integer getContent() {
            return iSalary;
        }
    }
    
    public static class MailService<T> implements Consumer<Sendable<T>> {
        private final Map<String, List<T>> msMailBox;
        public MailService(){
            msMailBox = new HashMap<String, List<T>>() {
                @Override
                @SuppressWarnings("empty-statement")
                public List<T> get(Object key) {
                    if (msMailBox.containsKey(key)) {
                        return msMailBox.getOrDefault(key, null);
                    } else {
                        List<T> lst = new LinkedList<>();
                        msMailBox.put((String)key, lst);
                        return lst;
                        //return super.getOrDefault(key, new LinkedList<T>());
                    }
                }
            };
        }
        public Map<String, List<T>> getMailBox(){
            return msMailBox;
        }
        /**
         *
         * @param <error>
         * @param t
         */
        @Override
        public void accept(Sendable<T> t) {
            List lst = msMailBox.get(t.getTo());
            lst.add(t.getContent());
        }
    }
    
}
