package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dominio.PessoaFisica;

public class PessoaFisicaDAOimpl implements PessoaFisicaDAO {

	private EntityManager em;

	public PessoaFisicaDAOimpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pessoaFisica);
		tx.commit();

	}

	@Override
	public void alterar(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(pessoaFisica);
		tx.commit();

	}

	@Override
	public void remover(PessoaFisica pessoaFisica) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(pessoaFisica);
		tx.commit();

	}

	public PessoaFisica pesquisar (String  cpf) {
		PessoaFisica pessoa = em.find(PessoaFisica.class, cpf);
		return pessoa;
	}

	@Override
	public List<PessoaFisica> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void resultquery() {
		Query q = em.createNativeQuery("SELECT  pf.nome,\r\n"
				+ "                pf.data_cadastro,\r\n"
				+ "                en.rua,\r\n"
				+ "                en.numero,\r\n"
				+ "                en.complemento,\r\n"
				+ "                en.bairro,\r\n"
				+ "                en.cidade,\r\n"
				+ "                en.uf,\r\n"
				+ "                en.cep\r\n"
				+ "FROM   pessoa_fisica pf,\r\n"
				+ "       endereco en,\r\n"
				+ "       conta_cliente cc,\r\n"
				+ "       mov_clientes movic\r\n"
				+ "WHERE  cpf = '11765876'\r\n"
				+ "       AND tp_mov = 'D'\r\n"
				+ "       AND pf.endereco_id_endereco = en.id_endereco");
		
		List<Object[]> obj = q.getResultList();
		for (Object[] objects : obj) {
			System.out.println("Nome:" + objects[0]);
			
		}
	}

}
