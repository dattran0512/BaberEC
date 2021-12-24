package net.baber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.baber.model.Cuahang;
import net.baber.model.DichVu;
import net.baber.model.ThanhPho;

public class DichVuDAO {
	
	/*
	private static String jdbcURL = "jdbc:mysql://localhost:3306/babershop?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456bo";
     
    */
    private static String jdbcURL = "jdbc:mysql://baei4ga465dfsx8jbwsx-mysql.services.clever-cloud.com:3306/baei4ga465dfsx8jbwsx?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ufmocvvfdnmrjot8";
    private static String jdbcPassword = "XWIejeuN7VnidLacSM2u";
    
    
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
    
    private static final String SELECT_ALL_DichVu = "select * from dichvu";
    private static final String GET_DichVu_BY_ID = "select * from dichvu where id=?";
    private static final String Delete_DichVu_BY_ID = "delete from dichvu where id = ?";
    private static final String UPDATE_DichVu_BY_ID = "update dichvu set name = ?, price=? where id = ?";
    private static final String GET_CuaHang_BY_ID = "select * from cuahang where id=?";
    private static final String INSERT_DichVu = "insert into DichVu(name,price) values(?, ?)";
    private static final String INSERT_ORDER= "insert into orderr "+"(id, idCuaHang,idAccount,cName,cPhone,OrderDate,TotalPrice) values"+"(?,?,?,?,?,?,?)";
    private static final String INSERT_ORDERDETAIL= "insert into orderdetail "+"(id, idDichVu,idOrder) values"+"(?,?,?)";
    private static final String DELETE_ORDERDETAIL_BY_ORDERID = "delete from orderdetail where idOrder = ?";
    private static final String DELETE_ORDER_BY_ORDERID = "delete from orderr where id = ?";
    private static final String DELETE_ORDER_BY_IDAcc = "delete from orderr where idAccount = ?";
    private static final String UPDATE_PAYMENT_ORDER_BY_ORDERID = "update orderr set Payment=1 where id = ?";
    private static final String SELECT_ALL_DichVu_By_idOrder = "select dichvu.id, dichvu.name, dichvu.price from dichvu, orderdetail, orderr where dichvu.id = orderdetail.idDichVu and orderdetail.idOrder = orderr.id and idOrder = ?";
    private static final String UPDATE_PAYMENT_ORDER_BY_ID_ACC = "update orderr set Payment =1 where    OrderDate > now() and orderr.idAccount =? ";
    
    public List<DichVu> getAll_DichVu(){	
    	List<DichVu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DichVu)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new DichVu(rs.getInt("id"),rs.getString("name"),rs.getLong("price")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<DichVu> getAll_DichVu_By_IdOrder(String idOrder){	
    	List<DichVu> list = new ArrayList<>();
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DichVu_By_idOrder)) {
    		 preparedStatement.setString(1,idOrder);
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new DichVu(rs.getInt("id"),rs.getString("name"),rs.getLong("price")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
 public DichVu Get_DichVu_By_ID(int id) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_DichVu_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   DichVu dichvu = new DichVu(rs.getInt("id"),rs.getString("name"),rs.getLong("price"));
        	   return dichvu;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
 
 public Cuahang Get_CuaHang_By_ID(int id) throws SQLException{
 	
 	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_CuaHang_BY_ID)) {
         preparedStatement.setInt(1, id);
         System.out.println(preparedStatement);
         ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()) {
        	Cuahang cuahang = new Cuahang(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("idQH"));
     	   return cuahang;
        }
         
     } catch (SQLException e) {
         printSQLException(e);
     }
     return null;
 }

 
 public void insert_DichVu( String name,int price ) throws SQLException {
     System.out.println(INSERT_DichVu);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DichVu)) {
         preparedStatement.setString(1, name);
         preparedStatement.setInt(2, price);
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Update_DichVu_By_ID( String name,int price, int id ) throws SQLException {
     System.out.println(UPDATE_DichVu_BY_ID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DichVu_BY_ID)) {
         preparedStatement.setString(1, name);
         preparedStatement.setInt(2, price);
         preparedStatement.setInt(3,id);
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Delete_DichVu_By_ID(int id) throws SQLException {
     System.out.println(Delete_DichVu_BY_ID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Delete_DichVu_BY_ID)) {
         preparedStatement.setInt(1, id);
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void insert_Orderr(String id, int idCuaHang, int idAccount, String cName, String cPhone,String OrderDate,long Unitprice ) throws SQLException {
     System.out.println(INSERT_ORDER);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {
         preparedStatement.setString(1,id );
         preparedStatement.setInt(2, idCuaHang);
         preparedStatement.setInt(3, idAccount);
         preparedStatement.setString(4,cName );
         preparedStatement.setString(5,cPhone );
         preparedStatement.setString(6, OrderDate);
         preparedStatement.setLong(7, Unitprice);
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }

 public void insert_OrderDetail(int id, int idDichVu, String idOrder ) throws SQLException {
     System.out.println(INSERT_ORDERDETAIL);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERDETAIL)) {
         preparedStatement.setInt(1,id );
         preparedStatement.setInt(2, idDichVu);
         preparedStatement.setString(3, idOrder);
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Delete_OrderDetail_By_OrderID( String idOrder ) throws SQLException {
     System.out.println(DELETE_ORDERDETAIL_BY_ORDERID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERDETAIL_BY_ORDERID)) {
         preparedStatement.setString(1,idOrder );
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Delete_Order_By_ID( String id ) throws SQLException {
     System.out.println(DELETE_ORDER_BY_ORDERID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ORDERID)) {
         preparedStatement.setString(1,id );
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Delete_Order_By_IDAcc( int idacc ) throws SQLException {
     System.out.println(DELETE_ORDER_BY_ORDERID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_IDAcc)) {
         preparedStatement.setInt(1,idacc );
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Update_Payment_Order_By_ID(String id) throws SQLException {
     System.out.println(UPDATE_PAYMENT_ORDER_BY_ORDERID);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_ORDER_BY_ORDERID)) {
         preparedStatement.setString(1,id );
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
 
 public void Update_Payment_Order_By_IDAcc(int  idAcc) throws SQLException {
     System.out.println(UPDATE_PAYMENT_ORDER_BY_ID_ACC);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_ORDER_BY_ID_ACC)) {
         preparedStatement.setInt(1,idAcc );
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
}
