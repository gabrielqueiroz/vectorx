package com.gabrielqueiroz.model;

import java.util.Date;

public class Dias {
	private Date dia;
	private String tipo;
	private String descricao;

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Dias() {

	}

	public Dias(Date dia, String tipo, String descricao) {
		this.dia = dia;
		this.tipo = tipo;
		this.descricao = descricao;
	}

}