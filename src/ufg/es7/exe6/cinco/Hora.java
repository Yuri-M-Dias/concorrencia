package ufg.es7.exe6.cinco;

public class Hora implements Runnable {

    public Hora() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
