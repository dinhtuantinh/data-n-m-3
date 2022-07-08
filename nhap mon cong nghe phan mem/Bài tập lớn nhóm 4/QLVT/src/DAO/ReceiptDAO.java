/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Model.ImportedGood;
import Model.Receipt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class ReceiptDAO extends DAO{

    public ReceiptDAO() {
    }
    public boolean addReceipt(Receipt ri) {
        String sqlAddReceipt = "INSERT INTO QLVT.tblReceipt(date, idSupplier, idUser) VALUES(?,?,?)";
        String sqlAddImportedGood = "INSERT INTO QLVT.tblImportedGood(amount, price, idGood, idReceipt)  VALUES(?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean result = true;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddReceipt,
                       Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(new Date()));
            ps.setInt(2, ri.getSupplier().getID());
            ps.setInt(3, ri.getUser().getID());            
            
            ps.executeUpdate();         
            //get id of the new inserted Receipt            
            ResultSet generatedKeys = ps.getGeneratedKeys();            
            if (generatedKeys.next()) {
                ri.setID(generatedKeys.getInt(1));                 
                //insert list rentedBook
                for(ImportedGood br: ri.getListImportedGood()) {
                    ps = con.prepareStatement(sqlAddImportedGood,
                                   Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, br.getAmount());
                    ps.setDouble(2, br.getPrice());
                    ps.setInt(3, br.getGood().getID());
                    ps.setInt(4, ri.getID());                    
                    ps.executeUpdate();         
                    //get id of the new inserted ImportedGood
                    generatedKeys = ps.getGeneratedKeys();                    
                }
            }
            for (ImportedGood i : ri.getListImportedGood()){
                GoodStatDAO.updateAmount(i.getGood().getID(), i.getAmount());
            }
            con.commit();//set this line into comment in JUnit test mode
        }catch(Exception e) {
            result = false;         
            try {               
                con.rollback();
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {               
                con.setAutoCommit(true);//set this line into comment in JUnit test mode
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        return result;
    }   
}
