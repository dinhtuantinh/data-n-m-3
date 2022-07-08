package cn.techtutorial.dao;

import java.sql.*;
import java.util.*;

import cn.techtutorial.model.Cart;
import cn.techtutorial.model.Product;
import cn.techtutorial.model.User;

public class ProductDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    

	public ProductDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	public List<Product> getAllProducts() {
        List<Product> book = new ArrayList<>();
        try {

            query = "select * from sanpham";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setId(rs.getInt("ID"));
                row.setName(rs.getString("ten"));
                row.setCategory(rs.getString("loai"));
                row.setPrice(rs.getDouble("gia"));
                row.setImage(rs.getString("hinhanh"));

                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from sanpham where ID=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("ID"));
	                row.setName(rs.getString("ten"));
	                row.setCategory(rs.getString("loai"));
	                row.setPrice(rs.getDouble("gia"));
	                row.setImage(rs.getString("hinhanh"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select gia from sanpham where ID=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("gia")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from sanpham where ID=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("ID"));
                        row.setName(rs.getString("ten"));
                        row.setCategory(rs.getString("loai"));
                        row.setPrice(rs.getDouble("gia")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
    public Product CreateProduct(String ten,String loai, String hang, String gioitinh, double gia, String hinhanh, String mota) {
    	Product product = null;
        try {
            query = "Insert into  sanpham(ten,loai,hang,gioitinh,gia,hinhanh,mota) values(?,?,?,?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setString(1, ten);
            pst.setString(2, loai);
            pst.setString(3, hang);
            pst.setString(4, gioitinh);
            pst.setDouble(5, gia);
            pst.setString(6, hinhanh);
            pst.setString(7, mota);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return product;
    }
}
