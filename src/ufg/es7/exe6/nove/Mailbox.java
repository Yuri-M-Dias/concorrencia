package ufg.es7.exe6.nove;

/**
 * Created by root on 23/06/16.
 */
public class Mailbox {

    private String message = null;

    public synchronized void storeMessage(String message) throws InterruptedException {
        while(this.message != null){
            wait();
        }
        this.message = message;
        notifyAll();
    }

    public synchronized String retrieveMessage() throws InterruptedException {
        while (message == null){
            wait();
        }
        String localMessage = message;
        this.message = null;
        notifyAll();
        return localMessage;
    }

}
