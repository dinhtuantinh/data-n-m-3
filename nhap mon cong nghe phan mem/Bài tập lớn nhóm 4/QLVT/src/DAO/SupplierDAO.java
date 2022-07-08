/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class SupplierDAO extends DAO {

    public SupplierDAO() {
    }

    public ArrayList<Supplier> searchSupplier(String key) {
        ArrayList<Supplier> result = new ArrayList<Supplier>();
        String sql = "SELECT * FROM QLVT.tblSupplier WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setID(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setAddress(rs.getString("address"));
                supplier.setPhoneNumber(rs.getString("phoneNumber"));
                result.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO QLVT.tblsupplier(name, address, phonenumber) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getAddress());
            ps.setString(3, supplier.getPhoneNumber());

            ps.executeUpdate();

            //get id of the new inserted supplier
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                supplier.setID(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
