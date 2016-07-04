package ufg.es7.concurrent_exe_10;

/**
 * Created by root on 23/06/16.
 */
public class ArrayIteratorExecutor extends Thread {

    private int[] array;
    private int offset;
    private int inicio;
    private int max;
    private int x;

    public ArrayIteratorExecutor(int[] array, int offset, int inicio, int max, int x) {
        this.array = array;
        this.offset = offset;
        this.inicio = inicio;
        this.max = max;
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = this.inicio; i < this.max; i += this.offset) {
            if(Exercicio7WithExecutor.verificaValorAchado()) break;
            System.out.println("Calculando " + i + " começo: " + this.inicio);
            if (array[i] == x) {
                System.out.println("Achei no: " + i);
                Exercicio7WithExecutor.setarValorAchado(i);
                break;
            }
        }
    }

}
