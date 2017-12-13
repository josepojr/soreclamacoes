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
		str.append("</body>");
		str.append("</html>");
		
		return str.toString();
	}
}
