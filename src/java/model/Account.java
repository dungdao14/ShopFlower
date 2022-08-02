/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dinh Nam
 */
public class Account {

    private int accID;
    private String username, password;
    int role, cusID;

    public Account(int accID, String username, String password, int role, int cusID) {
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cusID = cusID;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", username=" + username + ", password=" + password + ", role=" + role + ", cusID=" + cusID + '}';
    }

}
