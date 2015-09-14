package org.mada.es.mibolsa.dto;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * DTO que representa los datos extraidos de la web infobolsa con la cotización
 * diaria
 * 
 * @author Pumuki
 *
 */
public class QuoteWeb {

	private String name;
	private String ticker;
	private String price;
	private String changeP;
	private String volume;
	private String cash;
	private String max;
	private String min;
	private String hour;
	private String date;

	public enum FieldCotizacion {
		name, ticker, price, changeP, volume, cash, max, min, hour, date, NO_VALUE;

		public static FieldCotizacion getEnum(String name) {
			for (FieldCotizacion campo : FieldCotizacion.values()) {
				if (campo.name().equals(name)) {
					return campo;
				}
			}
			return NO_VALUE;
		};
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChangeP() {
		return changeP;
	}

	public void setChangeP(String changeP) {
		this.changeP = changeP;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void set(String campo, String value) throws Exception {
		Class<? extends QuoteWeb> clas = this.getClass();

		Field f1 = clas.getField(campo);
		f1.set(this, value);

	}

	public void set(String campo, BigDecimal value) {

		Class<? extends QuoteWeb> clas = this.getClass();

		try {
			Field f1 = clas.getField(campo);
			f1.set(this, value);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
