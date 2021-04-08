package br.com.pi.drot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalcularIdade {

	public int calcularIdade(String dataNascimento) throws ParseException {
		int idade = 0;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendarDataAtual = Calendar.getInstance();

		String dataAtual="";
		dataAtual = formatoData.format(calendarDataAtual.getTime());
		String arrayDataAtual[] = new String[3];
		String arrayDataNascimento[] = new String[3];

		arrayDataAtual = dataAtual.split("/");
		arrayDataNascimento = dataNascimento.split("/");

		int diaDataAtual = Integer.parseInt(arrayDataAtual[0]);
		int mesDataAtual = Integer.parseInt(arrayDataAtual[1]);
		int anoDataAtual = Integer.parseInt(arrayDataAtual[2]);

		int diaDataNascimento = Integer.parseInt(arrayDataNascimento[0]);
		int mesDataNascimento = Integer.parseInt(arrayDataNascimento[1]);
		int anoDataNascimento = Integer.parseInt(arrayDataNascimento[2]);

		if(mesDataAtual > mesDataNascimento) {
			idade = anoDataAtual - anoDataNascimento;
		} else if(mesDataAtual < mesDataNascimento) {
			idade = (anoDataAtual - anoDataNascimento)-1;
		} else {
			if(diaDataAtual < diaDataNascimento) {
				idade = (anoDataAtual - anoDataNascimento)-1;
			} else {
				idade = anoDataAtual - anoDataNascimento;
			}
		}
		return idade;
	}
}
