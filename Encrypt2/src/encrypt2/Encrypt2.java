/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt2;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
//import org.javatuples.KeyValue; 

/**
 *
 * @author neilp
 */
public class Encrypt2 {

    private static byte[] key;
    private static SecretKeySpec secretKey;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // TODO code application logic here
        int senderID = 1111, receiverID = 2222, amount = 100, counter = 1;
        
        String AESKey = "752EF0D8FB4958670DBA40AB1F3C1D0F8FB4958670DBA40AB1F3752EF0DC1D0F";

        String plainText = "1111222201000001";
       
        
        
        ///// CONVERT INTS TO BYTE ARRAY
        byte[] Block = ByteBuffer.allocate(4).putInt(senderID).array();
        byte[] Block2 = ByteBuffer.allocate(4).putInt(receiverID).array();
        byte[] Block3 = ByteBuffer.allocate(4).putInt(amount).array();
        byte[] Block4 = ByteBuffer.allocate(4).putInt(counter).array();
        
        byte[] wholeBlock = new byte[16];
        System.arraycopy(Block, 0, wholeBlock, 0,4);
        System.arraycopy(Block2, 0, wholeBlock, 4, 4);
        System.arraycopy(Block3, 0, wholeBlock, 8,4);
        System.arraycopy(Block4, 0, wholeBlock, 12,4);
        
        
        System.out.println(Arrays.toString(wholeBlock));
        
        /////////////////////////////////////////////////// 
        ///Token Generate
        byte[] byteC = TokenGen(AESKey, wholeBlock);
        
        
        StringBuilder sb = new StringBuilder();
        for (byte b : byteC) {
            sb.append(String.format("%02x", b & 0xff));
        };
        
        
        String byteCipher = sb.toString();
        System.out.println("Token = " + byteCipher);
        
        ////////////////////////////////////////////
        ////Token Verify: Should be same as wholeBlock
        
        
        TokenVerify(byteC);
        ///////////////////////////
        
        
        

    }

    public static byte[] TokenGen(String AESKey, byte[] plainText) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            KeyGenerator generator;
            generator = KeyGenerator.getInstance("AES");
            generator.init(256);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encrypt2.class.getName()).log(Level.SEVERE, null, ex);

        }

        // The AES key size in number of bits
        setKey(AESKey);

        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText);
        
        return byteCipherText;
    }
    
   public static byte[] TokenVerify(byte[] decryptedKey ) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
   {
       Cipher aesCipher1 = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            aesCipher1.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] bytePlainText = aesCipher1.doFinal(decryptedKey);
            String plainText1 = new String(bytePlainText);
        System.out.println("Unsigned Byte Block: "+Arrays.toString(bytePlainText));

       return bytePlainText;
   } 

    
    
    public static void setKey(String password) {
        MessageDigest sha = null;
        try {
            key = password.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
