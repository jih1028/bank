package com.bank.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println("dd");
			Class.forName(Constants.ORACLE_DRIVER);
			System.out.println("17");
			conn = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PASS
					);
			stmt = conn.createStatement();
			System.out.println("23");
			rs = stmt.executeQuery("SELECT * FROM test");
			String name = null;
			while(rs.next()){
				name = rs.getString("name");
			}
			System.out.println("이름 :"+ name);
					
		} catch (Exception e) {
			System.out.println("ddddd");
		}
		
	}
}