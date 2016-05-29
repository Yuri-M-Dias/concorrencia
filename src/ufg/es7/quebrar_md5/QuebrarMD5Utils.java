package ufg.es7.quebrar_md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Yuri on 19-May-16.
 */
public class QuebrarMD5Utils {

    public static String encodeMD5(String texto) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(texto.getBytes(), 0, texto.length());
            BigInteger i = new BigInteger(1, m.digest());
            return String.format("%1$032x", i);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
