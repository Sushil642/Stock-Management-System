package com.ofss;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class CustomersServices {
    @Autowired
    private CustomersRepository customerRepository;
    // POST
    public ResponseEntity<Object> addCustomer(Customers newCustomer) {
        return ResponseEntity.status(201).body(customerRepository.save(newCustomer));
    }
    // GET all
    public Iterable<Customers> fetchAllCustomers() {
        return customerRepository.findAll();
    }
    // GET by ID
    public ResponseEntity<Customers> getCustomerById(int id) {
        Optional<Customers> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
    // DELETE by ID
    public ResponseEntity<String> deleteCustomerById(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
    // update customer using put method
    public ResponseEntity<String> updateCustomer(Integer custId, Customers updatedCustomer) {
        Optional<Customers> existingCustomerOpt = customerRepository.findById(custId);
        if (existingCustomerOpt.isPresent()) {
            updatedCustomer.setCustId(custId); // Ensure ID remains unchanged
            customerRepository.save(updatedCustomer);
            return ResponseEntity.ok("Customer updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // update customer data using patch method
    public ResponseEntity<String> patchCustomer(Integer custId, Customers partialUpdate) {
        Optional<Customers> existingCustomerOpt = customerRepository.findById(custId);
        if (existingCustomerOpt.isPresent()) {
            Customers existingCustomer = existingCustomerOpt.get();

            if (partialUpdate.getFirstName() != null)
                existingCustomer.setFirstName(partialUpdate.getFirstName());
            if (partialUpdate.getLastName() != null)
                existingCustomer.setLastName(partialUpdate.getLastName());
            if (partialUpdate.getPhoneNumber() != null)
                existingCustomer.setPhoneNumber(partialUpdate.getPhoneNumber());
            if (partialUpdate.getCity() != null)
                existingCustomer.setCity(partialUpdate.getCity());
            if (partialUpdate.getEmailId() != null)
                existingCustomer.setEmailId(partialUpdate.getEmailId());

            customerRepository.save(existingCustomer);
            return ResponseEntity.ok("Customer patched successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}