package net.baber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.baber.model.Cuahang;
import net.baber.model.QuanHuyen;
import net.baber.model.ThanhPho;




public class ThanhPhoDAO {
	/*
	private static String jdbcURL = "jdbc:mysql://localhost:3306/babershop?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456bo";
     
    */
    private static String jdbcURL = "jdbc:mysql://baei4ga465dfsx8jbwsx-mysql.services.clever-cloud.com:3306/baei4ga465dfsx8jbwsx?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ufmocvvfdnmrjot8";
    private static String jdbcPassword = "XWIejeuN7VnidLacSM2u";
    
    private static final String SELECT_ALL_CITY = "select * from thanhpho";
    private static final String SELECT_ALL_DISTRICT = "select * from quanhuyen";
    private static final String SELECT_ALL_QuanHuyen_BYID_ThanhPho = "select * from quanhuyen where idTP = ?";
    private static final String SELECT_ALL_CuaHang_By_IDQuanHuyen = "select * from cuahang where idQH = ?";
    private static final String SELECT_ALL_CuaHang_By_ThanhPhoID = "select * from cuahang inner join quanhuyen on cuahang.idQH =quanhuyen.id inner join thanhpho on quanhuyen.idTP = thanhpho.id where thanhpho.id = ?";
    private static final String GET_CuaHang_BY_ID= "select * from cuahang where id =?";
    private static final String INSERT_CITY = "insert into thanhpho(name) values(?)";
    private static final String INSERT_DISTRICT = "insert into quanhuyen(name,idTP) values(?,?)";
    private static final String DELETE_City = "delete from thanhpho  where id = ?";
    private static final String DELETE_Store = "delete from cuahang  where id = ?";
    private static final String DELETE_District = "delete from quanhuyen  where id = ?";
    private static final String INSERT_STORE = "insert into cuahang(name, address, idQH) values(?,?,?)";
    private static final String UPDATE_STORE_BY_ID = "update cuahang set name = ?, address = ?, idQH = ? where id = ? ";
    
    public ThanhPhoDAO() {}

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
    
    
    public void insert_Store( String name,String address, int idQH) throws SQLException {
        System.out.println(INSERT_STORE);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STORE)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setInt(3, idQH);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    
    public void Update_Store( String name,String address, int idQH, int id) throws SQLException {
        System.out.println(UPDATE_STORE_BY_ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STORE_BY_ID)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setInt(3, idQH);
            preparedStatement.setInt(4, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    
 
    public List<ThanhPho> getAll_ThanhPho(){
    	List<ThanhPho> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CITY)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new ThanhPho(rs.getInt("id"),rs.getString("name")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    
    public List<Cuahang> getAll_CuaHang_By_ThanhPhoID(int id){
    	List<Cuahang> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CuaHang_By_ThanhPhoID)) {
    		 preparedStatement.setInt(1, id);
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new Cuahang(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("idQH")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<QuanHuyen> getAll_QuanHuyen(){
    	List<QuanHuyen> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DISTRICT)) {
    		 System.out.println(SELECT_ALL_DISTRICT);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new QuanHuyen(rs.getInt("id"),rs.getString("name"),rs.getInt("idTP")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    
    
    public void insert_City(String name) throws SQLException {
        System.out.println(INSERT_CITY);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY)) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    
    public void insert_District(String name,int idTP) throws SQLException {
        System.out.println(INSERT_DISTRICT);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DISTRICT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, idTP);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public void Detele_City_By_ID(int id ) throws SQLException {
        System.out.println(DELETE_City);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_City)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public void Detele_Store_By_ID(int id) throws SQLException {
        System.out.println(DELETE_Store);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Store)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public void Detele_District_By_ID(int id ) throws SQLException {
        System.out.println(DELETE_District);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_District)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public Cuahang Get_CuaHang_By_ID(int id) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_CuaHang_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   Cuahang cuahang = new Cuahang(rs.getInt("id"), rs.getString("name"),rs.getString("address"),rs.getInt("idQH"));
        	   return cuahang;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    
    public List<QuanHuyen> getAll_QuanHuyenBy_ThanhPhoID(int idTP){
    	List<QuanHuyen> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QuanHuyen_BYID_ThanhPho)) {
    		 preparedStatement.setInt(1, idTP);
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new QuanHuyen(rs.getInt("id"),rs.getString("name"),rs.getInt("idTP")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<Cuahang> getAll_CuaHang_By_QuanHuyenID(int idQH){
    	List<Cuahang> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CuaHang_By_IDQuanHuyen)) {
    		 preparedStatement.setInt(1, idQH);
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new Cuahang(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("idQH")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }


	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
    
}
