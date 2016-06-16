package ufg.es7.exe6.tres;

public class Contador implements Runnable {

    public Contador() {

    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}
