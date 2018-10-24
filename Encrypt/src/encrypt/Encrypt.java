/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

/**
 *
 * @author neilp
 */
import org.bouncycastle.pkcs.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.PublicKey;
import java.security.Security;


import java.util.Arrays;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;



import javax.crypto.Cipher;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.util.encoders.Base64;
//import org.junit.Test;

public class Encrypt {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
         Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    String publicKeyString = "CF9E0B601B6BD9335619470D3C22EED15D73B7D6D3AEB725FF4E458ED13D20D48027F2300A4346427E8" +
"FBB30C6F6C9E7AAC7B88AB3D376CCF5AF05E0B188CFA1F361F8B5B78C4E9EFC95A667B0AD26D5593FCAF629BB0" +
"98AAFC7DF6F523D51450C9B7BF1A62EE4D3466D4D69D6B6C5E8488A6BC2BC70B09ED96753BA248516B3";
    String cipherTextEMD1 ="4674726773D7A63748F15974BD70EEE545B6A8E52EBC2DE8DA03A28E539073EA9B8889D2467FA21C4AB" +
"2D75D18BB65D5CC1BBB5E0471759987E65012D850D28CBF1D1D31862895383E4C5EB9F75C7AF009BB5" +
"DD0D700880F009BB7E502B80E58C91CD5F95DF607BA1375EFDBBE8E919A65DE4801C0AE1D7C3316BD9" +
"F874AC1E1";
    Reader privateKeyReader = new StringReader(publicKeyString);
    PEMParser privatePemParser = new PEMParser(privateKeyReader);
    Object privateObject = privatePemParser.readObject();
     if (privateObject instanceof PEMKeyPair) {
    PEMKeyPair pemKeyPair = (PEMKeyPair) privateObject;
    
    JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
    
    PublicKey publicKey = converter.getPublicKey(pemKeyPair.getPublicKeyInfo());
    
    byte[] encrypted = cipherTextEMD1.getBytes();

     
    Cipher rsa;
    rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
    rsa.init(Cipher.DECRYPT_MODE, publicKey);
    byte[] utf8 = rsa.doFinal(encrypted);
    
    System.out.println(Arrays.toString(utf8));
     }
    }
    
}
