/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.forth;

import java.util.logging.Level;

/**
 *
 * Класс, в котором скрыта логика настоящей почты
 * 
 * @author Alesha
 */
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}

/*
UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру
RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива MailService 
(результат вызова processMail первого элемента массива передается на вход processMail второго элемента,
и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.
*/
//public static class UntrustworthyMailWorker implements MailService{
class UntrustworthyMailWorker implements MailService{
    
    private MailService[] msArray;
    private RealMailService mRealMailService;
    public UntrustworthyMailWorker(MailService[] mService){
        msArray = mService;
        mRealMailService = new RealMailService();
    }
    
    public RealMailService getRealMailService(){
        return mRealMailService;
    }
    
    @Override
    public Sendable processMail(Sendable mail) {
        Sendable buff = null;
        for (int i = 0; i < this.msArray.length; i++) {

            if (i == 0) {
                buff = this.msArray[0].processMail(mail);
                continue;
            }

            buff = this.msArray[i].processMail(buff);
        }
        return getRealMailService().processMail(buff);

    }    
}

/*
2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
(в выражениях нужно заменить части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers",
то нужно написать в лог сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
*/
//public static class Spy implements MailService{
class Spy implements MailService{
    
    private static java.util.logging.Logger SpyLogger = null;
    
    public Spy(java.util.logging.Logger msLogger){
        SpyLogger = msLogger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        
        if (mail instanceof MailMessage) {
            if (mail.getFrom().equals("Austin Powers") || mail.getTo().equals("Austin Powers")) {
                SpyLogger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else {
                SpyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {mail.getFrom(), mail.getTo()});
            }
        }
        return mail;        
    }    
}

/*3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
Также, в данном классе должен присутствовать метод getStolenValue,
который возвращает суммарную стоимость всех посылок, которые он своровал.
Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую,
такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
*/
//public static class Thief implements MailService {
class Thief implements MailService {

        private int CostValue = 0;
        private int TotalCost = 0;
        MailPackage mailPackage;

        public Thief(int value) {
            this.CostValue = value;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= CostValue) {
                    TotalCost += ((MailPackage) mail).getContent().getPrice();
                    MailPackage mailPackage = new MailPackage( mail.getFrom(), mail.getTo(),new Package("stones instead of " + (((MailPackage) mail).getContent().getContent()).toString(), 0));
                    return mailPackage;
                }
                else {
                    return (MailPackage)mail;
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return TotalCost;
        }
    }

/*4) Inspector – Инспектор, который следит за запрещенными и украденными посылками
и бьет тревогу в виде исключения, если была обнаружена подобная посылка.
Если он заметил запрещенную посылку с одним из запрещенных содержимым ("weapons"
и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку,
состаящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
*/
//public static class Inspector implements MailService{
class Inspector implements MailService{
    
    public Inspector() {
        
    }

    @Override
    public Sendable processMail(Sendable mail) throws IllegalPackageException,StolenPackageException {
        String mpContent;
        if (mail instanceof MailPackage) {
            mpContent = ((MailPackage) mail).getContent().getContent();
                if (mpContent.contains("weapons")||mpContent.contains("banned substance")) {
                    throw new IllegalPackageException();
                }
                if (mpContent.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
    }    
}

//public static class IllegalPackageException extends RuntimeException {
class IllegalPackageException extends RuntimeException {
        public IllegalPackageException(){}    
    
        public IllegalPackageException(String message) {
            super(message);
        }

        public IllegalPackageException(String message, Throwable cause) {
            super(message, cause);
        }
}

//public static class StolenPackageException extends RuntimeException {
class StolenPackageException extends RuntimeException {

    public StolenPackageException(){}
            
        public StolenPackageException(String message) {
            super(message);
        }

        public StolenPackageException(String message, Throwable cause) {
            super(message, cause);
        }
}