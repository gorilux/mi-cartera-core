package org.mada.es.mibolsa.repository;

import org.mada.es.mibolsa.entity.Ticker;
import org.springframework.data.repository.CrudRepository;

public interface TickerRepository extends CrudRepository<Ticker, Integer> {

	Ticker findByTicker(String ticker);
	
}
