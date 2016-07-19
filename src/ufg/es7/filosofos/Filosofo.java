package ufg.es7.filosofos;

import java.util.Random;

public class Filosofo implements Runnable {

    private boolean cheio = false;
    private Random geradorTempoAleatorio = new Random();
    private int numeroTurnos;
    private final int id;
    private Garfo garfoEsquerda;
    private Garfo garfoDireita;

    public Filosofo(int id, Garfo garfoEsquerda, Garfo garfoDireita) {
        this.id = id;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
        this.numeroTurnos = 0;
    }

    @Override
    public void run() {
        try {
            while (!cheio) {
                pensa();
                if (garfoEsquerda.pega(this, "esquerda")) {
                    if (garfoDireita.pega(this, "direita")) {
                        come();
                        garfoDireita.devolve(this, "direita");
                    }
                    garfoEsquerda.devolve(this, "esquerda");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void come() throws InterruptedException {
        System.out.println(this + " está comendo!");
        numeroTurnos++;
        Thread.sleep(geradorTempoAleatorio.nextInt(1000));
    }

    private void pensa() throws InterruptedException {
        System.out.println(this + " está pensando...");
        Thread.sleep(geradorTempoAleatorio.nextInt(1000));
    }

    /**
     * Seta o filósofo como cheio, para parar o loop.
     */
    public void setCheio() {
        cheio = true;
    }

    public int getNumeroTurnos() {
        return numeroTurnos;
    }

    @Override
    public String toString() {
        return "Filosofo-" + id;
    }
}

