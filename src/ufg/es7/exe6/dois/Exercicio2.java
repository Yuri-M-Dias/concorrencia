package ufg.es7.exe6.dois;

import java.util.ArrayList;
import java.util.List;

public class Exercicio2 extends Thread {

    public int[][] matriz = new int[50][50];
    public int coluna;

    public Exercicio2() {
    }

    public Exercicio2(int[][] matriz, int coluna) {
        this.matriz = matriz;
        this.coluna = coluna;
    }

    public static void main(String[] args) throws InterruptedException {
        Exercicio2 exe2 = new Exercicio2();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                exe2.matriz[i][j] = i + j;
            }
        }
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Exercicio2 umaThread = new Exercicio2(exe2.matriz, i);
            umaThread.start();
            threads.add(umaThread);
        }
        for (int i = 0; i < 50; i++) {
            int soma = 0;
            for (int j = 0; j < 50; j++) {
                soma += exe2.matriz[i][j];
            }
            System.out.println("Soma da linha " + i + " é " + soma);
        }

    }

    @Override
    public void run() {
        int somaColuna = 0;
        for (int j = 0; j < 50; j++) {
            somaColuna += this.matriz[j][this.coluna];
        }
        System.out.println("Soma da coluna " + this.coluna + " é " + somaColuna);
    }

}
