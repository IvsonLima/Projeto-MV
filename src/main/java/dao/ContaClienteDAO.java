package dao;

import java.util.List;

import dominio.ContaCliente;

public interface ContaClienteDAO {

	public void salvar (ContaCliente contaCliente);
	public void alterar (ContaCliente contaCliente);
	public void remover (ContaCliente contaCliente);
	public ContaCliente pesquisar (int codConta);
	public List<ContaCliente> recuperarTodos();
}
