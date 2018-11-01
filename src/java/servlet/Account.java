package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import servlet.General;
import servlet.LoginCredential;
import java.security.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Illestar
 */
public class Account {
    private String id; // username
    private int WID;
    private int balance;
    private int[][] synced = new int[2][50]; // supports up to 50 matchings at the moment (WID, counter)
    // private String[] synced;
    // private  RSAkey; // pending for implementation of RSAPublicKey interface
    // private Key enc_key;
    
    
    /* Initialize account */
    Account(String id) {
        this.id = id;
        this.WID = hashCode(); // use easy hash algorithm for WID
        
        int f = 0; // flag, 0 = record not found 
        General g = new General();
        Path p = g.getDataPath("accounts"); // get the path of accounts
        System.out.println(p.toString()); // test
        try {
            List<String> data = Files.readAllLines(p);
            for (String d : data) {
                System.out.println(d); // test 2
                
                String[] seg = d.split(",");
                if (seg[0].equals(this.WID)) { // find record
                    this.balance = Integer.parseInt(seg[1]);
                    String[] records = d.split(",", 3)[2].split(","); // apply twice (cut WID and balance first), record format: WID#counter
                    for (int i = 0; i < records.length; i++) {
                        String[] c = records[i].split("#");
                        synced[0][i] = Integer.parseInt(c[0]);
                        synced[1][i] = Integer.parseInt(c[1]);
                    }
                    f = 1;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        
        
        // enc_key = "752EF0D8FB4958670DBA40AB1F3C1D0F8FB4958670DBA40AB1F3752EF0DC1D0F";
        /*
        Key k = new RSAPublicKey();
        byte[] encodedKey = decoder.decodeBuffer(keyString);
        Key key = new SecretKeySpec(encodedKey,0,encodedKey.length, "DES");
        */
    }
    
    /* Simple Hash (Act as Wallet ID WID)*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
