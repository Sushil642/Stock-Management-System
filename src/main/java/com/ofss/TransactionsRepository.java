package com.ofss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionsRepository extends CrudRepository<Transactions, Integer>{
	// no need to write anything here
}