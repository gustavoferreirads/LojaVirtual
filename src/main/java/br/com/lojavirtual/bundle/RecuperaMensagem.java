package br.com.lojavirtual.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class RecuperaMensagem {
	static ResourceBundle resourceBundle;

	public static String getMensagem(String chave) {
		resourceBundle = ResourceBundle.getBundle("br.com.lojavirtual.bundle.messages", new Locale ("pt", "BR"));
		return resourceBundle.getString(chave);
	}
}
