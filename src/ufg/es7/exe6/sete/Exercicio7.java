package ufg.es7.exe6.sete;

import java.util.ArrayList;

public class Exercicio7 {

    public static int ACHOU = -1;
    private static final int MAX_ELEMS = 5000;

    public static void main(String[] args) throws InterruptedException {
        int[] ints = new int[MAX_ELEMS];
        for (int i = 0; i < MAX_ELEMS; i++) {
            ints[i] = i;
        }
        int x = 4875;
        int resultado = parallelSearch(x, ints, 5);
        if(resultado == -1){
            System.out.println("Não achei esse elemento!");
            return;
        }
        System.out.println("Resultado: " + resultado);
    }

    public static int parallelSearch(int x, int[] A, int numThreads) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            ArrayIterator arrayIterator = new ArrayIterator(A, numThreads, i, MAX_ELEMS, x);
            arrayIterator.start();
            threads.add(arrayIterator);
        }
        // Espera todas terminar, jeito burro
        for (Thread thread: threads) {
            thread.join();
        }
        // Se não achar, vai retornar -1 de qualquer jeito
        return ACHOU;
    }

    public static synchronized void setarValorAchado(int index){
        ACHOU = index;
    }

}
