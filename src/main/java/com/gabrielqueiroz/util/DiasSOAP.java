package com.gabrielqueiroz.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	@SuppressWarnings("deprecation")
	public String proximDiaWebSerivce() throws SQLException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
				
		if(date.getDay()==5 || date.getDay()==6){
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			return sdf.format(calendar.getTime());
		}
		
		Date proximoDia = diasDAO.proximoDia(date);
		calendar.add(Calendar.DAY_OF_YEAR, (6-date.getDay()));
		if(proximoDia.before(calendar.getTime()))
			return sdf.format(proximoDia);
		
		return sdf.format(calendar.getTime());
	}
}
