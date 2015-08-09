package com.gabrielqueiroz.dao;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import com.gabrielqueiroz.model.Dias;

interface DiasDAO {
	public boolean adicionaDia(Dias d) throws SQLException;
	public boolean removeDia(int id) throws SQLException;
	public Dias pesquisaDia(Date dia) throws SQLException;
	public List<Dias> todosDias() throws SQLException;
	public List<Dias> listaDias(int id) throws SQLException;
}
