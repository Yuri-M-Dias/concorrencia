package ufg.es7.concurrent_exe_10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercicio7WithExecutor {

    private static final int MAX_ELEMS = 5000;
    public static int ACHOU = -1;

    public static void main(String[] args) throws InterruptedException {
        int[] ints = new int[MAX_ELEMS];
        for (int i = 0; i < MAX_ELEMS; i++) {
            ints[i] = i;
        }
        int x = 3421;
        int resultado = parallelSearch(x, ints, 5);
        if (resultado == -1) {
            System.out.println("Não achei esse elemento!");
            return;
        }
        System.out.println("Resultado: " + resultado);
    }

    public static int parallelSearch(int x, int[] A, int numThreads) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < numThreads; i++) {
            ArrayIteratorExecutor arrayIterator = new ArrayIteratorExecutor(A, numThreads, i, MAX_ELEMS, x);
            executor.execute(arrayIterator);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        // Se não achar, vai retornar -1 de qualquer jeito
        return ACHOU;
    }

    public static synchronized void setarValorAchado(int index) {
        ACHOU = index;
    }

    public static synchronized boolean verificaValorAchado() {
        return ACHOU != -1;
    }
}
