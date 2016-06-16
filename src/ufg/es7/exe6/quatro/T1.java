package ufg.es7.exe6.quatro;

import java.util.ArrayList;
import java.util.List;

public class T1 extends Thread {

    public T1(int name) {
        super(String.valueOf(name));
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            T1 umaThread = new T1(i);
            umaThread.start();
            threads.add(umaThread);
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " executando.");
        }
    }
}
