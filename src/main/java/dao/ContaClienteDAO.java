package dao;

import java.util.List;

public interface ContaClienteDAO {

	public void salvar (ContaClienteDAO contaCliente);
	public void alterar (ContaClienteDAO contaCliente);
	public void remover (ContaClienteDAO contaCliente);
	public ContaClienteDAO pesquisar (int codConta);
	public List<ContaClienteDAO> recuperarTodos();
}
