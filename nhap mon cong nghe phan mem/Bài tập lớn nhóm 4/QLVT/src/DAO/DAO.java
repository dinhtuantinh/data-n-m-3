/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
//import com.mysql.jdbc.Driver;
/**
 *
 * @author HP
 */
public class DAO {
    public static Connection con;

    public DAO() {
        if (con == null){
            String DbUrl = "jdbc:mysql://localhost:3306/qlvt?autoReconnect=true&useSSL=false";
//            String dbClass = "com.mysql.jdbc.Driver";
            try {                     
//                Class.forName(dbClass);
                con = DriverManager.getConnection (DbUrl, "root", "admin");                            
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }    
}
