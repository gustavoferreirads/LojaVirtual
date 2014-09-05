package br.com.lojavirtual.util;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.net.URL;


public class FileUtils {


	public static String toString(String path) {
		try {
			URL url = Resources.getResource(path);
			return Resources.toString(url, Charsets.UTF_8);
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
	}
}
