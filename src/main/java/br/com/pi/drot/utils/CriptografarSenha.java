package br.com.pi.drot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografarSenha {

	public static String criptografarSenha(String senha) {
		String retorno = "";

		MessageDigest messageDigest;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, messageDigest.digest(senha.getBytes()));

			retorno = hash.toString(16);
		} catch (Exception e) {
			return null;
		}

		return retorno;
	}

}
