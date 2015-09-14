package org.mada.es.mibolsa.service;

import org.mada.es.mibolsa.entity.Quote;

public interface IQuoteService {

	/**
	 * Devuelve la �ltima cotizaci�n del ticker
	 * 
	 * @param ticker
	 *            c�digo del ticker
	 * @return Quote actual (�ltimo) del ticker
	 */
	Quote getLasQuoteByTicker(String ticker);

}
