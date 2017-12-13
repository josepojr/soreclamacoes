package com.josepojr.soreclamacoes.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.josepojr.soreclamacoes.dominio.Localidade;
import com.josepojr.soreclamacoes.dominio.Reclamacao;
import com.josepojr.soreclamacoes.repositorio.ReclamacaoRepositorio;


@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {
	
	@Autowired
	private ReclamacaoRepositorio reclamacaoRepositorio;


	@RequestMapping(value = "/findWithReclamacao", method = RequestMethod.GET)
	public List<Localidade> findWithReclamacao() {
		final Map<ObjectId, Localidade> localidades = new TreeMap<>();
		
		final List<Reclamacao> reclamacoes = reclamacaoRepositorio.findAll();
		
		for(final Reclamacao reclamacao: reclamacoes) {
			if(reclamacao.getLocalidade() != null) {
				final Localidade localidade = reclamacao.getLocalidade();
				
				if(!localidades.containsKey(localidade.getId())) {
					localidades.put(localidade.getId(), localidade);
				}
			}
		}
		
		return new ArrayList<>(localidades.values());
	}
	
	@RequestMapping(value = "/find/{filtro}", method = RequestMethod.GET)
	public List<Localidade> findByFiltro(@PathVariable("filtro") String filtro) {
		final List<Localidade> result = new ArrayList<>();
		
		result.add(buildLocalidade("São Paulo", BigDecimal.valueOf(-23.550496), BigDecimal.valueOf(-46.6334481)));
		result.add(buildLocalidade("Minas Gerais", BigDecimal.valueOf(-22.8744545), BigDecimal.valueOf(-43.1115577)));
		result.add(buildLocalidade("Rio de Janeiro", BigDecimal.valueOf(-22.9070293), BigDecimal.valueOf(-43.1807216)));
		
		System.out.println("filtro: " + filtro);
		
		return result;
	}
	
	private Localidade buildLocalidade(final String nome, final BigDecimal latitude, final BigDecimal longitude) {
		final Localidade localidade = new Localidade();
		localidade.setNome(nome);
		localidade.setLatitude(latitude);
		localidade.setLongitude(longitude);
		
		return localidade;
	}
}
