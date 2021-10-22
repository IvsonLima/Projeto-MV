package dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CLIENTE_PF")
	@GeneratedValue(generator = "ID_CLIENTE_PF")
	@SequenceGenerator(name = "ID_CLIENTE_PF", 
					   sequenceName = "ID_CLIENTE_PF", 
					   allocationSize = 1)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "RG")
	private String rg;
	
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
	
	@JoinColumn(name = "ID_CLIENTE_PF", referencedColumnName = "ID_ENDERECO")
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JoinColumn(name = "ID_CLIENTE_PF", referencedColumnName = "ID_CLIENTE")
	@OneToOne(cascade = CascadeType.ALL)
	private ContaCliente contaCliente;

	public PessoaFisica() {

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
		System.out.println("-----------------Pessoa-----------------------");
		System.out.println("Nome: " + this.nome + " CPF: " + this.cpf);
		System.out.println("RG: " + this.rg + " Orgão Emissor: " + this.orgEmissor);
		System.out.println("Telefone: " + this.telefone + " Email: " + this.email);
		System.out.println("Data Nascimento: " + this.dataNascimento);
		System.out.println("----------------------------------------------");
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
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ContaCliente getContaCliente() {
		return contaCliente;
	}

	public void setContaCliente(ContaCliente contaCliente) {
		this.contaCliente = contaCliente;
	}

}
