package org.mada.es.mibolsa.facade;

public interface IQuoteFacade {

	/**
	 * Se conecta a la página de infobolsa y extrae los datos de contización de
	 * las acciones actuales.
	 */
	public void loadQuoteProcess();

}
