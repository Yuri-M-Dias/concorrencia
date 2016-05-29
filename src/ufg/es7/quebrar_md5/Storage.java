package ufg.es7.quebrar_md5;

/**
 * Created by Yuri on 28-May-16.
 */
public class Storage {
    private Boolean isBroken;

    public Storage() {
        this.isBroken = false;
    }

    public synchronized boolean isBroken(){
        return this.isBroken;
    }

    // Só um deveria setar broken...Se tiver colisão, é problema do programador
    public void setBroken(){
        this.isBroken = true;
    }

}
