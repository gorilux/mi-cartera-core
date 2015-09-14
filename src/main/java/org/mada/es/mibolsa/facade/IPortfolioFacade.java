package org.mada.es.mibolsa.facade;

import java.util.List;

import org.mada.es.mibolsa.entity.Detail;
import org.mada.es.mibolsa.entity.Portfolio;

/**
 * Interfaz de la fachada de cartera
 * 
 * @author Pumuki
 *
 */
public interface IPortfolioFacade {

	/**
	 * devuelve todas las carteras existentes
	 * 
	 * @return lista de carteras
	 */
	List<Portfolio> findAllPortfolio();

	/**
	 * Recuperar todas las carteras de un usuario
	 * 
	 * @param idUser
	 *            id del usuario
	 * @return lista de carteras
	 */
	List<Portfolio> findAllPortfolioByUser(int idUser);

	/**
	 * Devuelve el detalle de una cartera de valores
	 * 
	 * @param idPortfolio
	 *            id de la cartera
	 * @return lista de detalle
	 */
	List<Detail> findDetailPortfolio(int idPortfolio);

}
