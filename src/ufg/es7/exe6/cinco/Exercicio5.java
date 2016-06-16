package ufg.es7.exe6.cinco;

public class Exercicio5 {

    public static void main(String[] args) throws InterruptedException {
        Hora hora = new Hora();
        Thread thread1 = new Thread(hora);
        Notícia notícia = new Notícia();
        Thread thread2 = new Thread(notícia);
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("Exit!");
        System.exit(1);
    }

}
