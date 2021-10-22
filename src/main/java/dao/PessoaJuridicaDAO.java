package dao;

import java.util.List;

import dominio.PessoaJuridica;

public interface PessoaJuridicaDAO {

	public void salvar (PessoaJuridica pessoaJuridica);
	public void alterar (PessoaJuridica pessoaJuridica);
	public void remover (PessoaJuridica pessoaJuridica);
	public PessoaJuridica pesquisar (String  cnpj);
	public List<PessoaJuridica> recuperarTodos();
	
}
