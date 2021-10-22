package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dominio.PessoaFisica;

public class PessoaFisicaDAOimpl implements PessoaFisicaDAO {

	private EntityManager em;

	public PessoaFisicaDAOimpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pessoaFisica);
		tx.commit();

	}

	@Override
	public void alterar(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(pessoaFisica);
		tx.commit();

	}

	@Override
	public void remover(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(pessoaFisica);
		tx.commit();

	}

	public PessoaFisica pesquisar (String  cpf) {
		PessoaFisica pessoa = em.find(PessoaFisica.class, cpf);
		return pessoa;
	}

	@Override
	public List<PessoaFisica> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
