package ufg.es7;

import java.util.regex.PatternSyntaxException;

/**
 * Created by Yuri on 28-Apr-16.
 */
public class Construcao {

    public static void main(String[] args) {
        Operario biu = new Operario("chinelo", 100);
        Operario rai = new Operario("sandalia", 500);
        Thread t1 = new Thread(biu);
        Thread t2 = new Thread(rai);
        t1.start();
        t2.start();

    }

}
