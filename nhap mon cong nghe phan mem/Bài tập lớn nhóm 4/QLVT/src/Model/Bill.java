/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Bill implements Serializable{

    private int ID;
    private double totalCost;
    private Date date;
    private Agency agency;
    private User user;
    private ArrayList<ExportedGood> listExportedGood;

    public Bill() {
        this.agency = new Agency();
        this.user = new User();
        this.listExportedGood = new ArrayList<ExportedGood>();
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<ExportedGood> getListExportedGood() {
        return listExportedGood;
    }

    public void setListExportedGood(ArrayList<ExportedGood> listExportedGood) {
        this.listExportedGood = listExportedGood;
    }
    public Object[] toObject(){
        
        return new Object[] {listExportedGood.get(0).getAmount(), listExportedGood.get(0).getPrice(), listExportedGood.get(0).getIntoMoney(), ID,
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date), agency.getID(), agency.getName(), agency.getAddress(), agency.getPhoneNumber()};
    }
}
