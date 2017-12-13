package com.josepojr.soreclamacoes.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PaginaInicialController {
	
	@RequestMapping("/")
	public String home() {
		final StringBuilder str = new StringBuilder(1000);
		str.append("<html>");
		str.append("<head>");
		str.append("<title>");
		str.append("soreclamacoes");
		str.append("</title>");
		str.append("</head>");
		str.append("<body>");
		str.append("Bem vindo ao site <b> soreclamacoes </b> <br><br>");
		str.append("Acesse os seguintes serviços: <br><br>");
		
		// Pagina inicial.
		final String url0 = "http://127.0.0.1:8080/";
		final String titulo0 = "Página inicial: ";
		
		str.append(buildLink(url0, titulo0));
		
		// Busca de reclamções por empresa.
		final String url1 = "http://127.0.0.1:8080/reclamacao/findEmpresa/Global%20S%26A";
		final String titulo1 = "Busca de reclamações pela empresa Global S&A: ";

		str.append(buildLink(url1, titulo1));
		
		final String url2 = "http://127.0.0.1:8080/reclamacao/findEmpresa/Tecno%20Ltda";
		final String titulo2 = "Busca de reclamações pela empresa Tecno Ltda: ";

		str.append(buildLink(url2, titulo2));
		
		final String url3 = "http://127.0.0.1:8080/reclamacao/findEmpresa/Super%20Star%20S%26A";
		final String titulo3 = "Busca de reclamações pela empresa Super Star S&A: ";

		str.append(buildLink(url3, titulo3));
		
		// Busca de reclamações por localidade.
		final String url4 = "http://127.0.0.1:8080/reclamacao/findLocalidade/S%C3%A3o%20Paulo";
		final String titulo4 = "Busca de reclamações pela localidade São Paulo: ";

		str.append(buildLink(url4, titulo4));
		
		final String url5 = "http://127.0.0.1:8080/reclamacao/findLocalidade/Minas%20Gerais";
		final String titulo5 = "Busca de reclamações pela localidade Minas Gerais: ";

		str.append(buildLink(url5, titulo5));
		
		final String url6 = "http://127.0.0.1:8080/reclamacao/findLocalidade/Rio%20de%20Janeiro";
		final String titulo6 = "Busca de reclamações pela localidade Rio de Janeiro: ";

		str.append(buildLink(url6, titulo6));
		
		final String url7 = "http://127.0.0.1:8080/reclamacao/findLocalidade/Brasilia";
		final String titulo7 = "Busca de reclamações pela localidade Brasilia: ";

		str.append(buildLink(url7, titulo7));
		
		// Busca de localidades com reclamações.
		final String url8 = "http://127.0.0.1:8080/localizacao/findWithReclamacao";
		final String titulo8 = "Busca de localidades com reclamações: ";

		str.append(buildLink(url8, titulo8));
		
		str.append("</body>");
		str.append("</html>");
		
		return str.toString();
	}
	
	private String buildLink(final String url, final String titulo) {
		final StringBuilder str = new StringBuilder(200);
		
		str.append("<p>");
		
		str.append(titulo);
		str.append("<a href=\"");
		str.append(url);
		str.append("\" target=\"_blank\" >");
		str.append(url);
		str.append("</a>");
		str.append("</p>");
		
		return str.toString();
	}
}
