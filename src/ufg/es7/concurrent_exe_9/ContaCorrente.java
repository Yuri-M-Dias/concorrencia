package ufg.es7.concurrent_exe_9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yuri on 30/06/16.
 */
public class ContaCorrente {

    private Double saldo;
    private ReentrantReadWriteLock lock;

    public ContaCorrente(Double saldo) {
        this.saldo = saldo;
        this.lock = new ReentrantReadWriteLock();
    }

    public void sacar(final Double valor){
        Lock write = lock.writeLock();
        write.lock();
        try{
            if(valor <= this.saldo){
                this.saldo -= valor;
            } else {
                System.out.println("Não tem saldo("+ this.saldo+" para tirar: " + valor);
            }
        }finally {
            write.unlock();
        }
        System.out.println("Sacado: "+ valor + " saldo atual: " + this.saldo);
    }

    public void depositor(final Double valor){
        Lock write = lock.writeLock();
        write.lock();
        try{
            this.saldo += valor;
        }finally {
            write.unlock();
        }
        System.out.println("Depositado: "+ valor + " saldo atual: " + this.saldo);
    }

    public double getSaldo(){
        Lock read = lock.readLock();
        read.lock();
        double saldo = this.saldo;
        read.unlock();
        return saldo;
    }

}
