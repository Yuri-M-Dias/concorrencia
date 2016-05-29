package ufg.es7;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class MinhaThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread começou: " + getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i + " : " + getName());
        }
        System.out.println("Thread terminou: " + getName());
    }
}
