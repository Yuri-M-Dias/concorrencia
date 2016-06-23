package ufg.es7.exe6.oito;

import java.util.ArrayList;

public class Exercicio8 {

    public static final int NUM_THREADS = 5;

    private static ArrayList<Lebre> threadsTerminadas = new ArrayList<>();
    private static int l = 0;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Lebre> threads = new ArrayList<>();
        for (int i = 1; i <= NUM_THREADS; i++) {
            Lebre lebre = new Lebre(20, String.valueOf(i));
            lebre.setPriority(i);
            lebre.start();
            threads.add(lebre);
        }
        for (Lebre thread: threads) {
            thread.join();
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Lebre: " + threadsTerminadas.get(i - 1).getName() + " no ranking: " + i);
        }
    }

    public synchronized static void adicionaLista(Lebre lebre){
        Exercicio8.threadsTerminadas.add(l, lebre);
        l++;
    }

}
