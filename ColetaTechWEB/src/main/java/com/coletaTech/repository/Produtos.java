package com.coletaTech.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.coletaTech.model.Produto;
import com.coletaTech.service.NegocioException;
import com.coletaTech.util.jpa.Transactional;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	@Transactional
	public void remover(Produto produto) {
		try {
			produto = porId_produto(produto.getId_produtos());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}

	public Produto porCodigo(String sku) {
		try {
			return manager
					.createQuery("from Produto where upper(sku) = :sku",
							Produto.class)
					.setParameter("sku", sku.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/*	@SuppressWarnings("unchecked")
	//public List<Produto> filtrados(ProdutoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);

		if (StringUtils.isNotBlank(filtro.getSku())) {
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),
					MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}
*/
	
	public Produto porId_produto(Long id_produto) {
		return manager.find(Produto.class, id_produto);
	}

	public List<Produto> porNome(String nome) {
		return this.manager
				.createQuery(
						"from Produto where upper(desc_produto) like :nome",
						Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
