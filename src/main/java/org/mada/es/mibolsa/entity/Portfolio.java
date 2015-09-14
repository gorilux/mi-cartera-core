package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the portfolio database table.
 * 
 */
@Entity
@NamedQuery(name="Portfolio.findAll", query="SELECT p FROM Portfolio p")
public class Portfolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private BigDecimal resultadoTotalEuros;

	private BigDecimal resultadoTotalPercent;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="portfolio")
	private List<Detail> details;

	//bi-directional many-to-one association to Movement
	@OneToMany(mappedBy="portfolio")
	private List<Movement> movements;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	public Portfolio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getResultadoTotalEuros() {
		return this.resultadoTotalEuros;
	}

	public void setResultadoTotalEuros(BigDecimal resultadoTotalEuros) {
		this.resultadoTotalEuros = resultadoTotalEuros;
	}

	public BigDecimal getResultadoTotalPercent() {
		return this.resultadoTotalPercent;
	}

	public void setResultadoTotalPercent(BigDecimal resultadoTotalPercent) {
		this.resultadoTotalPercent = resultadoTotalPercent;
	}

	public List<Detail> getDetails() {
		return this.details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public Detail addDetail(Detail detail) {
		getDetails().add(detail);
		detail.setPortfolio(this);

		return detail;
	}

	public Detail removeDetail(Detail detail) {
		getDetails().remove(detail);
		detail.setPortfolio(null);

		return detail;
	}

	public List<Movement> getMovements() {
		return this.movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Movement addMovement(Movement movement) {
		getMovements().add(movement);
		movement.setPortfolio(this);

		return movement;
	}

	public Movement removeMovement(Movement movement) {
		getMovements().remove(movement);
		movement.setPortfolio(null);

		return movement;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}