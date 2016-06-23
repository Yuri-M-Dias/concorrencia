package ufg.es7.exe6.nove;

/**
 * Created by root on 23/06/16.
 */
public class Consumer extends Thread {

    private Mailbox mailbox;

    public Consumer(Mailbox mailbox, String name) {
        super(name);
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        System.out.println("Iniciou: " + this.getName());
        for (int i = 0; i < 50; i++) {
            String message = null;
            try {
                message = mailbox.retrieveMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + this.getName() + " consumi: " + message);
        }
    }

}
