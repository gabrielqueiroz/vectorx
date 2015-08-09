package com.gabrielqueiroz.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gabrielqueiroz.dao.DiasDAOImplementation;
import com.gabrielqueiroz.model.Dias;

@ManagedBean
@SessionScoped
public class DiasMB {
	private Dias dia;
	private List<Dias> todosDias;
	private DiasDAOImplementation diasDAO = new DiasDAOImplementation();

	public DiasMB() throws SQLException {
		setDia(new Dias());
		setTodosDias(diasDAO.todosDias());
	}
	
	public List<Dias> listaDias() throws SQLException{
		setTodosDias(diasDAO.todosDias());
		return todosDias;
	}

	public Dias getDia() {
		return dia;
	}

	public void setDia(Dias dia) {
		this.dia = dia;
	}

	public List<Dias> getTodosDias() {
		return todosDias;
	}

	public void setTodosDias(List<Dias> todosDias) {
		this.todosDias = todosDias;
	}

	public String removeDia(int id) throws SQLException{
		diasDAO.removeDia(id);
		return "./login.xhtml";
	}
}
