/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Receipt implements Serializable{
    private int ID;
    private double totalCost;
    private Date date;
    private Supplier supplier;
    private User user;
    private ArrayList<ImportedGood> listImportedGood;

    public Receipt() {
        this.supplier = new Supplier();
        this.user = new User();
        this.listImportedGood = new ArrayList<ImportedGood>();
        this.totalCost = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<ImportedGood> getListImportedGood() {
        return listImportedGood;
    }

    public void setListImportedGood(ArrayList<ImportedGood> listImportedGood) {
        this.listImportedGood = listImportedGood;
    }
    
}
