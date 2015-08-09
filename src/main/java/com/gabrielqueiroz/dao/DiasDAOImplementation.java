package com.gabrielqueiroz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gabrielqueiroz.model.Dias;

public class DiasDAOImplementation implements DiasDAO {

	@Override
	public boolean adicionaDia(Dias d) {
		try {
			System.out.println("Insert iniciado!");
			Connection con = PostgreSQLJDBC.getInstance().getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("INSERT INTO DIAS (DIA, TIPO, DESCRICAO) " + " VALUES (?,?,?);");
			java.sql.Date getDate = new java.sql.Date(d.getDia().getTime());
			pstmt.setDate(1, getDate);
			pstmt.setString(2, d.getTipo());
			pstmt.setString(3, d.getDescricao());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return false;
	}

	@Override
	public boolean removeDia(int id) throws SQLException {
		try {
			System.out.println("Insert iniciado!");
			Connection con = PostgreSQLJDBC.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM DIAS WHERE ID = ?;");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return false;
	}

	@Override
	public List<Dias> todosDias() throws SQLException {
		try {
			Connection con = PostgreSQLJDBC.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DIAS");
			ResultSet rs = pstmt.executeQuery();
			List<Dias> dias = new ArrayList<Dias>();

			while (rs.next()) {
				Dias d = new Dias();
				d.setId(rs.getInt("id"));
				d.setDia(rs.getDate("dia"));
				d.setTipo(rs.getString("tipo"));
				d.setDescricao(rs.getString("descricao"));
				dias.add(d);
			}
			return dias;
		} catch (SQLException e) {
			System.out.println("Erro ao carregar lista de respostas");
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Dias> listaDias(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaDia(Date dia) throws SQLException {
		Connection con = PostgreSQLJDBC.getInstance().getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DIAS WHERE DIA LIKE ?");
		java.sql.Date getDate = new java.sql.Date(dia.getTime());
		pstmt.setDate(1, getDate);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next())
			return true;

		return false;
	}

}
