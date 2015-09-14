package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movement database table.
 * 
 */
@Entity
@NamedQuery(name="Movement.findAll", query="SELECT m FROM Movement m")
public class Movement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private BigDecimal gastos;

	private BigDecimal precio;

	private String tipo;

	//bi-directional many-to-one association to Portfolio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPortfolio")
	private Portfolio portfolio;

	//uni-directional many-to-one association to Ticker
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTicker")
	private Ticker ticker;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="movement")
	private List<Result> results;

	public Movement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getGastos() {
		return this.gastos;
	}

	public void setGastos(BigDecimal gastos) {
		this.gastos = gastos;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Portfolio getPortfolio() {
		return this.portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Ticker getTicker() {
		return this.ticker;
	}

	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setMovement(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setMovement(null);

		return result;
	}

}