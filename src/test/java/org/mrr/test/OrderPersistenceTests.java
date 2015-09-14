package org.mrr.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mada.es.mibolsa.entity.Item;
import org.mada.es.mibolsa.entity.Order;
import org.mada.es.mibolsa.entity.Quote;
import org.mada.es.mibolsa.facade.IQuoteFacade;
import org.mada.es.mibolsa.repository.QuoteRepository;
import org.mrr.test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-config.xml" })
@Transactional
public class OrderPersistenceTests {

	// @PersistenceContext
	// private EntityManager entityManager;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private IQuoteFacade facade;

	@Autowired
	private QuoteRepository quoteRep;

	@Test
	public void testLoadQuote() {

		Quote quote = quoteRep.findLastQuoteByTicker("ZOT");

		// System.out.println(quote.getTicker().getName() + " - " +
		// quote.getPrice().toString());
		facade.loadQuoteProcess();
	}

	// @Test
	// @Transactional
	public void testOrderRepositoryFind() {
		Order order = new Order();
		order.setCustomer("Custemer");
		order.getItems().add(new Item());
		orderRepository.save(order);
		assertNotNull(order.getId());

		Order orderRecuperado = orderRepository.findById(order.getId());

		assertEquals(order.getId(), orderRecuperado.getId());

	}

	// @Test
	public void testOrderRepositoryUpdate() {
		Order order = new Order();
		order.setCustomer("Custemer");
		order.getItems().add(new Item());
		orderRepository.save(order);
		assertNotNull(order.getId());

		Order orderRecuperado = orderRepository.findById(order.getId());

		int i = orderRepository.updateCustomer("custemerUpdate", orderRecuperado.getId());

		assertEquals(order.getId(), orderRecuperado.getId());

	}

	// @Test
	// @Transactional
	// public void testSaveOrderWithItems() throws Exception {
	// Order order = new Order();
	// order.getItems().add(new Item());
	// entityManager.persist(order);
	// entityManager.flush();
	// assertNotNull(order.getId());
	// }
	//
	// @Test
	// @Transactional
	// public void testSaveAndGet() throws Exception {
	// Order order = new Order();
	// order.getItems().add(new Item());
	// entityManager.persist(order);
	// entityManager.flush();
	// // Otherwise the query returns the existing order (and we didn't set the
	// // parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager.find(Order.class, order.getId());
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }
	//
	// @Test
	// @Transactional
	// public void testSaveAndFind() throws Exception {
	// Order order = new Order();
	// Item item = new Item();
	// item.setProduct("foo");
	// order.getItems().add(item);
	// entityManager.persist(order);
	// entityManager.flush();
	// // Otherwise the query returns the existing order (and we didn't set the
	// // parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager
	// .createQuery(
	// "select o from Order o join o.items i where i.product=:product")
	// .setParameter("product", "foo").getSingleResult();
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }

}
