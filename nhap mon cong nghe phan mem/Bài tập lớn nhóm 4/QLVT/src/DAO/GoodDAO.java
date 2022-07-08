/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Model.Good;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class GoodDAO extends DAO{

    public GoodDAO() {
    }
    public ArrayList<Good> searchGood(String key){
        ArrayList<Good> result = new ArrayList<Good>();
        String sql = "SELECT * FROM QLVT.tblGood WHERE name LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
 
            while(rs.next()){
                Good good = new Good();
                good.setID(rs.getInt("id"));
                good.setName(rs.getString("name"));
                good.setDescription(rs.getString("des"));
                result.add(good);
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return result;
    }
    public boolean updateGood(Good good){
        String sql = "UPDATE QLVT.tblGood SET name=?, des=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, good.getName());
            ps.setString(2, good.getDescription());            
            ps.setInt(3, good.getID());
 
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;
    }
    public void addGood(Good good){
        String sql = "INSERT INTO QLVT.tblgood(name, des, amount) VALUES(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, good.getName());
            ps.setString(2, good.getDescription());
            ps.setInt(3, 0);
            ps.executeUpdate();
             
            //get id of the new inserted good
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                good.setID(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
