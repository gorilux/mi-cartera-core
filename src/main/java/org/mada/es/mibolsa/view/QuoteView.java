package org.mada.es.mibolsa.view;

import java.io.Serializable;

public class QuoteView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String cash;

	private String changeP;

	private String date;

	private String hour;

	private String max;

	private String min;

	private String price;

	private String volume;

	private String idTicker;

	private String nameTicker;

	public QuoteView() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getChangeP() {
		return changeP;
	}

	public void setChangeP(String changeP) {
		this.changeP = changeP;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIdTicker() {
		return idTicker;
	}

	public void setIdTicker(String idTicker) {
		this.idTicker = idTicker;
	}

	public String getNameTicker() {
		return nameTicker;
	}

	public void setNameTicker(String nameTicker) {
		this.nameTicker = nameTicker;
	}

}