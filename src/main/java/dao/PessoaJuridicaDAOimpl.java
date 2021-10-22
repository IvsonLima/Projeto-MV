package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dominio.PessoaJuridica;

public class PessoaJuridicaDAOimpl implements PessoaJuridicaDAO {

	private EntityManager em;

	public PessoaJuridicaDAOimpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(PessoaJuridica pessoaJuridica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pessoaJuridica);
		tx.commit();

	}

	@Override
	public void alterar(PessoaJuridica pessoaJuridica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(pessoaJuridica);
		tx.commit();

	}

	@Override
	public void remover(PessoaJuridica pessoaJuridica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(pessoaJuridica);
		tx.commit();

	}

	public PessoaJuridica pesquisar (String  cnpj) {
		PessoaJuridica pessoaJ = em.find(PessoaJuridica.class, cnpj);
		return pessoaJ;
	}

	@Override
	public List<PessoaJuridica> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
