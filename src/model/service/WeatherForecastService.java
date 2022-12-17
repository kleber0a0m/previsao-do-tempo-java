package model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WeatherForecastService {
	
	private static String URL_API_SEVEN_DAYS_BY_CITY = "http://servicos.cptec.inpe.br/XML/cidade/7dias/%d/previsao.xml";
	
	private static String fromURL (String urlString) throws IOException {
        URL url = new URL(urlString);
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
            System.out.println( stringBuilder.toString());

        return stringBuilder.toString();
    }
	
	public static String sevenDaysWeatherForecast(int cityCode) throws IOException {
		String url = String.format(URL_API_SEVEN_DAYS_BY_CITY, cityCode);
		
		return fromURL(url);
	}
}
