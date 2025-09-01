package com.ofss;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class StocksServices {
	@Autowired
	StocksRepository stockRepository;
	
	
	
	// adding new stocks
	public ResponseEntity<Object> addAStock(Stocks newStock) {
		// save() method generates INSERT INTO query
		Optional<Stocks> stock=stockRepository.findById(newStock.getStockId());
		
		 if (stock.isPresent()) {
			 System.out.println("already prsent");
			 return ResponseEntity.status(209)
                     .body("Stock with ID " + newStock.getStockId() + " already present ");
		    } else {
				return ResponseEntity.status(201).body(stockRepository.save(newStock));

		    }
	}
	
	
	// getting all stocks
	
	public ResponseEntity<Object> fetchAllStocks()
	{
		return ResponseEntity.status(201).body(stockRepository.findAll());
	}
	
	//getting Stock using id
	public ResponseEntity<Object> fetchStockById(int sid)
	{
		Optional<Stocks> stock=stockRepository.findById(sid);
		
		 if (stock.isPresent()) {
		        return ResponseEntity.ok(stock.get());
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                             .body("Stock with ID " + sid + " not found");
		    }
		
		
	}
	
	// deleting a stock
	
	public ResponseEntity<Object> deleteStockById(int sid)
	{
		Optional<Stocks> stock=stockRepository.findById(sid);
		if(stock.isPresent())
		{
			stockRepository.deleteById(sid);
	        return ResponseEntity.ok("Stock with stockId "+sid+" deleted");
		}
		 else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                             .body("Stock with ID " + sid + " not found");
		    }
	}
	
	//Updating Stock using Put Method
	public ResponseEntity<Object> stockUpdateByIdPut(int sid, Stocks newStock) {
	    if (stockRepository.existsById(sid)) {
	        Stocks existStock = stockRepository.findById(sid).get();

	            existStock.setStockName(newStock.getStockName());
	            existStock.setStockPrice(newStock.getStockPrice());
	            existStock.setStockVolume(newStock.getStockVolume());
	            existStock.setListingPrice(newStock.getListingPrice());
	            existStock.setListedDate(newStock.getListedDate());
	            existStock.setListedExchange(newStock.getListedExchange());
	        stockRepository.save(existStock);
	        return ResponseEntity.ok("Stock with stockID " + sid + " updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("Stock with ID " + sid + " not found");
	    }
	}
	
	//Updating Stock Using Patch Method
	public ResponseEntity<Object> stockUpdateByIdPatch(int sid, Stocks newStock) {
	    if (stockRepository.existsById(sid)) {
	        Stocks existStock = stockRepository.findById(sid).get();

	        if (newStock.getStockName() != null && !newStock.getStockName().isEmpty())
	            existStock.setStockName(newStock.getStockName());

	        if (newStock.getStockPrice() != 0)
	            existStock.setStockPrice(newStock.getStockPrice());

	        if (newStock.getStockVolume() != 0)
	            existStock.setStockVolume(newStock.getStockVolume());

	        if (newStock.getListingPrice() != 0)
	            existStock.setListingPrice(newStock.getListingPrice());

	        if (newStock.getListedDate() != null)
	            existStock.setListedDate(newStock.getListedDate());

	        if (newStock.getListedExchange() != null && !newStock.getListedExchange().isEmpty())
	            existStock.setListedExchange(newStock.getListedExchange());

	        stockRepository.save(existStock);
	        return ResponseEntity.ok("Stock with stockID " + sid + " updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("Stock with ID " + sid + " not found");
	    }
	}
	
	
	
	

	
}