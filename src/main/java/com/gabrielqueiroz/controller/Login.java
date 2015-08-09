package com.gabrielqueiroz.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gabrielqueiroz.model.Usuario;
import com.gabrielqueiroz.util.AuxLocal;

@SessionScoped
@ManagedBean()
public class Login {
	private AuxLocal aux = new AuxLocal();
	
	private Usuario usuario;
	private String mensagem = "";
	
	public Login(){
		setUsuario(new Usuario());		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String logar(){	
		if(usuario.getUsername().equals("admin") && usuario.getPassword().equals("admin")){
			try {
				aux.adicionaDias();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			return "./listaFeriados.xhtml";
		}					
		setMensagem("Usuário ou Senha inválidos.");
		return "./login.xhtml";
	}
	
	public String logout(){
		setUsuario(new Usuario());
		setMensagem("");
		return "./login.xhtml";
	}
}
