package com.josepojr.soreclamacoes.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
}
