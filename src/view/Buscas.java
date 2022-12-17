package view;

import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import model.Cidade;
import model.CidadeBusca;
import model.Cidades;
import model.Previsao;
import model.service.BuscarCidadeAPI;
import model.service.WeatherForecastService;

public class Buscas {

	public static Cidade previsao(int idCidade) {	
		try {
			String previsao = WeatherForecastService.sevenDaysWeatherForecast(idCidade);
			

			XStream xstream = new XStream();
			
			// Ajuste de segurança do XStream
			Class<?>[] classes = new Class[] {Cidade.class, Previsao.class};
			xstream.allowTypes(classes);
			
			xstream.alias("cidade", Cidade.class);
			xstream.alias("previsao", Previsao.class);
			
			xstream.addImplicitCollection(Cidade.class, "previsoes");
			
			Cidade c = (Cidade) xstream.fromXML(previsao);
                        return c;
			
		} catch (IOException e) {
			System.out.println("Erro ao consultar API de clima.");
			e.printStackTrace();
                        return new Cidade();
		}
	}
        
        public static Cidades buscaCidade(String nomeCidade) throws IOException {	
            BuscarCidadeAPI buscarCidadeAPI = new BuscarCidadeAPI();
            String xml = buscarCidadeAPI.fromURL(nomeCidade);
            
            XStream xstream = new XStream();

            // Ajuste de segurança do XStream
            Class<?>[] classes = new Class[] {Cidades.class, CidadeBusca.class};
            xstream.allowTypes(classes);

            xstream.alias("cidades", Cidades.class);
            xstream.alias("cidade", CidadeBusca.class);

            xstream.addImplicitCollection(Cidades.class, "cidade");

            Cidades c = (Cidades) xstream.fromXML(xml);
            System.out.println(c.getCidade().size());
                return c;

            }
}