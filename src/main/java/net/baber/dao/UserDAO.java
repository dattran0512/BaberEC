package net.baber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.baber.model.Order;
import net.baber.model.OrderUser;
import net.baber.model.account;

public class UserDAO {

	/*
	private static String jdbcURL = "jdbc:mysql://localhost:3306/babershop?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456bo";
     
    */
    private static String jdbcURL = "jdbc:mysql://baei4ga465dfsx8jbwsx-mysql.services.clever-cloud.com:3306/baei4ga465dfsx8jbwsx?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ufmocvvfdnmrjot8";
    private static String jdbcPassword = "XWIejeuN7VnidLacSM2u";
    
    private static final String LOGIN_USERS_SQL = "select * from account where taikhoan = ? and matkhau = ?";
    private static final String GET_ACCOUNT_BY_TAIKHOAN = "select * from account where taikhoan = ?";
    private static final String GET_ORDER_BY_ID_ACC = "select * from orderr, account where orderr.idAccount = account.id and   OrderDate > now()  and  idAccount = ? order by OrderDate asc";
    private static final String REGISTER_USER = "insert into account(name,phone, taikhoan,matkhau) values(?,?,?,?)";
    
    
    public UserDAO() {}

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
    
    public account loginUser(String taikhoan, String matkhau) throws SQLException {
    	System.out.println(LOGIN_USERS_SQL);
    	ResultSet rs = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)) {
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
    
    public void register_User(  String name,String phone,String username,String password  ) throws SQLException {
        System.out.println(REGISTER_USER);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
  public account Get_Account_By_Taikhoan(String taikhoan) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_TAIKHOAN)) {
            preparedStatement.setString(1, taikhoan);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   account account = new account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
        	   return account;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }	
  
  public OrderUser Get_Order_By_ID_ACC(int id) throws SQLException{
  	
  	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID_ACC)) {
          preparedStatement.setInt(1, id);
          System.out.println(preparedStatement);
          ResultSet rs = preparedStatement.executeQuery();
         while(rs.next()) {
        	 OrderUser orderUser = new OrderUser(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),	rs.getLong(7),rs.getInt(8));
      	   return orderUser;
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
