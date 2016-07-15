package ufg.es7.prova_2.questao1;

public class SomaLinhaMatriz implements Runnable {

    private int[][] matriz;
    private int linhaASomar;
    private int resultado;

    public SomaLinhaMatriz(int[][] matriz, int linhaASomar) {
        this.matriz = matriz;
        this.linhaASomar = linhaASomar;
        this.resultado = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            resultado += matriz[linhaASomar][i];
        }
        System.out.println("Somatório da linha " + linhaASomar + " resultou " +
                "em " + resultado);
    }

}
