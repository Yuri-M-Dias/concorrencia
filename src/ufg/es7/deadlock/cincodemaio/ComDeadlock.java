package ufg.es7.deadlock.cincodemaio;

/**
 * Created by Yuri on 05-May-16.
 */
public class ComDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Caixa caixa = new Caixa();

        // Demora um pouco para ele chegar no deadlock, mas assim é mais
        // vísivel o problema.
        Cliente daniel = new Cliente("daniel", caixa);
        daniel.start();

        Cliente gabriela = new Cliente("gabriela", caixa);
        gabriela.start();

        Cliente lucasA = new Cliente("lucasA", caixa);
        lucasA.start();
        Cliente lucasH = new Cliente("lucasH", caixa);
        lucasH.start();
        Cliente marcos = new Cliente("marcos", caixa);
        marcos.start();
        Cliente gustavo = new Cliente("gustavo", caixa);
        gustavo.start();
    }

}
