package com.josepojr.soreclamacoes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.josepojr.soreclamacoes.dominio.Reclamacao;
import com.josepojr.soreclamacoes.repositorio.ReclamacaoRepositorio;

@RestController
@RequestMapping("/reclamacao")
public class ReclamacaoController {
	
	@Autowired
	private ReclamacaoRepositorio reclamacaoRepositorio;

	@RequestMapping(value = "/findEmpresa/{empresa}", method = RequestMethod.GET)
	public List<Reclamacao> findByEmpresa(@PathVariable("empresa") String filtro) {
		final List<Reclamacao> result = reclamacaoRepositorio.findByEmpresaNome(filtro);
		
		System.out.println("filtro: " + filtro);
		
		return result;
	}
	
	@RequestMapping(value = "/findLocalidade/{localidade}", method = RequestMethod.GET)
	public List<Reclamacao> findByLocalidade(@PathVariable("localidade") String filtro) {
		final List<Reclamacao> result = reclamacaoRepositorio.findByLocalidadeNome(filtro);
		
		System.out.println("filtro: " + filtro);
		
		return result;
	}
}
