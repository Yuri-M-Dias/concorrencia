package ufg.es7;

import java.awt.*;
import java.awt.color.ColorSpace;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class Producer implements Runnable {
    PilhaSincronizada pilha;

    public Producer (PilhaSincronizada pilha){
        this.pilha = pilha;
    }

    @Override
    public void run() {
        int colorIdx;
        for (int i = 0; i < 40; i++) {
            colorIdx = (int) (Math.random() * Colors.color.length);
            pilha.push(colorIdx);
            System.out.println("Criado: " + Colors.color[colorIdx]);
            try{
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e){
            }
        }
    }
}
