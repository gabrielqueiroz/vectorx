package com.gabrielqueiroz.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.gabrielqueiroz.dao.DiasDAOImplementation;

public class DiasSOAP {
	private DiasDAOImplementation diasDAO = new DiasDAOImplementation();
	
	@SuppressWarnings("deprecation")
	public boolean diasWebService(String dia) throws SQLException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		if(sdf.parse(dia).getDay()==0 || sdf.parse(dia).getDay()==6)
			return true;
		if(diasDAO.validaDia(sdf.parse(dia)))
			return true;		
		return false;
	}
}
