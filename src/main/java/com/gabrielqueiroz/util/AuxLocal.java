package com.gabrielqueiroz.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gabrielqueiroz.dao.DiasDAOImplementation;
import com.gabrielqueiroz.model.Dias;

public class AuxLocal {

	public boolean verificaDias() {
		return false;
	}

	public void adicionaDias() throws SQLException {			
		DiasDAOImplementation diasDAO = new DiasDAOImplementation();
		
		if(!diasDAO.todosDias().isEmpty())
			return;
		
		Dias d;		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		List<Dias> dias = new ArrayList<Dias>();

		java.util.Date date;
		java.sql.Date sqlDate;

		try {
			date = sdf.parse("2015-01-01T12:00:00");
			sqlDate = new java.sql.Date(date.getTime());
			d = new Dias(sqlDate, "Feriado Nacional", "Confraternizacao Mundial");
			dias.add(d);

			date = sdf.parse("2015-02-20T12:00:00");
			sqlDate = new java.sql.Date(date.getTime());
			d = new Dias(sqlDate, "Ponto Facultativo", "Carnaval");
			dias.add(d);

			date = sdf.parse("2015-02-21T12:00:00");
			sqlDate = new java.sql.Date(date.getTime());
			d = new Dias(sqlDate, "Ponto Facultativo", "Carnaval");
			dias.add(d);						
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		for (Dias dia : dias)
			System.out.println(diasDAO.adicionaDia(dia));
	}
}