/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Agency;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AgencyDAO extends DAO {

    public AgencyDAO() {
    }

    public ArrayList<Agency> searchAgency(String key) {
        ArrayList<Agency> result = new ArrayList<Agency>();
        String sql = "SELECT * FROM QLVT.tblAgency WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Agency agency = new Agency();
                agency.setID(rs.getInt("id"));
                agency.setName(rs.getString("name"));
                agency.setAddress(rs.getString("address"));
                agency.setPhoneNumber(rs.getString("phoneNumber"));
                result.add(agency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addAgency(Agency agency) {
        String sql = "INSERT INTO QLVT.tblagency(name, address, phonenumber) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, agency.getName());
            ps.setString(2, agency.getAddress());
            ps.setString(3, agency.getPhoneNumber());

            ps.executeUpdate();

            //get id of the new inserted agency
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                agency.setID(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
