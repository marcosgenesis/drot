package br.com.pi.drot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataDoDia {
	private static DataDoDia dataDoDiaFormatada;

	private DataDoDia() {
	}

	public static DataDoDia getInstance() {
		if(dataDoDiaFormatada == null) {
			dataDoDiaFormatada = new DataDoDia();
		}
		return dataDoDiaFormatada;
	}

    public String retornarDataDoDia(String dataDoDia) {
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendarDataAtual = Calendar.getInstance();
		dataDoDia= formatoData.format(calendarDataAtual.getTime());
        return dataDoDia;
    }
}