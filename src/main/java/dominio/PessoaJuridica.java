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
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ID_CLIENTE_PJ")
	@GeneratedValue(generator = "ID_CLIENTE_PJ")
	@SequenceGenerator(name = "ID_CLIENTE_PJ", sequenceName = "ID_CLIENTE_PJ", allocationSize = 0)
	private Long id;

	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

	@Id
	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;

	@Column(name = "INSCRICAO_MUNICIPAL")
	private String inscricaoMunicipal;

	@Column(name = "VALIDADE_INSCRICAO_ESTADUAL")
	private String validadeInscricaoEst;

	@Column(name = "FAX")
	private String foneFax;

	@Column(name = "DATA_CADASTRO")
	private String dataCadastroPf;

	@OneToOne
	private Endereco endereco;

	@ManyToOne
	private ContaCliente contaCli;

	public Endereco getEndereco() {
		return endereco;
	}

	public String getDataCadastroPf() {
		return dataCadastroPf;
	}

	public void setDataCadastroPf(String dataCadastroPf) {
		this.dataCadastroPf = dataCadastroPf;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ContaCliente getContaCli() {
		return contaCli;
	}

	public void setContaCli(ContaCliente contaCli) {
		this.contaCli = contaCli;
	}

	public PessoaJuridica(Long id, String nomeFantasia, String cnpj, String inscricaoEstadual,
			String inscricaoMunicipal, String validadeInscricaoEst, String foneFax) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.validadeInscricaoEst = validadeInscricaoEst;
		this.foneFax = foneFax;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PessoaJuridica() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getValidadeInscricaoEst() {
		return validadeInscricaoEst;
	}

	public void setValidadeInscricaoEst(String validadeInscricaoEst) {
		this.validadeInscricaoEst = validadeInscricaoEst;
	}

	public String getFoneFax() {
		return foneFax;
	}

	public void setFoneFax(String foneFax) {
		this.foneFax = foneFax;
	}

	public void imprimir() {
		System.out.println("---------------------Cliente-----------------------");
		System.out.println("Nome: " + this.nomeFantasia + " CNPJ: " + this.cnpj);
		System.out.println(
				"Inscric. Estadual: " + this.inscricaoEstadual + " Inscric. Municipal " + this.inscricaoMunicipal);
		System.out.println("Validade Insc. Estadual " + this.validadeInscricaoEst + " Fone: " + this.foneFax);
		System.out.println("---------------------Endereço-----------------------");
		System.out.println("Rua: " + this.endereco.getRua() + " Numero: " + this.endereco.getNumero());
		System.out.println("Complemento: " + this.endereco.getComplemento() + " Bairro: " + this.endereco.getBairro());
		System.out.println("Cidade: " + this.endereco.getCidade() + " UF: " + this.endereco.getUf());
		System.out.println("CEP: " + this.endereco.getCep());
		System.out.println("----------------------Contas------------------------");
		System.out.println("Numero: " + this.contaCli.getNumero() + " Saldo: " + this.contaCli.getSaldoAtual());
		System.out.println("Ultima Atualização: " + this.contaCli.getDataAtualizacao());

	}
}
