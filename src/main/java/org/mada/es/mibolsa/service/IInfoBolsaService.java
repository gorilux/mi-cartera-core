package org.mada.es.mibolsa.service;

import java.util.List;

import org.mada.es.mibolsa.dto.QuoteWeb;

public interface IInfoBolsaService {

	public List<QuoteWeb> extractQuoteWebInfoBolsa();

}
