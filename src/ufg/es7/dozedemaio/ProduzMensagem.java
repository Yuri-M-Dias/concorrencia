package ufg.es7.dozedemaio;

import java.util.List;

public class ProduzMensagem implements Runnable {

    private List<String> mensagens;
    private int inicio;
    private int fim;

    public ProduzMensagem(List<String> mensagens, int inicio, int fim) {
        this.mensagens = mensagens;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        int i;
        for (i = this.inicio; i < this.fim ; i++) {
            synchronized (this.mensagens) {

            }

        }
    }

}
