package qrcodegenerator.example.user.qrcodegenerator;

import android.util.Base64;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
//import sun.misc.*;

/**
 * Created by user on 6/29/16.
 */
public class AESencryption {

    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] {'N','P', 'T','S','y','s','t','e','m','2','0','1','4','-','1','6'};

    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();

        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);

        return encryptedValue;
    }

    /*public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();

        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);

        return decryptedValue;
    }*/

    private static Key generateKey() throws Exception {

        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;

    }

}
