package ufg.es7.exe6.dois;

import ufg.es7.exe6.um.Exercicio1;

public class Exercicio2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread executor = new Thread(new Exercicio1());
            executor.start();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
