package com.coletaTech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_usuario")
public class Grupo_usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_grupo;
	private String nome_grupo;
	private String descricao_grupo;

	@Id
	@GeneratedValue
	public Long getId_grupo() {
		return id_grupo;
	}

	public void setId(Long id_grupo) {
		this.id_grupo = id_grupo;
	}

	@Column(nullable = false, length = 40)
	public String getNome_grupo() {
		return nome_grupo;
	}

	public void setNome_grupo(String nome_grupo) {
		this.nome_grupo = nome_grupo;
	}

	@Column(nullable = false, length = 80)
	public String getDescricao_grupo() {
		return descricao_grupo;
	}

	public void setDescricao_grupo(String descricao_grupo) {
		this.descricao_grupo = descricao_grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_grupo == null) ? 0 : id_grupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo_usuario other = (Grupo_usuario) obj;
		if (id_grupo == null) {
			if (other.id_grupo != null)
				return false;
		} else if (!id_grupo.equals(other.id_grupo))
			return false;
		return true;
	}

}