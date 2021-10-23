package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dominio.ContaCliente;

public class ContaClienteDAOimpl implements ContaClienteDAO {

	private EntityManager em;

	public ContaClienteDAOimpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(ContaCliente contaCliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(contaCliente);
		tx.commit();

	}

	@Override
	public void alterar(ContaCliente contaCliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contaCliente);
		tx.commit();

	}

	@Override
	public void remover(ContaCliente contaCliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(contaCliente);
		tx.commit();

	}

	public ContaCliente pesquisar(int codConta) {
		ContaCliente contaCliente = em.find(ContaCliente.class, codConta);
		return contaCliente;
	}

	public List<ContaCliente> recuperarTodos() {
		Query query = em.createQuery("from CONTA_CLIENTE e");
		List<ContaCliente> contaCliente = query.getResultList();
		return contaCliente;
	}

}
