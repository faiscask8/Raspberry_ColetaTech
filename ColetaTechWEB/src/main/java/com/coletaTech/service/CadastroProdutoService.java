package com.coletaTech.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.coletaTech.model.Produto;
import com.coletaTech.repository.Produtos;
import com.coletaTech.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	
}
