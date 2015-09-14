package org.mada.es.mibolsa.repository;

import java.util.Date;
import java.util.List;

import org.mada.es.mibolsa.entity.Quote;
import org.mada.es.mibolsa.entity.Ticker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {

	List<Quote> findByTickerAndDateAndHour(Ticker ticker, Date date, Date hour);

	/**
	 * Devuelve la cotización mas actual de las cargadas en Quote
	 * 
	 * @param ticker
	 *            código del ticker
	 * @return último quote del ticker
	 */
	@Query("select q from Quote q where q.ticker.ticker = :ticker and q.date = (select max(q2.date) from Quote q2)")
	public Quote findLastQuoteByTicker(@Param("ticker") String idTicker);

}
