package ufg.es7;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class PilhaSincronizada {

    private int index = 0;
    private int[] buffer = new int[10];

    public synchronized int pop(){
        index--;
        return buffer[index];
    }

    public synchronized void push(int i){
        buffer[index] = i;
        index++;
    }
}
