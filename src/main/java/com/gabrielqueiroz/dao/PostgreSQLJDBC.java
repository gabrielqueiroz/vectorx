package com.gabrielqueiroz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBC {
	
	private final static String JDBC_CLASS = "org.postgresql.Driver";
	private final static String JDBC_URL = "jdbc:postgresql://localhost:5432/operador";
	private final static String JDBC_USERID = "operador";
	private final static String JDBC_PASSWORD = "operador";
	
	private Connection con;
	private static PostgreSQLJDBC jdbcutil;
	
	public PostgreSQLJDBC(){		
	}	
	
	public Connection getConnection() throws SQLException {
		if (con == null) {
			try {
				Class.forName( JDBC_CLASS );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (con == null || (con != null && !con.isValid(3))) { 
			Statement stmt = null;			
			try {				
				con = DriverManager.getConnection(JDBC_URL, JDBC_USERID, JDBC_PASSWORD);
				System.out.println("Banco de Dados Carregado com Sucesso!");
		        stmt = con.createStatement();
		        String sql = "CREATE TABLE DIAS "
		        	+ "(ID SERIAL PRIMARY KEY, DIA DATE, TIPO TEXT, DESCRICAO TEXT)";	        		 	         
		        stmt.executeUpdate(sql);		         
		        stmt.close();
		        	        
		      } catch (Exception e) {	
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		}
		return con;
	}
	
	public static PostgreSQLJDBC getInstance() { 
		if (jdbcutil == null) { 
			jdbcutil = new PostgreSQLJDBC();
		}
		return jdbcutil;
	}

}