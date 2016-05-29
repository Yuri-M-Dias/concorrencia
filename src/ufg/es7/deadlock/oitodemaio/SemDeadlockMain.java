package ufg.es7.deadlock.oitodemaio;

/**
 * Created by Yuri on 08-May-16.
 */
public class SemDeadlockMain {

    public static void main(String[] args) {
        CaixaSemDeadlock caixa = new CaixaSemDeadlock();

        // Demora um pouco para ele chegar no deadlock, mas assim é mais
        // vísivel o problema.
        ClienteSemDeadlock daniel = new ClienteSemDeadlock("daniel", caixa);
        daniel.start();

        ClienteSemDeadlock gabriela = new ClienteSemDeadlock("gabriela", caixa);
        gabriela.start();
        ClienteSemDeadlock lucasA = new ClienteSemDeadlock("lucasA", caixa);
        lucasA.start();
        ClienteSemDeadlock lucasH = new ClienteSemDeadlock("lucasH", caixa);
        lucasH.start();
        ClienteSemDeadlock marcos = new ClienteSemDeadlock("marcos", caixa);
        marcos.start();
        ClienteSemDeadlock gustavo = new ClienteSemDeadlock("gustavo", caixa);
        gustavo.start();
        for (int i = 0; i < 50; i++) {
            ClienteSemDeadlock clienteAleatorio = new ClienteSemDeadlock
                    (String.valueOf(i), caixa);
            clienteAleatorio.start();
        }
    }

}
