package br.com.pi.drot.utils;

public class FormatadorCPF {

	public static String cleanCpf(String CPF) {
		char [] CPFFormatado = new char[11];
		int contadorDigitosCPF = 0;

		for (int i = 0; i < CPF.length(); i++) {
			if (CPF.charAt(i) != '.' && CPF.charAt(i) != '-') {
				CPFFormatado[contadorDigitosCPF] = CPF.charAt(i);
				contadorDigitosCPF++;
			}
		}

		return new String(CPFFormatado);
	}

}
