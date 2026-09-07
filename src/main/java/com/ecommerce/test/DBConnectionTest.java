package com.ecommerce.test;

import java.sql.*;
import com.ecommerce.util.DBConnection;

public class DBConnectionTest {
    public static void main(String[] args)  {
		try {
			Connection connection = DBConnection.getConnection();
			
			System.out.println("Database Connected Successfully!");
			System.out.println("Connection  : " + connection);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
