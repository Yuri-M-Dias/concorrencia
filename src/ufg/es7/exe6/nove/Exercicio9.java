package ufg.es7.exe6.nove;

import java.util.ArrayList;

public class Exercicio9 {

    public static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> produtores = new ArrayList<>();
        ArrayList<Thread> consumidores = new ArrayList<>();
        Mailbox mailbox = new Mailbox();
        for (int i = 0; i < NUM_THREADS; i++) {
            Producer producer = new Producer(mailbox, "producer-" + i);
            Consumer consumer = new Consumer(mailbox, "consumer-" + i);
            producer.start();
            consumer.start();
            produtores.add(producer);
            consumidores.add(consumer);
        }
        System.out.println("Fim da main.");
    }

}
