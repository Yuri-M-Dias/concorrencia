package ufg.es7;

import sun.applet.*;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class Trabalhador extends Thread {
    private String produto;
    private int tempo;

    public Trabalhador(String produto, int tempo) {
        this.produto = produto;
        this.tempo = tempo;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " " + produto);
            try {
                sleep((long) (Math.random() * tempo));
            } catch (InterruptedException e) {

            }
            System.out.println("Terminei " + produto);
            
        }
    }
}
