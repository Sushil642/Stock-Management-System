package com.ofss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StocksRepository extends CrudRepository<Stocks, Integer>{
	// no need to write anything here
}