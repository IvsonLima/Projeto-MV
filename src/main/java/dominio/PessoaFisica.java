package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ID_CLIENTE_PF")
	@GeneratedValue(generator = "ID_CLIENTE_PF")
	@SequenceGenerator(name = "ID_CLIENTE_PF", sequenceName = "ID_CLIENTE_PF", allocationSize = 0)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "RG")
	private String rg;

	@Id
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "ORGAO_EMISSOR_RG")
	private String orgEmissor;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DATA_NASCIMENTO")
	private String dataNascimento;
	
	@Column(name = "DATA_CADASTRO")
	private String dataCadastro;
	
	@OneToOne
	private Endereco endereco;

	@ManyToOne
	private ContaCliente contaCli;

	public PessoaFisica() {

	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public ContaCliente getContaCli() {
		return contaCli;
	}

	public void setContaCli(ContaCliente contaCli) {
		this.contaCli = contaCli;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PessoaFisica(Long id, String nome, String rg, String cpf, String orgEmissor, String telefone, String email,
			String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.orgEmissor = orgEmissor;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public void imprimir() {
		System.out.println("---------------------Cliente-----------------------");
		System.out.println("Nome: " + this.nome + " CPF: " + this.cpf);
		System.out.println("RG: " + this.rg + " Orgão Emissor: " + this.orgEmissor);
		System.out.println("Telefone: " + this.telefone + " Email: " + this.email);
		System.out.println("Data Nascimento: " + this.dataNascimento);
		System.out.println("---------------------Endereço-----------------------");
		System.out.println("Rua: " + this.endereco.getRua() + " Numero: " + this.endereco.getNumero());
		System.out.println("Complemento: " + this.endereco.getComplemento() + " Bairro: " +this.endereco.getBairro());
		System.out.println("Cidade: " + this.endereco.getCidade() + " UF: " +this.endereco.getUf());
		System.out.println("CEP: " + this.endereco.getCep());
		System.out.println("----------------------Contas------------------------");
		System.out.println("Numero: " + this.contaCli.getNumero() + " Saldo: " + this.contaCli.getSaldoAtual());
		System.out.println("Ultima Atualização: " + this.contaCli.getDataAtualizacao());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOrgEmissor() {
		return orgEmissor;
	}

	public void setOrgEmissor(String orgEmissor) {
		this.orgEmissor = orgEmissor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	


}
