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
	
	static String MySqlClassName="com.mysql.cj.jdbc.Driver";
	static String MySqlEmptyUrl="jdbc:mysql://localhost:3306/";
	static String MySqlUrl="jdbc:mysql://localhost:3306/DonerciOtomasyonu";
	static String MySqlUname="root";
	static String MySqlPass= "Savassanati01";
	
	static String MariaDBClassName="org.mariadb.jdbc.Driver";
	static String MariaDBEmptyUrl="jdbc:mariadb://localhost:3306/";
	static String MariaDBUrl="jdbc:mariadb://localhost:3306/DonerciOtomasyonu";
	static String MariaDBUname="root";
	static String MariaDBPass= "Savassanati01";
	
	static String SqliteDBClassName="org.sqlite.JDBC";
	static String SqliteDBEmptyUrl="jdbc:sqlite";
	static String SqliteDBUrl="jdbc:sqlite:DonerciOtomasyonu.sqlite";
	
	static String className=SqliteDBClassName;
	static String emptyUrl=SqliteDBEmptyUrl;
	static String url=SqliteDBUrl;
//	String uname=MySqlUname;
//	String pass=MySqlPass;
	//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	static Connection con=null;
	static Connection con1=null;
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con = DriverManager.getConnection(url);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	
	public void createDatabase() throws SQLException, ClassNotFoundException 
	{
		String query1="Create Database if not exists DonerciOtomasyonu";
				//"If(db_id(N'DonerciOtomasyonu') IS NULL) CREATE DATABASE [DonerciOtomasyonu]";
		
		try {
			Class.forName(className);
			Connection con1 = DriverManager.getConnection(url);
//			Connection con1 = DriverManager.getConnection(emptyUrl,uname,pass);
			
			PreparedStatement st1= con1.prepareStatement(query1);
			st1.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(con1!=null)
			{
				con1.close();
			}
			
				
			
		}
		
	}
//	public boolean doesTableExistInDb(String tableName) 
//	{
//		//String query="SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME =?";
//		
//		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url,uname,pass);
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
	public void createProductNameAndPriceTable() throws SQLException
	{
		String query1="Create table ProductNameAndPriceTable" +
                "(" +
                "ProductName nvarchar(45) not null," +

                "ProductPrice nvarchar(45) not null," +
                "primary key(ProductName)"+

                ")";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void createProductTable() throws SQLException
	{
//		String query1="Create table ProductTable" +
//                "(" +
//				"ProductId Int not null auto_increment,"+
//                "ProductName nvarchar(45) not null,"+
//                 "ProductNumber Int not null," +
//                "ProductPrice Double not null," +
//                 "ProductProperty nvarchar(200),"+
//                 "ProductTotal Double not null,"+
//                "ProductDate nvarchar(45) not null,"+
//                "primary key(ProductId)"+
//
//                ")";
		
		//Not:Eğer sqlite kullanılacaksa hemen aşağıdaki yorum satırına alınmamış olan 
		//    query1 stringi sql sorgusu olarak kullanılacak
		//	  eğer sqlite değil de mysql kullanılacaksa yukarıda yorum satırına alınmış olan
		//	  query1 stringi sql sorgusu olarak kullanılmalıdır.
		//	  hemen aşağıdaki yorum satırına alınmamış olan query1 stringi
		//	  sadece sqlite ile denenmiştir.
		
		String query1="Create table ProductTable" +
                "(" +
				"ProductId Int primary key,"+
                "ProductName nvarchar(45) not null,"+
                 "ProductNumber Int not null," +
                "ProductPrice Double not null," +
                 "ProductProperty nvarchar(200),"+
                 "ProductTotal Double not null,"+
                "ProductDate nvarchar(45) not null"+")";
		
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			
			st1.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void addProductToProductTable(Product p) throws SQLException
	{
		
		String query1="Insert into ProductTable (ProductName,ProductNumber,ProductPrice,ProductTotal,ProductDate,ProductProperty)"
				+ "values (?,?,?,?,?,?)";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void increaseProductNumberByAlteringProductTable(String name, String date,int number,double price) throws SQLException
	{
		number+=1;
		double total=number*price;
		String query1="Update ProductTable Set ProductNumber=?, ProductTotal=? where ProductName=? and ProductDate=?";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
	}
	
	public void decreaseProductNumberByAlteringProductTable(String name, String date,int number,double price) throws SQLException
	{
		number-=1;
		double total=number*price;
		if(number>0)
		{
			String query1="Update ProductTable Set ProductNumber=?, ProductTotal=? where ProductName=? and ProductDate=?";
			
			try {
//				Class.forName(className);
//				con = DriverManager.getConnection(url);
//				con = DriverManager.getConnection(url,uname,pass);
				con=getCon();
				PreparedStatement st1= con.prepareStatement(query1);
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
			finally {
				if(con!=null)
				{
					con.close();
				}
				
					
				
			}
		}else this.deleteFromProductTable(name, date);
		
		
	}
	
	public List<Product> bringProductTableContent() throws SQLException
	{
		String query="Select * From ProductTable";
		List<Product> productsInDb=new ArrayList<Product>();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return productsInDb;
	}
	
	public Product bringProductFromProductTable(String name, int number, double price, double total,String date) throws SQLException
	{
		String query="Select * From ProductTable where ProductName=? and ProductNumber=? and ProductPrice=? and ProductTotal=? and ProductDate=?";
		Product p=new Product();
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return p;
	}
	
	public int saveItemToProductNameAndPriceTable(String productName, String productPrice) throws SQLException
	{
		String query="Select * From ProductNameAndPriceTable where ProductName=?";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		if(!productName.matches("^[öüÖÜĞğşŞçÇıİ|a-z|A-Z]+(\\s[öüÖÜĞğşŞçÇıİ|a-z|A-Z]+)?$")
		&& !productPrice.matches("(^[0-9]?[1-9](\\.[0-9]{0,2})?$|^[1-9][0-9]*(\\.[0-9]{0,2})?$)"))
		return 2;
		
		String query1="Insert into ProductNameAndPriceTable values (?,?)";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		return 1;
		
	}
	public int deleteFromProductNameAndPriceTable(String productName) throws SQLException 
	{
		String query1="Delete From ProductNameAndPriceTable where ProductName=?";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.setString(1, productName);
			return st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return 2;
		
	}
	
	public void deleteFromProductTable(String productName, String productDate) throws SQLException 
	{
		String query1="Delete From ProductTable where ProductName=? and ProductDate=?";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		
	}
	
	public void truncateProductTable() throws SQLException 
	{
		String query1="Delete from ProductTable";
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
			PreparedStatement st1= con.prepareStatement(query1);
			st1.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		
		
	}
	
	public ObservableList<String> getProductNames() throws SQLException
	{
		String query="Select ProductName From ProductNameAndPriceTable";
		ObservableList<String> productNames=FXCollections.observableArrayList();
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return productNames;
		
	}
	public String getProductPrice(String productName) throws SQLException
	{
		String query="Select ProductPrice From ProductNameAndPriceTable where ProductName=?";
		
		
		try {
//			Class.forName(className);
//			con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,uname,pass);
			con=getCon();
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
		finally {
			if(con!=null)
			{
				con.close();
			}
			
				
			
		}
		return null;
		
	}
	

}
