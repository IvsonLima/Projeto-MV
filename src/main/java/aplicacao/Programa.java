package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import dao.ContaClienteDAO;
import dao.ContaClienteDAOimpl;
import dao.EnderecoDAO;
import dao.EnderecoDAOimpl;
import dao.MovClientesDAO;
import dao.MovClientesDAOimpl;
import dao.PessoaFisicaDAO;
import dao.PessoaFisicaDAOimpl;
import dao.PessoaJuridicaDAO;
import dao.PessoaJuridicaDAOimpl;
import dominio.ContaCliente;
import dominio.Endereco;
import dominio.MovClientes;
import dominio.PessoaFisica;
import dominio.PessoaJuridica;
import util.JpaUtil;

public class Programa {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAOimpl(JpaUtil.getEntityManager());
		PessoaJuridicaDAO pessoaJuridicaDao = new PessoaJuridicaDAOimpl(JpaUtil.getEntityManager());
		EnderecoDAO enderecoDAo = new EnderecoDAOimpl(JpaUtil.getEntityManager());
		ContaClienteDAO contaCliDao = new ContaClienteDAOimpl(JpaUtil.getEntityManager());
		MovClientesDAO movimDao = new MovClientesDAOimpl(JpaUtil.getEntityManager());

		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		Endereco endereco = new Endereco();
		ContaCliente contaCliente = new ContaCliente();
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		MovClientes movi = new MovClientes();

		int opcao = 0;

