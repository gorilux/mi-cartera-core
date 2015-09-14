package org.mada.es.mibolsa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ticker database table.
 * 
 */
@Entity
@NamedQuery(name="Ticker.findAll", query="SELECT t FROM Ticker t")
public class Ticker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	private String ticker;

	public Ticker() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}