package application;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dao {
	
	String MySqlClassName="com.mysql.cj.jdbc.Driver";
	String MySqlEmptyUrl="jdbc:mysql://localhost:3306/";
	String MySqlUrl="jdbc:mysql://localhost:3306/DonerciOtomasyonu";
	String MySqlUname="root";
	String MySqlPass= "mypassword";
	
	String MariaDBClassName="org.mariadb.jdbc.Driver";
	String MariaDBEmptyUrl="jdbc:mariadb://localhost:3306/";
	String MariaDBUrl="jdbc:mariadb://localhost:3306/DonerciOtomasyonu";
	String MariaDBUname="root";
	String MariaDBPass= "mypassword";
	
	String className=MySqlClassName;
	String emptyUrl=MySqlEmptyUrl;
	String url=MySqlUrl;
	String uname=MySqlUname;
	String pass=MySqlPass;
	//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public void createDatabase() 
	{
		String query1="Create Database if not exists DonerciOtomasyonu";
				//"If(db_id(N'DonerciOtomasyonu') IS NULL) CREATE DATABASE [DonerciOtomasyonu]";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(emptyUrl,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public boolean doesTableExistInDb(String tableName) 
//	{
//		//String query="SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME =?";
//		
//		try {
//			Class.forName(className);
//			Connection con = DriverManager.getConnection(url,uname,pass);
//			DatabaseMetaData dbm=con.getMetaData();
//			ResultSet rs=dbm.getTables(null, "DonerciOtomasyonu", tableName, null);
//
//			if(rs.next())
//			{
//			
//				return true;
//			
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
	public void createProductNameAndPriceTable()
	{
		String query1="Create table ProductNameAndPriceTable" +
                "(" +
                "ProductName nvarchar(45) not null," +

                "ProductPrice nvarchar(45) not null," +
                "primary key(ProductName)"+

                ")";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void createProductTable()
	{
		String query1="Create table ProductTable" +
                "(" +
				"ProductId Int not null auto_increment,"+
                "ProductName nvarchar(45) not null,"+
                 "ProductNumber Int not null," +
                "ProductPrice Double not null," +
                 "ProductProperty nvarchar(200),"+
                 "ProductTotal Double not null,"+
                "ProductDate nvarchar(45) not null,"+
                "primary key(ProductId)"+

                ")";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void addProductToProductTable(Product p)
	{
		
		String query1="Insert into ProductTable (ProductName,ProductNumber,ProductPrice,ProductTotal,ProductDate,ProductProperty)"
				+ "values (?,?,?,?,?,?)";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.setString(1, p.getName());
			st1.setInt(2, p.getNumber());
			st1.setDouble(3, p.getPrice());
			st1.setDouble(4, p.getTotal());
			st1.setString(5, p.getDate());
			st1.setString(6, p.getProperty());
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void increaseProductNumberByAlteringProductTable(String name, String date,int number,double price)
	{
		number+=1;
		double total=number*price;
		String query1="Update ProductTable Set ProductNumber=?, ProductTotal=? where ProductName=? and ProductDate=?";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.setInt(1, number);
			st1.setDouble(2, total);
			st1.setString(3, name);
			st1.setString(4, date);
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void decreaseProductNumberByAlteringProductTable(String name, String date,int number,double price)
	{
		number-=1;
		double total=number*price;
		if(number>0)
		{
			String query1="Update ProductTable Set ProductNumber=?, ProductTotal=? where ProductName=? and ProductDate=?";
			
			try {
				Class.forName(className);
				Connection con1 = DriverManager.getConnection(url,uname,pass);
				PreparedStatement st1= con1.prepareStatement(query1);
				st1.setInt(1, number);
				st1.setDouble(2, total);
				st1.setString(3, name);
				st1.setString(4, date);
				st1.executeUpdate();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}else this.deleteFromProductTable(name, date);
		
		
	}
	
	public List<Product> bringProductTableContent()
	{
		String query="Select * From ProductTable";
		List<Product> productsInDb=new ArrayList<Product>();
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setName(rs.getString("ProductName"));
				p.setNumber(rs.getInt("ProductNumber"));
				p.setPrice(rs.getDouble("ProductPrice"));
				p.setProperty(rs.getString("ProductProperty"));
				p.setTotal(rs.getDouble("ProductTotal"));
				p.setDate(rs.getString("ProductDate")+"");
				productsInDb.add(p);
				
				
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsInDb;
	}
	
	public Product bringProductFromProductTable(String name, int number, double price, double total,String date)
	{
		String query="Select * From ProductTable where ProductName=? and ProductNumber=? and ProductPrice=? and ProductTotal=? and ProductDate=?";
		Product p=new Product();
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, name);
			st.setInt(2, number);
			st.setDouble(3, price);
			st.setDouble(4, total);
			st.setString(5, date);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				
				p.setName(rs.getString("ProductName"));
				p.setNumber(rs.getInt("ProductNumber"));
				p.setPrice(rs.getDouble("ProductPrice"));
				p.setProperty(rs.getString("ProductProperty"));
				p.setTotal(rs.getDouble("ProductTotal"));
				p.setDate(rs.getString("ProductDate")+"");
		
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public int saveItemToProductNameAndPriceTable(String productName, String productPrice)
	{
		String query="Select * From ProductNameAndPriceTable where ProductName=?";
		
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, productName);
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
			
				return 2;
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!productName.matches("^[öüÖÜĞğşŞçÇıİ|a-z|A-Z]+(\\s[öüÖÜĞğşŞçÇıİ|a-z|A-Z]+)?$")
		&& !productPrice.matches("(^[0-9]?[1-9](\\.[0-9]{0,2})?$|^[1-9][0-9]*(\\.[0-9]{0,2})?$)"))
		return 2;
		
		String query1="Insert into ProductNameAndPriceTable values (?,?)";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.setString(1, productName);
			st1.setString(2, productPrice);
			return st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
		
	}
	public int deleteFromProductNameAndPriceTable(String productName) 
	{
		String query1="Delete From ProductNameAndPriceTable where ProductName=?";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.setString(1, productName);
			return st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
		
	}
	
	public void deleteFromProductTable(String productName, String productDate) 
	{
		String query1="Delete From ProductTable where ProductName=? and ProductDate=?";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.setString(1, productName);
			st1.setString(2, productDate);
			st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void truncateProductTable() 
	{
		String query1="Truncate Table ProductTable";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ObservableList<String> getProductNames()
	{
		String query="Select ProductName From ProductNameAndPriceTable";
		ObservableList<String> productNames=FXCollections.observableArrayList();
		
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query);
			
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				productNames.add(rs.getString("ProductName"));
				
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productNames;
		
	}
	public String getProductPrice(String productName)
	{
		String query="Select ProductPrice From ProductNameAndPriceTable where ProductName=?";
		
		
		try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, productName);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				return rs.getString("ProductPrice");
				
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
