package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the goal database table.
 * 
 */
@Entity
@NamedQuery(name="Goal.findAll", query="SELECT g FROM Goal g")
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal breakEven;

	private BigDecimal stopLossPerdida;

	private BigDecimal stopLossPorcent;

	private BigDecimal stopLossPrecioUni;

	private BigDecimal stopProfitBeneficio;

	private BigDecimal stopProfitPorcent;

	private BigDecimal stopProfitPrecioUni;

	//bi-directional many-to-one association to Detail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDetail")
	private Detail detail;

	public Goal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBreakEven() {
		return this.breakEven;
	}

	public void setBreakEven(BigDecimal breakEven) {
		this.breakEven = breakEven;
	}

	public BigDecimal getStopLossPerdida() {
		return this.stopLossPerdida;
	}

	public void setStopLossPerdida(BigDecimal stopLossPerdida) {
		this.stopLossPerdida = stopLossPerdida;
	}

	public BigDecimal getStopLossPorcent() {
		return this.stopLossPorcent;
	}

	public void setStopLossPorcent(BigDecimal stopLossPorcent) {
		this.stopLossPorcent = stopLossPorcent;
	}

	public BigDecimal getStopLossPrecioUni() {
		return this.stopLossPrecioUni;
	}

	public void setStopLossPrecioUni(BigDecimal stopLossPrecioUni) {
		this.stopLossPrecioUni = stopLossPrecioUni;
	}

	public BigDecimal getStopProfitBeneficio() {
		return this.stopProfitBeneficio;
	}

	public void setStopProfitBeneficio(BigDecimal stopProfitBeneficio) {
		this.stopProfitBeneficio = stopProfitBeneficio;
	}

	public BigDecimal getStopProfitPorcent() {
		return this.stopProfitPorcent;
	}

	public void setStopProfitPorcent(BigDecimal stopProfitPorcent) {
		this.stopProfitPorcent = stopProfitPorcent;
	}

	public BigDecimal getStopProfitPrecioUni() {
		return this.stopProfitPrecioUni;
	}

	public void setStopProfitPrecioUni(BigDecimal stopProfitPrecioUni) {
		this.stopProfitPrecioUni = stopProfitPrecioUni;
	}

	public Detail getDetail() {
		return this.detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

}