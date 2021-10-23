package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA_CLIENTE")
public class ContaCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "SALDO_ATUAL")
	private double saldoAtual;

	@Column(name = "DATA_ATUALIZACAO")
	private String dataAtualizacao;

	@Id
	@Column(name = "CD_CONTA")
	private Integer numero;

	@Column(name = "SALDO_INICIAL")
	private double saldoInicial;

	@OneToOne
	private MovClientes moviment;

	public ContaCliente(Long id, double saldoAtual, String dataAtualizacao, Integer numero) {
		super();
		this.saldoAtual = saldoAtual;
		this.dataAtualizacao = dataAtualizacao;
		this.numero = numero;
	}

	public ContaCliente() {

	}

	public MovClientes getMoviment() {
		return moviment;
	}

	public void setMoviment(MovClientes moviment) {
		this.moviment = moviment;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
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

}
