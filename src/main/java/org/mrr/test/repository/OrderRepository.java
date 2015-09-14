package org.mrr.test.repository;

import org.mada.es.mibolsa.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends CrudRepository<Order,Long> {

	Order findById(Long id);
	@Transactional(readOnly=false)
	@Modifying
	@Query("UPDATE Order set customer = (?1) where id = (?2)")
	int updateCustomer(String newCustomer, Long id);     
}
