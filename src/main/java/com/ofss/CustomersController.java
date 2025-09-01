package com.ofss;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class CustomersController {
    @Autowired
    private CustomersServices customerService;
    @Autowired
    private CustomersRepository customerRepository;
    // POST – Add a new customer
    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public ResponseEntity<Object> addCustomer(@RequestBody Customers newCustomer) {
        return customerService.addCustomer(newCustomer);
    }
    // GET – Fetch all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> fetchAll() {
        List<Customers> allCustomers = (List<Customers>) customerRepository.findAll();
        return ResponseEntity.ok(allCustomers);
    }
    // GET – Fetch a single customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
    // DELETE – Remove a customer by ID
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }
    
    @RequestMapping(value="/customers/{custId}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateCustomerByIdPut(@PathVariable("custId") int cid,@RequestBody Customers newCustomer) {
		return customerService.updateCustomer(cid,newCustomer);
	}
 
    @RequestMapping(value="/customers/{custId}", method=RequestMethod.PATCH)
   	public ResponseEntity<String> updateCustomerByIdPatch(@PathVariable("custId") int cid,@RequestBody Customers newCustomer) {
   		return customerService.patchCustomer(cid,newCustomer);
   	}
    
    
}

