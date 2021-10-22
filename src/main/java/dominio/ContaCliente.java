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
@Table(name = "CONTA_CLIENTE")
public class ContaCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CONTA_CLIENTE")
	@GeneratedValue(generator = "ID_CONTA_CLIENTE")
	@SequenceGenerator(name = "ID_CONTA_CLIENTE", 
					   sequenceName = "ID_CONTA_CLIENTE", 
					   allocationSize = 1)
	private Long id;

	@Column(name = "SALDO_ATUAL")
	private double saldoAtual;

	@Column(name = "DATA_ATUALIZACAO")
	private String dataAtualizacao;

	@Column(name = "NUMERO")
	private Integer numero;
	
	@JoinColumn(name = "ID_CONTA_CLIENTE", referencedColumnName = "ID_CONTA_CLIENTE")
	@OneToOne(cascade = CascadeType.ALL)
	private MovClientes movime;

	public ContaCliente(Long id, double saldoAtual, String dataAtualizacao, Integer numero) {
		super();
		this.id = id;
		this.saldoAtual = saldoAtual;
		this.dataAtualizacao = dataAtualizacao;
		this.numero = numero;
	}

	public ContaCliente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

	public MovClientes getMovime() {
		return movime;
	}

	public void setMovime(MovClientes movime) {
		this.movime = movime;
	}

	@Override
	public String toString() {
		return "ContaCliente [id=" + id + ", saldoAtual=" + saldoAtual + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
