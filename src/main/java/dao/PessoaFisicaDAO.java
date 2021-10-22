package dao;

import java.util.List;

import dominio.PessoaFisica;

public interface PessoaFisicaDAO {

	public void salvar (PessoaFisica pessoaFisica);
	public void alterar (PessoaFisica pessoaFisica);
	public void remover (PessoaFisica pessoaFisica);
	public PessoaFisica pesquisar (String  cpf);
	public List<PessoaFisica> recuperarTodos();
	
}
