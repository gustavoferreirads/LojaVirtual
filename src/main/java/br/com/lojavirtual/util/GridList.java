package br.com.lojavirtual.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


import static java.lang.String.format;

/**
 * Created by Gustavo Ferreira on 31/01/2015.
 */
public class GridList {

    public static String formatJsonList(HttpServletResponse response, List<?> lista, Integer current, Integer rowCount,String size) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonList = new Gson().toJson(lista);
        StringBuilder builder = new StringBuilder("{ \"current\": %s, \"rowCount\": %s,\"rows\": ").append(jsonList).append(",\"total\": %s}");
        return format(builder.toString(), current, rowCount, size);
    }
}
