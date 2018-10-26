/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.util.Objects;

/**
 *
 * @author Illestar
 */

public class LoginCredential {
    private String id;
    private String pw;
    
    /* Init */
    public LoginCredential(String id, String pw)
    {
        this.id = id;
        this.pw = pw;
    }
    
    public LoginCredential(String[] sa)
    {
        this(sa[0], sa[1]);
    }
    
    /* Hash (Eliminate identical elements when building new account & Act as Wallet ID WID)*/
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
        final LoginCredential other = (LoginCredential) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
    
}