package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dominio.Endereco;

public class EnderecoDAOimpl implements EnderecoDAO {

	private EntityManager em;

	public EnderecoDAOimpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Endereco endereco) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(endereco);
		tx.commit();

	}

	@Override
	public void alterar(Endereco endereco) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(endereco);
		tx.commit();

	}

	@Override
	public void remover(Endereco endereco) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(endereco);
		tx.commit();

	}

	public Endereco pesquisar(int id) {
		Endereco endereco = em.find(Endereco.class, id);
		return endereco;
	}

	@Override
	public List<Endereco> recuperarTodos() {

		return null;
	}

}
