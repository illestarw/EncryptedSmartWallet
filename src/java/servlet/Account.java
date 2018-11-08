package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.security.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Illestar
 */
public class Account implements Serializable{
    private String id; // username
    private int WID;
    private int balance;
    private int[][] synced; // supports up to 50 matchings at the moment (WID, counter)
    // private String[] synced;
    // private  RSAkey; // pending for implementation of RSAPublicKey interface
    // private Key enc_key;
    
    
    /* Initialize account (default constructor for jspBean) */
    public Account() {
    }

    /* necessary parts for jspBean */
    public int getWID() {
        return WID;
    }

    public void setWID(int WID) {
        this.WID = WID;
    }

    public int[][] getSynced() {
        return synced;
    }

    public void setSynced(int[][] synced) {
        this.synced = synced;
    }
    
    /* Display current balance */
    public int getBalance() {
        return this.balance;
    }
    
    public String getID() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
        this.WID = hashCode(); // use easy hash algorithm for WID
        
        int f = 0; // flag, 0 = record not found
        synced = new int[2][50];
        for(int i = 0; i < 2; i++)
            for (int j = 0; j < 50; j++)
                synced[i][j] = 0;
        //General g = new General();
        //Path p = g.getDataPath("accounts"); // get the path of accounts
        
        // Path p = Paths.get("resources/data/accounts");
        
        
        try {
            File dir = new File("accounts");
            dir.createNewFile();
            String path = dir.getAbsolutePath();
            Path p = Paths.get(path);
            
            List<String> data = Files.readAllLines(p);
            for (String d : data) {
                // System.out.println("record:"+d); // test
                
                String[] seg = d.split(",");
                // System.out.println("seg[0]:"+seg[0]+"WID:"+this.WID); // test
                if (seg[0].equals(Integer.toString(this.WID))) {
                    // System.out.println("equal"); // test 2
                    this.balance = Integer.parseInt(seg[1]);
                    String[] records = d.split(",", 3)[2].split(","); // apply twice (cut WID and balance first), record format: WID#counter
                    for (int i = 0; i < records.length; i++) {
                        String[] c = records[i].split("#");
                        if (c[0] != "" && c[0] != null)
                            synced[0][i] = Integer.parseInt(c[0]);
                        if (c[1] != "" && c[1] != null) 
                            synced[1][i] = Integer.parseInt(c[1]);
                    }
                    f = 1;  // find record
                    break;
                }
            }
            
            if (f == 0) { // create new record
                this.balance = 0;
                // this.synced goes default
                String str = this.WID + "," + this.balance + ",\n";
                // Files.write(p, str.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                
                BufferedWriter out = new BufferedWriter(new FileWriter(dir, true));
                out.write(str);
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (NumberFormatException n) {
            System.err.println(n);
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
    
    /* Deposit money from bank */
    public void deposit(String token) {
        // decrypt enc_hash using bank public key (TBD)
        int amount = 0;
        
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
