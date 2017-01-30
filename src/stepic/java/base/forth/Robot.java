/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.forth;

/**
 *
 * @author Alesha
 */
public class Robot {
    //Direction, направление взгляда робота,  — это перечисление:

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
    public Direction getDirection() {
        // текущее направление взгляда
        return Direction.UP;
    }

    public int getX() {
        // текущая координата X
        return 0;
    }

    public int getY() {
        // текущая координата Y
        return 0;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
    
    /*
    реализовать метод который устанавливает соединение с роботом,
    отдает ему команду на перемещение в заданную точку и затем закрывает соединение,
    выполняя при необходимости повтор этой последовательности до трех раз.
    */
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robot = null;
        boolean needToClose = true;
        for (int i=0; i<3; i++) {
            try {
                robot = robotConnectionManager.getConnection();
                robot.moveRobotTo(toX, toY);
                return;
            }
            catch (RobotConnectionException e) {
                if(i==2){
                    if (robot != null)
                        robot.close();
                    needToClose = false;
                    throw e;
                }
            }
            catch (Exception ex) {
                try{
                    if ((robot != null) && needToClose){
                        robot.close();
                        needToClose = false;
                    }
                }
                catch(Exception exp){
                    //ignore
                }
                throw ex;
            }
            finally {
                try{
                    if ((robot != null) && needToClose)
                        robot.close();
                }
                catch(Exception exp){
                    //ignore
                }

            }
        }

    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }  

    /*
    Установка соединения может завершиться неуспешно,
    а также уже установленное соединение может внезапно разорваться. Всякое бывает.
    Поэтому любой метод RobotConnectionManager и RobotConnection может бросить непроверяемое исключение RobotConnectionException:
    */
    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /*
    За установку соединения отвечает RobotConnectionManager:
    Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение,
    через которое можно отдавать роботу команды.
    */
    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }    

    public static void moveRobot(Robot robot, int toX, int toY) {
        int cX, dX, cY, dY;
        Direction cDirect, pDirectX = Direction.RIGHT, pDirectY = Direction.UP;
        cX = robot.getX();// == 0;
        cY = robot.getY();// == 0;
        cDirect = robot.getDirection();// == Direction.UP       
        dX = toX-cX;
        dY = toY-cY;
        if (dX>0)
            pDirectX = Direction.RIGHT;
        else if (dX<0)
            pDirectX = Direction.LEFT;
                    
        if (dY>0)            
            pDirectY = Direction.UP;
        else if (dY<0)
            pDirectY = Direction.DOWN;
    
        if (dX!=0){
            while (cDirect!=pDirectX){
                robot.turnRight();
                cDirect = robot.getDirection();
            }
            for (int x=0; x!=Math.abs(dX); x++)
                robot.stepForward();
        }
        
        if (dY!=0){
            while (cDirect!=pDirectY){
                robot.turnLeft();
                cDirect = robot.getDirection();
            }
            for (int y=0; y!=Math.abs(dY); y++)
                robot.stepForward();
        }

    }    
}


