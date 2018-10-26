package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servlet.LoginCredential;
import java.security.*;
/**
 *
 * @author Illestar
 */
public class Account {
    private String id; // user id
    private int WID;
    private int balance;
    // private  RSAkey;             // pending for implementation of RSAPublicKey interface
    // private Key enc_key;
    private int[][] synced;
    
    /* Initialize account */
    Account(String id, int hash) {
        this.id = id;
        this.WID = hash; // use easy hash algorithm for WID
        balance = 1000; // distribute 1000 for each account during initialize
        synced = new int[2][50]; // supports up to 50 matchings at the moment (WID, counter)
        
        // enc_key = "752EF0D8FB4958670DBA40AB1F3C1D0F8FB4958670DBA40AB1F3752EF0DC1D0F";
        /*
        Key k = new RSAPublicKey();
        byte[] encodedKey = decoder.decodeBuffer(keyString);
        Key key = new SecretKeySpec(encodedKey,0,encodedKey.length, "DES");
        */
    }
    
    /* Display current balance */
    public int getBalance() {
        return this.balance;
    }
    
    /* Deposit (accept) money */
    public void deposit(int amount) {
        // decrypt enc_hash using bank public key (TBD)
        this.balance += amount;
    }
    
    /* send money */
    public String send(int amount, int WIDrcv) {
        // AES encryption
        String token = "";
        
        // Generate tokens [WIDsnd, WIDrcv, amount, counter]
        return token;
    }
    
    /* receive money */
    public void receive(String token) {
        int WIDsnd, WIDrcv, amount, counter, counter_this, f;
        WIDsnd = WIDrcv = amount = counter = 0;
        f = 0; // flag for validating if this is an acceptable money receive request, 1=yes
        
        // AES decryption
        
        // Extract [WIDsnd, WIDrcv, amount, counter]
        
        // validate the records in synced table
        if (WIDrcv == this.WID)
            for (int[] i : synced)
                if (i[0] == WIDsnd)
                    if (i[1] == counter - 1)
                        f = 1;
        
        if (f == 0) {
            System.err.println("Unmatching Info : Not a valid receive token"); // considering return alert code (int) to imply status
        } else {  
            this.balance += amount;
        }
        
        this.balance += amount;
    }
    
    /* Generate synchronize token for other wallets */
    /* token format [WIDsnd, WIDrcv, amount=0, counter=0] */
    public void sync_to(int WIDrcv) {
        // create a token and encrypt into handshake message
        
    }
    
    /* Decrypt synchronize token from other wallets */
    public void sync_from (String token) {
        int WIDsnd, WIDrcv, amount, counter, f;
        WIDsnd = WIDrcv = amount = counter = 0;
        f = 1; // flag for validating if this is an acceptable handshake request, 1=yes
        
        // accept a token and decrypt into handshake message
        
        
        // validate the records in synced table
        if (WIDrcv == this.WID && amount == 0 && counter == 0) {
            for (int[] i : synced) {
                if (i[0] == WIDsnd) {
                    f = 0; // existed record
                    System.err.println("Record Existed"); // considering return alert code (int) to imply status
                    break;
                }
            }
        } else {
            f = 0; // unmatching info
            System.err.println("Unmatching Info : Incorrect wallet ID or Not a valid handshake token"); // considering return alert code (int) to imply status
        }
        
        // Add the record
        if (f == 1) {
            for (int[] i : synced) {
                if (i[0] == 0) { // all unused array space for wallet ID is initialized with 0 (assume that all wallet ID != 0)
                    i[0] = WIDsnd; // sender wallet ID
                    i[1] = 0; // counter = 0
                }
            }
            System.out.println("Record Added"); // considering return alert code (int) to imply status
        }
    }
           
}
