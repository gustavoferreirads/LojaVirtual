package br.com.lojavirtual.util;

import java.util.*;

public class Utils {

    private Utils(){}

    public static <T> T[] sort(T[] values) {
        List<T> list = Arrays.asList(values);
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return values;
    }

	public static <T> T lastValueOf(List<T> list) {
		return list.get(list.size() - 1);
	}

	public static <T, S> List<Map.Entry<T, S>> mapToList(Map<T, S> map) {

		if (map == null) {
			return null;
		}

		List<Map.Entry<T, S>> list = new ArrayList<Map.Entry<T, S>>();
		list.addAll(map.entrySet());

		return list;
	}
}
