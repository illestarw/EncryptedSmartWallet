/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.*;
/**
 *
 * @author Illestar
 */
public class Account {
    private int WID;
    private int balance;
    // private  RSAkey;             // pending for implementation of RSAPublicKey interface
    private Key enc_key;
    private int[][] synced_wallets;
    
    /* Initialize account */
    Account() {
        WID = 5000; // set to a temporary number before being assigned to avoid conflict during testing
        balance = 0;
        // enc_key = "752EF0D8FB4958670DBA40AB1F3C1D0F8FB4958670DBA40AB1F3752EF0DC1D0F";
        
        
        
        /*
        Key k = new RSAPublicKey();
        
        
        
        byte[] encodedKey = decoder.decodeBuffer(keyString);
        Key key = new SecretKeySpec(encodedKey,0,encodedKey.length, "DES");
        */
    }
    
    /* Deposit (accept) money */
    public void deposit(String enc_hash) {
        // decrypt enc_hash using bank public key
    }
    
    /* Transfer money */
    public void transfer(int amount) {
        
    }
    
    /* Synchronize between wallets (Initial handshakes) */
    /* token format [WIDa, WIDb, amount=0, counter=0] */
    public void sync() {
        // accept a token and decrypt into handshake message 
    }
           
}
