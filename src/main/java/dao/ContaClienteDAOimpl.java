package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ContaClienteDAOimpl implements ContaClienteDAO {

	private EntityManager em;

	public ContaClienteDAOimpl(EntityManager em) {
		this.em = em;
	}

	public void salvar(ContaClienteDAO contaCliente) {
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		em.persist(contaCliente);
		tx.commit();

	}

	public void alterar(ContaClienteDAO contaCliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(contaCliente);
		tx.commit();

	}

	public void remover(ContaClienteDAO contaCliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(contaCliente);
		tx.commit();

	}

	public ContaClienteDAO pesquisar(int codConta) {
		ContaClienteDAO contaCliente = em.find(ContaClienteDAO.class, codConta);
		return contaCliente;
	}

	public List<ContaClienteDAO> recuperarTodos() {
		Query query = em.createQuery("from CONTA_CLIENTE e");
		List<ContaClienteDAO> contaCliente = query.getResultList();
		return contaCliente;
	}

}
