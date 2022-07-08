/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author HP
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.User;
 
public class UserDAO extends DAO{
     
    public UserDAO() {
        super();
    }
     
    public boolean checkLogin(User user) {
        boolean result = false;
        String sql = "SELECT * FROM qlvt.tblUser WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setID(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPosition(rs.getString("position"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber("phonenumber");
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}