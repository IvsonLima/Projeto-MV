package dao;

import java.util.List;

import dominio.Endereco;

public interface EnderecoDAO {

	public void salvar (Endereco endereco);
	public void alterar (Endereco endereco);
	public void remover (Endereco endereco);
	public Endereco pesquisar (int  id);
	public List<Endereco> recuperarTodos();
	
}
