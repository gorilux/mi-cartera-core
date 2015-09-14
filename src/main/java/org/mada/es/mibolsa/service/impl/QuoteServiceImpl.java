package org.mada.es.mibolsa.service.impl;

import org.mada.es.mibolsa.entity.Quote;
import org.mada.es.mibolsa.repository.QuoteRepository;
import org.mada.es.mibolsa.service.IQuoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuoteServiceImpl implements IQuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	@Override
	public Quote getLasQuoteByTicker(String ticker) {
		Quote quote = quoteRepository.findLastQuoteByTicker(ticker);
		return quote;
	}

}
