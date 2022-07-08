/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Model.Good;
import Model.GoodStat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class GoodStatDAO extends DAO{

    public GoodStatDAO() {
    }
    
    public static int getAmount(int IDGood){
        String sql = "SELECT amount FROM QLVT.tblGood WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IDGood);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()){
                return rs.getInt("amount");                
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return -1;
    }
    public static boolean checkAmount(int IDGood, int amount){
        if (getAmount(IDGood) >= amount){
            return true;
        }
        return false;
    }
    public static boolean updateAmount(int IDGood, int amount){
        String sql = "UPDATE QLVT.tblGood SET amount=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getAmount(IDGood) + amount);          
            ps.setInt(2, IDGood);
 
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;
    }
    public ArrayList<GoodStat> getGoodStat(Date startDate, Date endDate){
        ArrayList<GoodStat> result = new ArrayList<GoodStat>();
        String sql = "SELECT a.id, a.name, a.des, SUM(b.amount) as amount, SUM(b.amount * b.price) as income FROM qlvt.tblGood as a, qlvt.tblExportedGood as b, qlvt.tblBill as c WHERE b.idgood = a.id AND b.idbill = c.id AND c.date > ? AND c.date < ? GROUP BY b.idgood ORDER BY income DESC, amount DESC;";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdf.format(startDate));
            ps.setString(2, sdf.format(endDate));
//            ps.setString(3, sdf.format(startDate));
//            ps.setString(4, sdf.format(endDate));            
            ResultSet rs = ps.executeQuery();
             
            while(rs.next()) {
                GoodStat r = new GoodStat();
                r.setID(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setDescription(rs.getString("des"));
                r.setQuantitySold(rs.getInt("amount"));
                r.setRevenue(rs.getDouble("income"));
                result.add(r);                
            }           
        }catch(Exception e) {
            e.printStackTrace();
        }       
        return result;
    }
}
