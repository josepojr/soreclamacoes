package com.josepojr.soreclamacoes.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josepojr.soreclamacoes.dominio.Empresa;

@Repository
public interface EmpresaRepositorio extends MongoRepository<Empresa, Long> {

}
