package com.ofss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StocksController {
	@Autowired
	StocksServices ss;
	
	// for adding a new stock
	@RequestMapping(value="/stocks", method=RequestMethod.POST)
	public ResponseEntity<Object> addAStock(@RequestBody Stocks newStock) {
		return ss.addAStock(newStock);
	}
	
	@GetMapping("/stocks")
	public ResponseEntity<Object> getAllStocks() {
		System.out.println("Fetching all stocks...");
		return ss.fetchAllStocks(); // call the service method from here
 }
	
	 @RequestMapping(value="/stocks/{stockId}", method=RequestMethod.GET)
		public ResponseEntity<Object> getAStockById(@PathVariable("stockId") int sid) {
			return ss.fetchStockById(sid);
		}
	 @RequestMapping(value="/stocks/{stockId}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteAStockById(@PathVariable("stockId") int sid) {
			return ss.deleteStockById(sid);
		}
	 @RequestMapping(value="/stocks/{stockId}", method=RequestMethod.PATCH)
		public ResponseEntity<Object> updateStockByIdPatch(@PathVariable("stockId") int sid,@RequestBody Stocks newStock) {
			return ss.stockUpdateByIdPatch(sid,newStock);
		}
	 
	 @RequestMapping(value="/stocks/{stockId}", method=RequestMethod.PUT)
		public ResponseEntity<Object> updateStockByIdPut(@PathVariable("stockId") int sid,@RequestBody Stocks newStock) {
			return ss.stockUpdateByIdPut(sid,newStock);
		}
	
	
}