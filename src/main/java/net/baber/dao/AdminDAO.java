package net.baber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;

import net.baber.model.AdminOrder;
import net.baber.model.DichVu;
import net.baber.model.OrderUser;
import net.baber.model.ThanhPho;
import net.baber.model.account;

public class AdminDAO {
	 /*
	private static String jdbcURL = "jdbc:mysql://localhost:3306/babershop?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456bo";
     
    */
    private static String jdbcURL = "jdbc:mysql://baei4ga465dfsx8jbwsx-mysql.services.clever-cloud.com:3306/baei4ga465dfsx8jbwsx?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ufmocvvfdnmrjot8";
    private static String jdbcPassword = "XWIejeuN7VnidLacSM2u";
    
    
    private static final String LOGIN_ADMIN_SQL = "select * from adaccount where taikhoan = ? and matkhau = ?";
    private static final String GET_ALL_SERVICES= "select * from dichvu";
    private static final String GET_ALL_SERVICES_BY_ORDERID= "select dichvu.name from dichvu, orderdetail where dichvu.id = orderdetail.idDichVu and orderdetail.idOrder = ?";
    private static final String GET_ALL_ORDER= "select orderr.id, orderr.cName, orderr.cPhone, cuahang.name, orderr.TotalPrice, orderr.OrderDate, orderr.Payment from orderr, cuahang where orderr.idCuaHang = cuahang.id and orderr.OrderDate > now()";
    private static final String DELELE_ORDERDETAIL_BY_ORDERID= "delete from orderdetail where idOrder= ?";
    private static final String DELELE_ORDER_BY_ORDERID= "delete from orderr where  id = ?";

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    
    
    
    
    public List<String> getAll_DichVu_By_OrderID(String id){
    	List<String> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SERVICES_BY_ORDERID)) {
    		 preparedStatement.setString(1, id);
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(rs.getString("name"));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    
    public List<AdminOrder> getAll_UserOrder(){
    	List<AdminOrder> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDER)) {
    		 System.out.println(GET_ALL_ORDER);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
    			 list.add(new AdminOrder(rs.getString("orderr.id"),rs.getString("cName"),rs.getString("cPhone"), getAll_DichVu_By_OrderID(rs.getString("orderr.id")), rs.getString("name") ,rs.getInt("TotalPrice"),  rs.getString("OrderDate"),rs.getInt("Payment") ));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    
    
    public void Delete_OrderDetail_By_IdOrder(String id) throws SQLException {
        System.out.println(DELELE_ORDERDETAIL_BY_ORDERID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELELE_ORDERDETAIL_BY_ORDERID)) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public void Delete_Order_By_IdOrder(String id) throws SQLException {
        System.out.println(DELELE_ORDER_BY_ORDERID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELELE_ORDER_BY_ORDERID)) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public account loginAdmin(String taikhoan, String matkhau) throws SQLException {
    	System.out.println(LOGIN_ADMIN_SQL);
    	ResultSet rs = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_ADMIN_SQL)) {
            preparedStatement.setString(1, taikhoan);
            preparedStatement.setString(2, matkhau);
            System.out.println(preparedStatement);
            rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   account User = new account(rs.getString(1),rs.getString(2));
        	   return User;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
       
    }
    
 
    
  	
  
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
