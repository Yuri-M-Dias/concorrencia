package ufg.es7.prova_2.questao2;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

public class Tartaruga implements Runnable {

    private int pista;
    private int distanciaAtual;
    private int passos;
    private String nome;

    public Tartaruga(int pista, String nome) {
        this.pista = pista;
        this.distanciaAtual = 0;
        this.passos = 0;
        this.nome = nome;
    }

    @Override
    public void run() {
        while (distanciaAtual < pista) {
            if (passos != 0 && passos % 10 == 0) {
                descansa();
            }
            anda();
        }
        CorridaTartarugas.adicionaLista(this);
    }

    private void descansa() {
        out.println("Tartaruga: " + nome + " andou "
                + this.distanciaAtual + "cm até agora.");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(0, 2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void anda() {
        int distanciaCm = ThreadLocalRandom.current().nextInt(0, 6);
        this.distanciaAtual += distanciaCm;
        this.passos++;
    }

    public String getNome() {
        return nome;
    }

    public int getPassos() {
        return passos;
    }
}
