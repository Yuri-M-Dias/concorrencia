package ufg.es7.exe6.oito;

import java.util.ArrayList;

public class Exercicio8 {

    public static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Lebre> threads = new ArrayList<>();
        for (int i = 1; i <= NUM_THREADS; i++) {
            Lebre lebre = new Lebre(20, String.valueOf(i));
            lebre.start();
            threads.add(lebre);
        }
        ArrayList<Long> quemTerminou = new ArrayList<>();
        // Espera todas terminar, jeito burro
        for (Lebre thread: threads) {
            thread.join();
            quemTerminou.add(Integer.valueOf(thread.getName()) - 1, thread.getExecutionTime());
        }
        Long ganhador = quemTerminou.stream().max(Long::compare).get();
        int indexGanhador = quemTerminou.indexOf(ganhador) + 1;
        // TODO!
        System.out.println("Ganhador foi: " + indexGanhador);
    }

}
