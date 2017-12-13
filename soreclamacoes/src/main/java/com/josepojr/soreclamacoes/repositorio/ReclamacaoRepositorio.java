package com.josepojr.soreclamacoes.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josepojr.soreclamacoes.dominio.Reclamacao;

@Repository
public interface ReclamacaoRepositorio extends MongoRepository<Reclamacao, Long> {

	
	public List<Reclamacao> findByEmpresaNome(String nome);
	
	public List<Reclamacao> findByLocalidadeNome(String nome);
}
