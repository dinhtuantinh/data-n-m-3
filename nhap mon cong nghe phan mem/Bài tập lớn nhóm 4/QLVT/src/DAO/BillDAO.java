/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Model.Agency;
import Model.ExportedGood;
import Model.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class BillDAO extends DAO{
    public BillDAO() {
    }
    public boolean addBill(Bill ri) {
        String sqlAddBill = "INSERT INTO QLVT.tblBill(date, idAgency, idUser) VALUES(?,?,?)";
        String sqlAddExportedGood = "INSERT INTO QLVT.tblExportedGood(amount, price, idGood, idBill)  VALUES(?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean result = true;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddBill,
                       Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(new Date()));
            ps.setInt(2, ri.getAgency().getID());
            ps.setInt(3, ri.getUser().getID());            
            
            ps.executeUpdate();         
            //get id of the new inserted Bill            
            ResultSet generatedKeys = ps.getGeneratedKeys();            
            if (generatedKeys.next()) {
                ri.setID(generatedKeys.getInt(1));                 
                //insert list rentedBook
                for(ExportedGood br: ri.getListExportedGood()) {
                    ps = con.prepareStatement(sqlAddExportedGood,
                                   Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, br.getAmount());
                    ps.setDouble(2, br.getPrice());
                    ps.setInt(3, br.getGood().getID());
                    ps.setInt(4, ri.getID());                    
                    ps.executeUpdate();         
                    //get id of the new inserted ExportedGood
                    generatedKeys = ps.getGeneratedKeys();                    
                }
            }
            for (ExportedGood i : ri.getListExportedGood()){
                GoodStatDAO.updateAmount(i.getGood().getID(), i.getAmount() * -1);
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
    public ArrayList<Bill> getBillOfGood(int IDGood, Date startDate, Date endDate){
        ArrayList<Bill> result = new ArrayList<Bill>();
    String sql = "SELECT "
                    + "a.amount as amount, "
                    + "a.price as price, "
                    + "(a.amount * a.price) as intoMoney, "
                    + "b.id as idbill, "
                    + "b.date as date, "
                    + "c.id as idagency, "
                    + "c.name as agencyName, "
                    + "c.address as agencyAddress, "
                    + "c.phonenumber as agencyPhoneNumber "
                + "FROM "
                    + "qlvt.tblexportedgood as a, "
                    + "qlvt.tblBill as b, "
                    + "qlvt.tblagency as c "
                + "WHERE "
                    + "a.idgood = ? AND b.date > ? AND b.date < ? AND b.id = a.idbill AND c.id = b.idagency";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IDGood);
        ps.setString(2, sdf.format(startDate));
        ps.setString(3, sdf.format(endDate));
        ResultSet rs = ps.executeQuery();
 
        //a == null ? b : (b == null ? a : (a.before(b) ? a : b));
        while(rs.next()){
            Bill b = new Bill();
            b.setID(rs.getInt("idBill"));
            b.setDate(sdf.parse(rs.getString("date")));
            //agency
            Agency c = new Agency();
            c.setID(rs.getInt("idagency"));
            c.setName(rs.getString("agencyName"));
            c.setAddress(rs.getString("agencyAddress"));
            c.setPhoneNumber(rs.getString("agencyPhoneNumber"));
            b.setAgency(c);
            //exportGood
            ExportedGood br = new ExportedGood();
            br.setAmount(rs.getInt("amount"));
            br.setPrice(rs.getFloat("price"));
            br.setIntoMoney(rs.getDouble("intoMoney"));    
            b.getListExportedGood().add(br);
            result.add(b);
        }
    }catch(Exception e){
        e.printStackTrace();
    }   
    return result;
    } 
}
