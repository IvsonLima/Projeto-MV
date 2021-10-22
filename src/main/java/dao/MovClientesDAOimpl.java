package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dominio.MovClientes;

public class MovClientesDAOimpl implements MovClientesDAO {

	private EntityManager em;

	public MovClientesDAOimpl(EntityManager em) {
		this.em = em;
	}

	
	@Override
	public void salvar(MovClientes movClientes) {
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		em.persist(movClientes);
		tx.commit();
		
	}

	@Override
	public void alterar(MovClientes movClientes) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(movClientes);
		tx.commit();
		
	}

	@Override
	public void remover(MovClientes movClientes) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(movClientes);
		tx.commit();
		
	}

	@Override
	public MovClientes pesquisar(int mov) {
		MovClientes movCliente = em.find(MovClientes.class, mov);
		return movCliente;
	}

	@Override
	public List<MovClientes> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
