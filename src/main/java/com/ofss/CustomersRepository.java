package com.ofss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer>{
	// no need to write anything here
}