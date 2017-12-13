package com.josepojr.soreclamacoes.dominio;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Reclamacao {
	
	@Id
	private ObjectId id;
	
	private String titulo;
	
	private String descricao;
	
	private Empresa empresa;
	
	private Localidade localidade;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(300);
		builder.append("Reclamacao [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", localidade=");
		builder.append(localidade);
		builder.append("]");
		return builder.toString();
	}
}
