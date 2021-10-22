package dao;

import java.util.List;

import dominio.MovClientes;

public interface MovClientesDAO {

	public void salvar (MovClientes movClientes);
	public void alterar (MovClientes movClientes);
	public void remover (MovClientes movClientes);
	public MovClientes pesquisar (int mov);
	public List<MovClientes> recuperarTodos();
	
}
