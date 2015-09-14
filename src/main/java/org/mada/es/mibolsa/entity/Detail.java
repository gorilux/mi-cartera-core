package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the detail database table.
 * 
 */
@Entity
@NamedQuery(name="Detail.findAll", query="SELECT d FROM Detail d")
public class Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cantidad;

	private BigDecimal precioMedioCompra;

	private BigDecimal valorCompra;

	private BigDecimal valorCompraGastos;

	//bi-directional many-to-one association to Portfolio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPortfolio")
	private Portfolio portfolio;

	//uni-directional many-to-one association to Ticker
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTicker")
	private Ticker ticker;

	//bi-directional many-to-one association to Goal
	@OneToMany(mappedBy="detail")
	private List<Goal> goals;

	public Detail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioMedioCompra() {
		return this.precioMedioCompra;
	}

	public void setPrecioMedioCompra(BigDecimal precioMedioCompra) {
		this.precioMedioCompra = precioMedioCompra;
	}

	public BigDecimal getValorCompra() {
		return this.valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public BigDecimal getValorCompraGastos() {
		return this.valorCompraGastos;
	}

	public void setValorCompraGastos(BigDecimal valorCompraGastos) {
		this.valorCompraGastos = valorCompraGastos;
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

	public List<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public Goal addGoal(Goal goal) {
		getGoals().add(goal);
		goal.setDetail(this);

		return goal;
	}

	public Goal removeGoal(Goal goal) {
		getGoals().remove(goal);
		goal.setDetail(null);

		return goal;
	}

}