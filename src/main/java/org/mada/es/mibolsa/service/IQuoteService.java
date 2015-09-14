package org.mada.es.mibolsa.service;

import org.mada.es.mibolsa.entity.Quote;

public interface IQuoteService {

	/**
	 * Devuelve la última cotización del ticker
	 * 
	 * @param ticker
	 *            código del ticker
	 * @return Quote actual (último) del ticker
	 */
	Quote getLasQuoteByTicker(String ticker);

}
