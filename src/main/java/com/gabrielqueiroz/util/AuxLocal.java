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

		try {
			d = new Dias(sdf.parse("2015-01-01T00:00:00"),"Feriado Nacional","Confraternizacao Mundial");
			dias.add(d);
			d = new Dias(sdf.parse("2015-02-20T00:00:00"),"Ponto Facultativo","Carnaval");
			dias.add(d);
			d = new Dias(sdf.parse("2015-02-21T00:00:00"),"Ponto Facultativo","Carnaval");
			dias.add(d);
			d = new Dias(sdf.parse("2015-02-22T00:00:00"),"Ponto Facultativo 14h","Quarta-feira de Cinzas");
			dias.add(d);
			d = new Dias(sdf.parse("2015-04-06T00:00:00"),"Ponto Facultativo","Paixao de Cristo");
			dias.add(d);
			d = new Dias(sdf.parse("2015-04-21T00:00:00"),"Feriado Nacional","Tiradentes");
			dias.add(d);
			d = new Dias(sdf.parse("2015-05-01T00:00:00"),"Feriado Nacional","Confraternização Mundial do Trabalho");
			dias.add(d);
			d = new Dias(sdf.parse("2015-06-07T00:00:00"),"Ponto Facultativo","Corpus Christi");
			dias.add(d);
			d = new Dias(sdf.parse("2015-09-07T00:00:00"),"Feriado Nacional","Independecia do Brasil");
			dias.add(d);
			d = new Dias(sdf.parse("2015-10-12T00:00:00"),"Feriado Nacional","Nossa Senhora Aparecida");
			dias.add(d);
			d = new Dias(sdf.parse("2015-10-28T00:00:00"),"Ponto Facultativo","Dia do Servidor Publico");
			dias.add(d);
			d = new Dias(sdf.parse("2015-11-02T00:00:00"),"Feriado Nacional","Finados");
			dias.add(d);
			d = new Dias(sdf.parse("2015-11-15T00:00:00"),"Feriado Nacional","Proclamacao da Republica");
			dias.add(d);
			d = new Dias(sdf.parse("2015-12-24T00:00:00"),"Ponto Facultativo","Vespera do Natal");
			dias.add(d);
			d = new Dias(sdf.parse("2015-12-25T00:00:00"),"Feriado Nacional","Natal");
			dias.add(d);
			d = new Dias(sdf.parse("2015-12-31T00:00:00"),"Ponto Facultativo","Vespera do Ano-Novo");
			dias.add(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		for (Dias dia : dias)
			System.out.println(diasDAO.adicionaDia(dia));
	}
}