package ufg.es7.exe6.oito;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by root on 23/06/16.
 */
public class Lebre extends Thread {

    private int pista;
    private int distanciaAtual;
    private long executionTime;

    public Lebre(int pista, String nome) {
        super(nome);
        this.pista = pista;
        this.distanciaAtual = 0;
        this.executionTime = 0;
    }

    @Override
    public void run() {
        long before = System.nanoTime();
        while (distanciaAtual < pista){
            salta();
            yield();
        }
        long after = System.nanoTime();
        this.executionTime = after - before;
        Exercicio8.adicionaLista(this);
    }

    private void salta(){
        // Salta de 1 até 3
        int salto = ThreadLocalRandom.current().nextInt(1, 4);
        System.out.println("Lebre: " + Thread.currentThread().getName() + " saltou de " + distanciaAtual + " para: "
                + salto);
        this.distanciaAtual += salto;
    }

    public int getPista() {
        return pista;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }

    public int getDistanciaAtual() {
        return distanciaAtual;
    }

    public void setDistanciaAtual(int distanciaAtual) {
        this.distanciaAtual = distanciaAtual;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
