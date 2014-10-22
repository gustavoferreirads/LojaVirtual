package br.com.lojavirtual.util;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.Normalizer;
import java.util.List;

public class Strings {

    public static Boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }


    public static String padRight(String string, Integer tamanhoMinimo, char padChar) {
        return com.google.common.base.Strings.padEnd(string, tamanhoMinimo, padChar);
    }

    public static String padLeft(String string, Integer tamanhoMinimo, char padChar) {
        return com.google.common.base.Strings.padStart(string, tamanhoMinimo, padChar);
    }

    public static String hashMD5(String stringToBeHashed) {
        return DigestUtils.md5Hex(stringToBeHashed);
    }

    public static String join(String joinChar, String... stringsToBeJoined) {
        Joiner joiner = Joiner.on(joinChar).skipNulls();
        return joiner.join(stringsToBeJoined);
    }

    public static String join(String... stringsToBeJoined) {
        return join("", stringsToBeJoined);
    }

    public static String join(List<String> stringsToBeJoined) {
        return join("", stringsToBeJoined.toArray(new String[stringsToBeJoined.size()]));
    }

    public static String join(String joinChar, List<String> stringsToBeJoined) {
        return join(joinChar, stringsToBeJoined.toArray(new String[stringsToBeJoined.size()]));
    }

    public static String capitalize(String name) {
        return String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static String firstLetterToUpperCase(String name) {
        return String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1);
    }

    public static String convertToStringRepresentation(Long value) {
        final long K = 1024, M = K * K, G = M * K, T = G * K;
        final long[] dividers = new long[]{T, G, M, K, 1};
        final String[] units = new String[]{"TB", "GB", "MB", "KB", "B"};
        String result = "";
        if (value != null) {
            if (value < 1)
                throw new IllegalArgumentException("Tamano de arquivo inválido: " + value);

            for (int i = 0; i < dividers.length; i++) {
                final long divider = dividers[i];
                if (value >= divider) {
                    result = format(value, divider, units[i]);
                    break;
                }
            }
        }
        return result;
    }

    private static String format(final long value, final long divider, final String unit) {
        final double result =
                divider > 1 ? (double) value / (double) divider : (double) value;
        return String.format("%.1f %s", Double.valueOf(result), unit);
    }

    public static String removeAccentAndReplaceBlankWithTraceFrom(String string) {
        return replaceBlankWithTraceFrom(removeAccentFrom(string));
    }

    public static String removeAccentFrom(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String replaceBlankWithTraceFrom(String string) {
        return string.replaceAll("\\s+", "-");
    }

}