		while (opcao != 10) {
			System.out.println("-----------------------------------------");
			System.out.println("(1) - CADASTRAR CLIENTE");
			System.out.println("(2) - EDITAR CLIENTE");
			System.out.println("(3) - REMOVER CLIENTE");
			System.out.println("(4) - PESQUISAR CLIENTE");
			System.out.println("(5) - CADASTRAR MOVIMENTA��O");
			System.out.println("(6) - RELAT�RIO DE SALDO DO CLIENTE X");
			System.out.println("(7) - RELAT�RIO DE SALDO DO CLIENTE X E PER�ODO");
			System.out.println("(8) - RELAT�RIO DE SALDO TODOS OS CLIENTES");
			System.out.println("(9) - RELAT�RIO DE RECEITA DA EMPRESA X POR PER�ODO");
			System.out.println("(10) - SAIR");
			System.out.println("-----------------------------------------");
			System.out.println("Digite uma das Op��ea Acima: ");
			int num = ler.nextInt();

			switch (num) {
			case 1:
				System.out.println("----------------- Cadastrar Cliente -----------------");
				System.out.println("(1) - PESSOA F�SICA");
				System.out.println("(2) - PESSOA JUR�DICA");
				int num2 = ler.nextInt();
				if (num2 == 1) {
					System.out.println("Nome: ");
					ler.nextLine();
					pessoaFisica.setNome(ler.nextLine());
					System.out.println("RG: ");
					pessoaFisica.setRg(ler.next());
					System.out.println("Org�o Emissor: ");
					pessoaFisica.setOrgEmissor(ler.next());
					System.out.println("CPF: ");
					pessoaFisica.setCpf(ler.next());
					System.out.println("Telefone: ");
					pessoaFisica.setTelefone(ler.next());
					System.out.println("Email: ");
					pessoaFisica.setEmail(ler.next());
					System.out.println("Data Nascimento: ");
					pessoaFisica.setDataNascimento(ler.next());
					pessoaFisica.setDataCadastro(timeStamp);
				} else {
					System.out.println("Nome Fantasia: ");
					pessoaJuridica.setNomeFantasia(ler.nextLine());
					ler.nextLine();
					System.out.println("CNPJ: ");
					pessoaJuridica.setCnpj(ler.next());
					System.out.println("Inscri��o Estadual: ");
					pessoaJuridica.setInscricaoEstadual(ler.next());
					System.out.println("Inscri��o Municipal: ");
					pessoaJuridica.setFoneFax(ler.next());
					System.out.println("Validade da Inscri��o Municipal: ");
					pessoaJuridica.setValidadeInscricaoEst(ler.next());
					System.out.println("Telefone: ");
					pessoaJuridica.setFoneFax(ler.next());
					pessoaJuridica.setDataCadastroPf(timeStamp);
					

				}
				System.out.println("----------------- Cadastrar Endere�o -----------------");
				System.out.println("Rua: ");
				ler.nextLine();
				endereco.setRua(ler.nextLine());
				System.out.println("N�mero: ");
				endereco.setNumero(ler.nextInt());
				System.out.println("Complemento: ");
				ler.nextLine();
				endereco.setComplemento(ler.nextLine());
				System.out.println("Bairro: ");
				endereco.setBairro(ler.nextLine());
				System.out.println("Cidade: ");
				endereco.setCidade(ler.nextLine());
				System.out.println("UF: ");
				endereco.setUf(ler.next());
				System.out.println("Cep: ");
				endereco.setCep(ler.next());

				System.out.println("----------------- Cadastrar Conta -----------------");
				System.out.println("C�digo da Conta: ");
				int numeroConta = ler.nextInt();
				contaCliente.setNumero(numeroConta);
				movi.setNumeroConta(numeroConta);
				System.out.println("ATEN��O! [Cliente Novo � necess�rio cadastrar uma movimenta��o Inicial!]");
				System.out.println("Digite: (1) - Movimenta��o de Despesa");
				System.out.println("Digite: (2) - Movimenta��o de Receita");
				int mov = ler.nextInt();
				if (mov == 1) {
					movi.setTpMov("D");
					System.out.println("Digite o valor da movimenta��o: ");
					double valor = ler.nextDouble();
					contaCliente.setSaldoAtual(valor);
					movi.setValorMov(valor);
					contaCliente.setSaldoInicial(valor);
					movi.setDataMov(timeStamp);
				} else {
					try {
						movi.setTpMov("R");
						System.out.println("Digite o valor da movimenta��o: ");
						double valor = ler.nextDouble();
						contaCliente.setSaldoAtual(valor);
						movi.setValorMov(valor);
						contaCliente.setSaldoInicial(valor);
						movi.setDataMov(timeStamp);
					} finally {

					}

				}
				contaCliente.setDataAtualizacao(timeStamp);
				if (pessoaFisica.getCpf().isEmpty()) {
					try {
						movimDao.salvar(movi);
						enderecoDAo.salvar(endereco);
						contaCliDao.salvar(contaCliente);
						pessoaJuridica.setEndereco(endereco);
						pessoaJuridica.setContaCli(contaCliente);
						pessoaJuridicaDao.salvar(pessoaJuridica);
					} finally {

					}
				} else {
					try {
						movimDao.salvar(movi);
						enderecoDAo.salvar(endereco);
						contaCliDao.salvar(contaCliente);
						pessoaFisica.setEndereco(endereco);
						pessoaFisica.setContaCli(contaCliente);
						pessoaFisicaDao.salvar(pessoaFisica);
					} finally {

					}
				}
				System.out.println("Cliente Cadastrado Com Sucesso!!");
				break;

			case 2:
				System.out.println("----------------- Alterar Dados do Cliente -----------------");
				System.out.println("Digite (1) - Pessoa F�sica ");
				System.out.println("Digite (2) - Pessoa Jur�dica ");
				int num3 = ler.nextInt();
				if (num3 == 1) {
					System.out.println("Digite o CPF: ");
					ler.nextLine();
					String cpf = ler.nextLine();
					PessoaFisica pessoa = pessoaFisicaDao.pesquisar(cpf);
					if (pessoa != null) {
						int op = 0;
						while (op != 4) {
							System.out.println("-------------------------------------------------");
							System.out.println("(1) - Alterar Dados: ");
							System.out.println("(2) - Alterar Endereco ");
							System.out.println("(3) - Alterar Conta: ");
							System.out.println("(4) - Cancelar");
							System.out.println("-------------------------------------------------");
							int n = ler.nextInt();

							switch (n) {
							case 1:
								System.out.println("-------------------------------------------------");
								System.out.println("Nome: ");
								ler.nextLine();
								pessoaFisica.setNome(ler.nextLine());
								System.out.println("RG: ");
								pessoaFisica.setRg(ler.next());
								System.out.println("Org�o Emissor: ");
								pessoaFisica.setOrgEmissor(ler.next());
								System.out.println("CPF: ");
								pessoaFisica.setCpf(ler.next());
								System.out.println("Telefone: ");
								pessoaFisica.setTelefone(ler.next());
								System.out.println("Email: ");
								pessoaFisica.setEmail(ler.next());
								System.out.println("Data Nascimento: ");
								pessoaFisica.setDataNascimento(ler.next());
								break;

							case 2:
								System.out.println("-----------------Alterar Endereco -----------------");
								System.out.println("Rua: ");
								ler.nextLine();
								endereco.setRua(ler.nextLine());
								System.out.println("N�mero: ");
								endereco.setNumero(ler.nextInt());
								System.out.println("Complemento: ");
								ler.nextLine();
								endereco.setComplemento(ler.nextLine());
								System.out.println("Bairro: ");
								endereco.setBairro(ler.nextLine());
								System.out.println("Cidade: ");
								endereco.setCidade(ler.nextLine());
								System.out.println("UF: ");
								endereco.setUf(ler.next());
								System.out.println("Cep: ");
								endereco.setCep(ler.next());
								break;

							}
						}
					}
				} else {
					System.out.println("Digite o CNPJ: ");
					ler.nextLine();
					String cnpj = ler.nextLine();
					PessoaJuridica pessoaJ = pessoaJuridicaDao.pesquisar(cnpj);
					if (pessoaJ != null) {
						int op = 0;
						while (op != 4) {
							System.out.println("-------------------------------------------------");
							System.out.println("(1) - Alterar Dados: ");
							System.out.println("(2) - Alterar Endereco ");
							System.out.println("(3) - Alterar Conta: ");
							System.out.println("(4) - Cancelar");
							System.out.println("-------------------------------------------------");
							int n = ler.nextInt();

							switch (n) {
							case 1:
								System.out.println("-------------------------------------------------");
								System.out.println("Nome Fantasia: ");
								pessoaJuridica.setNomeFantasia(ler.nextLine());
								ler.nextLine();
								System.out.println("CNPJ: ");
								pessoaJuridica.setCnpj(ler.next());
								System.out.println("Inscri��o Estadual: ");
								pessoaJuridica.setInscricaoEstadual(ler.next());
								System.out.println("Inscri��o Municipal: ");
								pessoaJuridica.setFoneFax(ler.next());
								System.out.println("Validade da Inscri��o Municipal: ");
								pessoaJuridica.setValidadeInscricaoEst(ler.next());
								System.out.println("Telefone: ");
								pessoaJuridica.setFoneFax(ler.next());
								break;

							case 2:
								System.out.println("-----------------Alterar Endereco -----------------");
								System.out.println("Rua: ");
								ler.nextLine();
								endereco.setRua(ler.nextLine());
								System.out.println("N�mero: ");
								endereco.setNumero(ler.nextInt());
								System.out.println("Complemento: ");
								ler.nextLine();
								endereco.setComplemento(ler.nextLine());
								System.out.println("Bairro: ");
								endereco.setBairro(ler.nextLine());
								System.out.println("Cidade: ");
								endereco.setCidade(ler.nextLine());
								System.out.println("UF: ");
								endereco.setUf(ler.next());
								System.out.println("Cep: ");
								endereco.setCep(ler.next());
								break;

							}
						}
					} else {
						System.out.println("CNPJ Inv�lido");
					}
				}

			case 3:
				System.out.println("----------------- Excluir Cliente -----------------");
				System.out.println("Digite (1) - Pessoa F�sica ");
				System.out.println("Digite (2) - Pessoa Jur�dica ");
				int n1 = ler.nextInt();
				if (n1 == 1) {
					System.out.println("Digite o CPF");
					String cpf1 = ler.nextLine();
					PessoaFisica p1 = pessoaFisicaDao.pesquisar(cpf1);
					pessoaFisicaDao.remover(p1);
				} else {
					System.out.println("Digite o CNPJ");
					String cnpj1 = ler.nextLine();
					PessoaJuridica p1 = pessoaJuridicaDao.pesquisar(cnpj1);
					pessoaJuridicaDao.remover(p1);
				}
				System.out.println("Cliente Removido Com Sucesso!!");
				break;

			case 4:
				System.out.println("----------------- Pesquisar Cliente -----------------");
				System.out.println("Digite (1) - Pessoa F�sica ");
				System.out.println("Digite (2) - Pessoa Jur�dica ");
				int num5 = ler.nextInt();
				if (num5 == 1) {
					System.out.println("Digite o CPF: ");
					ler.nextLine();
					String cpfCLi = ler.nextLine();
					PessoaFisica pessoa = pessoaFisicaDao.pesquisar(cpfCLi);
					if (pessoa != null) {
						pessoa.imprimir();
					} else {
						System.out.println("CPF Inv�lido !");
					}
				} else {
					System.out.println("Digite o CNPJ: ");
					ler.nextLine();
					String cnpjCli = ler.nextLine();
					PessoaJuridica pessoa = pessoaJuridicaDao.pesquisar(cnpjCli);
					if (pessoa != null) {
						pessoa.imprimir();
					} else {
						System.out.println("CNPJ Inv�lido !");
					}
				}

				break;

			case 5:
				System.out.println("--------------Cadastrar Movimenta��o---------------");
				System.out.println("Digite (1) - Pessoa F�sica ");
				System.out.println("Digite (2) - Pessoa Jur�dica ");
				int num6 = ler.nextInt();
				if (num6 == 1) {
					System.out.println("Digite o CPF");
					ler.nextLine();
					String cpf1 = ler.nextLine();
					PessoaFisica p1 = pessoaFisicaDao.pesquisar(cpf1);
					if (p1 != null) {
						p1.imprimir();
						System.out.println("--------------------------------------------------------------");
						System.out.println("Digite o n�mero da conta que deseja realizar a movimenta��o:");
						int numConta = ler.nextInt();
						ContaCliente cdConta = contaCliDao.pesquisar(numConta);
						if (cdConta != null) {
							System.out.println("Digite: (1) - Movimenta��o de Despesa");
							System.out.println("Digite: (2) - Movimenta��o de Receita");
							int mov2 = ler.nextInt();
							if (mov2 == 1) {
								try {
									System.out.println("Digite o valor da movimenta��o");
									double movConta = ler.nextDouble();
									movi.setValorMov(movConta);
									movi.setDataMov(timeStamp);
									movi.setNumeroConta(numConta);
									movi.setTpMov("D");
									movimDao.salvar(movi);
								} finally {

								}
							} else {
								try {
								System.out.println("Digite o valor da movimenta��o");
								double movConta = ler.nextDouble();
								movi.setValorMov(movConta);
								movi.setDataMov(timeStamp);
								movi.setNumeroConta(numConta);
								movi.setTpMov("R");
								movimDao.salvar(movi);
								} finally {
									
								}
							}
							System.out.println("Movimenta��o Cadastrada com Sucesso!!!");
						} else {
							System.out.println("Conta inv�lida!!");
						}
					}
				} else {
					System.out.println("Digite o CNPJ");
					ler.nextLine();
					String cnpj1 = ler.nextLine();
					PessoaJuridica p1 = pessoaJuridicaDao.pesquisar(cnpj1);
					if (p1 != null) {
						p1.imprimir();
						System.out.println("--------------------------------------------------------------");
						System.out.println("Digite o n�mero da conta que deseja realizar a movimenta��o:");
						int numConta = ler.nextInt();
						ContaCliente cdConta = contaCliDao.pesquisar(numConta);
						if (cdConta != null) {
							System.out.println("Digite: (1) - Movimenta��o de Despesa");
							System.out.println("Digite: (2) - Movimenta��o de Receita");
							int mov2 = ler.nextInt();
							if (mov2 == 1) {
								try {
									System.out.println("Digite o valor da movimenta��o");
									double movConta = ler.nextDouble();
									movi.setValorMov(movConta);
									movi.setDataMov(timeStamp);
									movi.setNumeroConta(numConta);
									movi.setTpMov("D");
									movimDao.salvar(movi);
								} finally {

								}
							}
						}
					} else {
						System.out.println("CNPJ Inv�lido!!!");
					}
				}

				break;

			case 6:
				System.out.println("Relat�rio de saldo do cliente X");
				pessoaFisicaDao.resultquery();
				break;

			case 7:
				System.out.println("Relat�rio de Saldo do Cliente em X Per�odo");
				break;

			case 8:
				System.out.println("Relat�rio de Saldo de Todos os Clientes");
				break;

			case 9:
				System.out.println("Relat�rio de Receita da Empresa X por Per�odo");
				break;

			case 10:
				opcao = 10;
				System.out.println("Aplica��o Encerrada!!!");
			}
		}

		ler.close();

	}
}
