package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import cn.techtutorial.model.*;

public class OrderDao {
	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    

	public OrderDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            query = "insert into dathang (ID_SanPham, ID_TaiKhoan, soluong, ngaydat, ten, sdt, diachi) values(?,?,?,?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQunatity());
            pst.setString(4, model.getDate());
            
            pst.setString(5, model.getName());
            
            pst.setString(6, model.getSdt());
            
            pst.setString(7, model.getDiachi());
			/* pst.setString(8, model.getSize()); */

            
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

	public boolean sizeOrder(Order model) {
        boolean result = false;
        try {
            query = "insert into dathang (o_size) values(?)";
            pst = this.con.prepareStatement(query);
            
            
            pst.setString(8, model.getSize());
            
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	
	
    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            query = "select * from dathang where ID_TaiKhoan=? order by dathang.ID desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDao productDao = new ProductDao(this.con);
                int pId = rs.getInt("ID_SanPham");
                Product product = productDao.getSingleProduct(pId);
                order.setOrderId(rs.getInt("ID"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice()*rs.getInt("soluong"));
                order.setQunatity(rs.getInt("soluong"));
                order.setDate(rs.getString("ngaydat"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from dathang where ID=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
    
    
    public Order CheckOut(String name,String sdt, String diachi) {
    	Order order = null;
        try {
            query = "Insert into  dathang(ten,sdt,diachi) values(?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setString(5, name);
            pst.setString(6, sdt);
            pst.setString(7, diachi);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return order;
    }
}
