package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal resultadoEuros;

	private BigDecimal resultadoPercent;

	//bi-directional many-to-one association to Movement
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMovement")
	private Movement movement;

	public Result() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getResultadoEuros() {
		return this.resultadoEuros;
	}

	public void setResultadoEuros(BigDecimal resultadoEuros) {
		this.resultadoEuros = resultadoEuros;
	}

	public BigDecimal getResultadoPercent() {
		return this.resultadoPercent;
	}

	public void setResultadoPercent(BigDecimal resultadoPercent) {
		this.resultadoPercent = resultadoPercent;
	}

	public Movement getMovement() {
		return this.movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

}