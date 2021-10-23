package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MOV_CLIENTES")
public class MovClientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_MOVIMENTACAO")
	@GeneratedValue(generator = "ID_MOVIMENTACAO")
	@SequenceGenerator(name = "ID_MOVIMENTACAO", 
					   sequenceName = "ID_MOVIMENTACAO", 
					   allocationSize = 0)
	private Long id;

	@Column(name = "DATA_MOVIMENTACAO")
	private String dataMov;

	@Column(name = "TP_MOV")
	private String tpMov;

	@Column(name = "VALOR_MOV")
	private double valorMov;

	@Column(name = "NUMERO_CONTA")
	private Integer numeroConta;

	public MovClientes() {

	}
	

	public MovClientes(Long id, String dataMov, String tpMov, double valorMov, Integer numeroConta) {
		super();
		this.id = id;
		this.dataMov = dataMov;
		this.tpMov = tpMov;
		this.valorMov = valorMov;
		this.numeroConta = numeroConta;
	}

	
	
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getValorMov() {
		return valorMov;
	}

	public void setValorMov(double valorMov) {
		this.valorMov = valorMov;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataMov() {
		return dataMov;
	}

	public void setDataMov(String dataMov) {
		this.dataMov = dataMov;
	}

	public String getTpMov() {
		return tpMov;
	}

	public void setTpMov(String tpMov) {
		this.tpMov = tpMov;
	}

}
