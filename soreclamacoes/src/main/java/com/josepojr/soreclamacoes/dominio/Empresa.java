package com.josepojr.soreclamacoes.dominio;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Empresa {
	
	@Id
	private ObjectId id;
	
	private String nome;
	
	private String descricao;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(200);
		builder.append("Empresa [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
}
