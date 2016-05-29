package ufg.es7.exe4;

/**
 * Created by Yuri on 12-May-16.
 */
public class SequencialMain {

    public static void main(String[] args) throws InterruptedException {
        GeradorNumeroPrimos g1 = new GeradorNumeroPrimos(1, 100000);
        Thread t1 = new Thread(g1);
        GeradorNumeroPrimos g2 = new GeradorNumeroPrimos(1, 200000);
        Thread t2 = new Thread(g2);
        GeradorNumeroPrimos g3 = new GeradorNumeroPrimos(1, 400000);
        Thread t3 = new Thread(g3);
        GeradorNumeroPrimos g4 = new GeradorNumeroPrimos(1, 700000);
        Thread t4 = new Thread(g4);
        GeradorNumeroPrimos g5 = new GeradorNumeroPrimos(1, 1000000);
        Thread t5 = new Thread(g5);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t5.start();
        t5.join();

        System.out.println("Thread 1: " + g1.getExecutionTime());
        System.out.println("Thread 2: " + g2.getExecutionTime());
        System.out.println("Thread 3: " + g3.getExecutionTime());
        System.out.println("Thread 4: " + g4.getExecutionTime());
        System.out.println("Thread 5: " + g5.getExecutionTime());

    }

}
