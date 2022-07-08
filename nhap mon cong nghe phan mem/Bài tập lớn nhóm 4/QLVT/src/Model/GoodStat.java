/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class GoodStat extends Good implements Serializable{
    private int amount, quantitySold;
    private double revenue;

    public GoodStat() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    @Override   
    public Object[] toObject(){
        return new Object[] {super.getID(), super.getName(), super.getDescription(), revenue, quantitySold};
    }

    @Override
    public String toString() {
        return "GoodStat{" + "amount=" + amount + ", quantitySold=" + quantitySold + ", revenue=" + revenue + '}';
    }
    
}
