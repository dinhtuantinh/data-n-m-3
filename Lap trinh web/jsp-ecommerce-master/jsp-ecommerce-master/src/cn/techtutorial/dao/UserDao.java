package cn.techtutorial.dao;

import java.sql.*;
import cn.techtutorial.model.*;

public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from TaiKhoan where email=? and matkhau=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	public User UserEmail1(String email) {
		User user = null;
        try {
            query = "select * from TaiKhoan where email=? ";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	
	public User UserEmail(String email) {
		User user = null;
        try {
            query = "select * from TaiKhoan where email=? ";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	
	public User UserSignUp(String name,String email, String password) {
		User user = null;
        try {
            query = "Insert into  TaiKhoan(name,email,matkhau) values(?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}
