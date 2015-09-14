package org.mada.es.mibolsa.facade.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.mada.es.mibolsa.dto.QuoteWeb;
import org.mada.es.mibolsa.entity.Quote;
import org.mada.es.mibolsa.entity.Ticker;
import org.mada.es.mibolsa.facade.IQuoteFacade;
import org.mada.es.mibolsa.repository.QuoteRepository;
import org.mada.es.mibolsa.repository.TickerRepository;
import org.mada.es.mibolsa.service.IInfoBolsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuoteFacade implements IQuoteFacade {

	@Autowired
	private QuoteRepository repository;

	@Autowired
	private TickerRepository tickerRepo;

	@Autowired
	private IInfoBolsaService infoBolsaService;

	@Override
	@Transactional(readOnly = false)
	public void loadQuoteProcess() {

		/*
		 * lectura de cotizaciones de la web de infobolsa
		 */
		List<QuoteWeb> quoteWebList = infoBolsaService.extractQuoteWebInfoBolsa();

		/*
		 * carga de cotizaciones en tablas de bbdd. Quotes / Ticker
		 */
		loadQuote(quoteWebList);

	}

	private void loadQuote(List<QuoteWeb> quoteWebList) {
		for (QuoteWeb coti : quoteWebList) {

			Quote quote = new Quote();

			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator('.');
			symbols.setDecimalSeparator(',');
			DecimalFormat df = new DecimalFormat("#,##0.0#", symbols);
			df.setParseBigDecimal(true);

			try {
				quote.setCash((BigDecimal) df.parse(coti.getCash()));
				quote.setChangeP((BigDecimal) df.parse(coti.getChangeP()));
				quote.setVolume((BigDecimal) df.parse(coti.getVolume()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

			try {
				quote.setDate(date.parse(coti.getDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm");
			try {
				quote.setHour(hourFormat.parse(coti.getHour()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			quote.setMax(new BigDecimal(coti.getMax().replaceAll(",", ".")));
			quote.setMin(new BigDecimal(coti.getMin().replaceAll(",", ".")));
			quote.setPrice(new BigDecimal(coti.getPrice().replaceAll(",", ".")));

			Ticker ticker = tickerRepo.findByTicker(coti.getTicker());

			if (ticker == null) {
				ticker = new Ticker();
				ticker.setTicker(coti.getTicker());
				ticker.setName(coti.getName());
				tickerRepo.save(ticker);
			}

			quote.setTicker(ticker);

			List<Quote> quoteList = repository.findByTickerAndDateAndHour(ticker, quote.getDate(), quote.getHour());

			if (quoteList.isEmpty()) {

				System.out.println(ReflectionToStringBuilder.toString(quote, ToStringStyle.MULTI_LINE_STYLE));
				quote.setDtCreate(new Date());

				repository.save(quote);
			}
		}
	}

}
