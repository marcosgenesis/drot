package br.com.pi.drot.utils;

public class CleanFormatCpf {

	public static String cleanCpf(String cpf) {
		char [] cpfClean = new char[11];
		int countDigitCpfClean = 0;

		for (int i = 0; i < cpf.length(); i++) {
			if (cpf.charAt(i) != '.' && cpf.charAt(i) != '-') {
				cpfClean[countDigitCpfClean] = cpf.charAt(i);
				countDigitCpfClean++;
			}
		}

		return new String(cpfClean);
	}

}
