package com.coletaTech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id_produtos;
	private String desc_produtos;

	@Id
	@GeneratedValue
	public Long getId_produtos() {
		return id_produtos;
	}

	public void setId_produtos(Long id_produtos) {
		this.id_produtos = id_produtos;
	}

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	public String getDesc_produtos() {
		return desc_produtos;
	}

	public void setDesc_produtos(String desc_produtos) {
		this.desc_produtos = desc_produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((desc_produtos == null) ? 0 : desc_produtos.hashCode());
		result = prime * result
				+ ((id_produtos == null) ? 0 : id_produtos.hashCode());
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
		Produto other = (Produto) obj;
		if (desc_produtos == null) {
			if (other.desc_produtos != null)
				return false;
		} else if (!desc_produtos.equals(other.desc_produtos))
			return false;
		if (id_produtos == null) {
			if (other.id_produtos != null)
				return false;
		} else if (!id_produtos.equals(other.id_produtos))
			return false;
		return true;
	}

}