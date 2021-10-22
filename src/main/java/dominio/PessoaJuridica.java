package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CLIENTE_PJ")
	@GeneratedValue(generator = "ID_CLIENTE_PJ")
	@SequenceGenerator(name = "ID_CLIENTE_PJ", 
					   sequenceName = "ID_CLIENTE_PJ", 
					   allocationSize = 1)
	private Long id;

	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

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

	@Override
	public String toString() {
		return "PessoaJuridica [id=" + id + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", inscricaoEstadual="
				+ inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal + ", validadeInscricaoEst="
				+ validadeInscricaoEst + ", foneFax=" + foneFax + "]";
	}

}
