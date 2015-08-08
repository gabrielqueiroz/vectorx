package com.gabrielqueiroz.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.gabrielqueiroz.util.AuxLocal;

@ManagedBean
@SessionScoped
public class DiasMB {
	private AuxLocal aux;

	public String iniciaBanco() {
		aux = new AuxLocal();
		aux.adicionaDias();
		return "./login.xhtml";
	}
}
