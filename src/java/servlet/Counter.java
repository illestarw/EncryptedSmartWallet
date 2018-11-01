/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.Serializable;

/**
 *
 * @author Illestar
 */

public class Counter implements Serializable{
    private int c = 0;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
