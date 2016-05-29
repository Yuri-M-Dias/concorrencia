package ufg.es7;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class Operario implements Runnable {
    private String produto;
    private int tempo;

    public Operario(String produto, int tempo){
        this.produto = produto;
        this.tempo = tempo;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " " + produto);
            try{
                Thread.sleep((long) (Math.random() * tempo));
            } catch (InterruptedException e ){

            }
            System.out.println("Terminei " + produto);
        }
    }

}
