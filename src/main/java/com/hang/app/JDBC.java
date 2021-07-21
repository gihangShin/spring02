package com.hang.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hang";
		String pw = "1234";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
