package ufg.es7.exe6.cinco;

public class Notícia implements Runnable {

    public Notícia() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Notícia aleatória!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
