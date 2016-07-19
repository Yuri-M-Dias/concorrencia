package ufg.es7.filosofos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Garfo {

    private Lock chave = new ReentrantLock();

    private final int id;

    /**
     * @param id identificador para facilitar as mensagens de resultado
     */
    public Garfo(int id) {
        this.id = id;
    }

    public boolean pega(Filosofo filosofo, String posicao) throws
            InterruptedException {
        if (chave.tryLock(10, TimeUnit.SECONDS)){
            System.out.println(filosofo + " pegou " + this + " na sua " +
                    posicao);
            return true;
        }
        return false;
    }

    public void devolve(Filosofo filosofo, String posicao) {
        chave.unlock();
        System.out.println(filosofo + " devolveu " + this + " na sua " + posicao);
    }

    @Override
    public String toString() {
        return "Garfo-" + id;
    }

}
