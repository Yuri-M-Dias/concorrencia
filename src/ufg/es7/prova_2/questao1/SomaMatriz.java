package ufg.es7.prova_2.questao1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SomaMatriz {

    public static void main(String[] args) throws InterruptedException {
        int[][] matriz = new int[40][50];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 50; j++) {
                matriz[i][j] = i + j;
            }
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 40; i++) {
            SomaLinhaMatriz somaLinhaMatriz = new SomaLinhaMatriz(matriz, i);
            executor.execute(somaLinhaMatriz);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
