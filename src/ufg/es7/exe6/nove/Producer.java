package ufg.es7.exe6.nove;

/**
 * Created by root on 23/06/16.
 */
public class Producer extends Thread {

    private Mailbox mailbox;

    public Producer(Mailbox mailbox, String name) {
        super(name);
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        System.out.println("Iniciou: " + this.getName());
        for (int i = 0; i < 50; i++) {
            String message = "produto-" + i + "-" + this.getName();
            try {
                mailbox.storeMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer: " + this.getName() + " produzi: " + message);
        }
    }

}
