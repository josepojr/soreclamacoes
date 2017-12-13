package com.josepojr.soreclamacoes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josepojr.soreclamacoes.dominio.Localidade;

@Repository
public interface LocalidadeRepositorio extends MongoRepository<Localidade, Long> {

}
