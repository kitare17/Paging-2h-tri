package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import Entity.Account;

public class Database {
	private final static String userID = "sa";
	private final static String password = "123456789";

	public static Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=WorkShop6;" + "encrypt=false";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("oknhe");
		return DriverManager.getConnection(url, userID, password);
	}

	public static ArrayList<Account> getAll() {
		ArrayList<Account> listAccount=new ArrayList();
		
		try {
			String query = "Select * from banguser";
			Connection con = getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				listAccount.add(new Account(rs.getInt(1), rs.getString(2)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAccount;

	}

	private static void insert() {
		try {
			String query = "Insert into banguser values(?,?)";
			Connection con = getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			String s="MR";
			for(int i=1;i<=9942;i++) {
				String name;
				if(10>i) name= s+"000"+i;
				else if(100>i)name=s+"00"+i;
				else if(1000>i)name=s+"0"+i;
				else name=s+i;
				pr.setInt(1,i );
				pr.setString(2, name);
				pr.executeUpdate();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		//insert();
		
		System.out.println(Integer.parseInt(null));
	}
}
