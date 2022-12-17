package model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BuscarCidadeAPI {
	
	public static String fromURL (String urlString) throws IOException {
        URL url = new URL("http://servicos.cptec.inpe.br/XML/listaCidades?city="+urlString);
        HttpURLConnection httpConnection;
        httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("charset", "UTF-8");
        httpConnection.setReadTimeout(10000); // milisegundos
        httpConnection.setConnectTimeout(15000); // milisegundos
        httpConnection.setDoOutput(true);
        httpConnection.connect();
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        
        String line;
        while ((line = buffer.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }

        buffer.close();
        httpConnection.disconnect();

        return stringBuilder.toString();
    }
	

}
