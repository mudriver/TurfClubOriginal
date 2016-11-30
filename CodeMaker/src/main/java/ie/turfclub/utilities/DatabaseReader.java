package ie.turfclub.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseReader {

	
	public DatabaseReader(String url, String user, String pwd){
		
	}
	
	
	public ArrayList<String> getColumns(String table){
		ArrayList<String> columns = new ArrayList<>();
		return columns;
	}
	
	public ArrayList<String> getTables(String dbName){
		ArrayList<String> tables = new ArrayList<>();
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection("jdbc:mysql://46.22.132.148:3306/" + dbName + "?zeroDateTimeBehavior=convertToNull","root","1790@estab");

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      //stmt = conn.createStatement();
		      DatabaseMetaData dbmd = conn.getMetaData();
		      
		      
		      String[] types = {"TABLE"};
	          
		      ResultSet rs =	  dbmd.getTables(null, null, "%", types);
		    	rs =	  dbmd.getTables(null, null, "%", types);
	            
	            while (rs.next()) {
	                
	            	String tableName = rs.getString("TABLE_NAME");
	            	tables.add(tableName);
	            	System.out.println(tableName);
	            	ResultSet resultSet = dbmd.getColumns(null, null, tableName, null);
	                while (resultSet.next()) {
	                  
	                	String name = resultSet.getString("COLUMN_NAME");
	                 
	                  String type = mysqlTypeToJavaType(resultSet.getString("TYPE_NAME"));
	                  int size = resultSet.getInt("COLUMN_SIZE");

	                  System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
	                }
	            }
	            rs.close();
			      //stmt.close();
			      conn.close();
		      //STEP 6: Clean-up environment
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return tables;
	}
	
	
	public ArrayList<String> getDatabases(){
		ArrayList<String> dbNames = new ArrayList<>();
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection("jdbc:mysql://46.22.132.148:3306/vetreports?zeroDateTimeBehavior=convertToNull","root","1790@estab");

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      //stmt = conn.createStatement();
		      DatabaseMetaData dbmd = conn.getMetaData();
		      ResultSet rs = dbmd.getCatalogs();  
		      while (rs.next()){
		    	dbNames.add(rs.getString(1));
		      }
		      
		
	            
	         
	            rs.close();
			      //stmt.close();
			      conn.close();
		      //STEP 6: Clean-up environment
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   return dbNames;
	}
	
	public void connectToDB(){
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection("jdbc:mysql://46.22.132.148:3306/vetreports?zeroDateTimeBehavior=convertToNull","root","1790@estab");

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      //stmt = conn.createStatement();
		      DatabaseMetaData dbmd = conn.getMetaData();
		      ResultSet rs = dbmd.getCatalogs();  
		      while (rs.next()){
		    	 rs.getString(1);
		      }
		      
		      String[] types = {"TABLE"};
	          
		      
		    	rs =	  dbmd.getTables(null, null, "%", types);
	            
	            while (rs.next()) {
	                
	            	String tableName = rs.getString("TABLE_NAME");
	            	System.out.println(tableName);
	            	ResultSet resultSet = dbmd.getColumns(null, null, tableName, null);
	                while (resultSet.next()) {
	                  String name = resultSet.getString("COLUMN_NAME");
	                 
	                  String type = mysqlTypeToJavaType(resultSet.getString("TYPE_NAME"));
	                  int size = resultSet.getInt("COLUMN_SIZE");

	                  System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
	                }
	            }
	            rs.close();
			      //stmt.close();
			      conn.close();
		      //STEP 6: Clean-up environment
		      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	
	
	private String mysqlTypeToJavaType(String type){
		System.out.println(type);
		switch(type){
		case "CHAR": type="String";
		break;
		case "VARCHAR": type="String";
		break;
		case "LONGVARCHAR": type="String";
		break;
		case "NUMERIC": type="java.math.BigDecimal";
		break;
		case "DECIMAL": type="java.math.BigDecimal";
		break;
		case "BIT": type="boolean";
		break;
		case "TINYINT": type="byte";
		break;
		case "SMALLINT": type="short";
		break;
		case "INT": type="int";
		break;
		case "INTEGER": type="int";
		break;
		case "BIGINT": type="long";
		break;
		case "REAL": type="float";
		break;
		case "FLOAT": type="double";
		break;
		case "DOUBLE": type="double";
		break;
		case "BINARY": type="byte []";
		break;
		case "VARBINARY": type="byte []";
		break;
		case "LONGVARBINARY": type="byte []";
		break;
		case "DATE": type="java.sql.Date";
		break;
		case "TIME": type="java.sql.Time";
		break;
		case "TIMESTAMP": type="java.sql.Timestamp";
		break;
		case "ENUM": type="String";
		break;
		}
		return type;
	}
	
}
