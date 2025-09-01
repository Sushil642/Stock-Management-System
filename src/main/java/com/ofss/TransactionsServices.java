package com.ofss;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class TransactionsServices {
    @Autowired
    private TransactionsRepository transactionRepository;
    // POST
    public ResponseEntity<Object> addTransaction(Transactions newTransaction) {
        return ResponseEntity.status(201).body(transactionRepository.save(newTransaction));
    }
    // GET all
    public Iterable<Transactions> fetchAllTransactions() {
        return transactionRepository.findAll();
    }
    // GET by ID
    public ResponseEntity<Transactions> getTransactionById(int id) {
        Optional<Transactions> txn = transactionRepository.findById(id);
        return txn.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    // DELETE by ID
    public ResponseEntity<String> deleteTransactionById(int id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok("Transaction deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
    
    // update tranaction using put method
    public ResponseEntity<Transactions> updateTransaction( int id,  Transactions updatedTxn) {
        Optional<Transactions> existingTxnOpt = transactionRepository.findById(id);

        if (existingTxnOpt.isPresent()) {
            Transactions existingTxn = existingTxnOpt.get();

            // Replace all fields
            existingTxn.setCustomer(updatedTxn.getCustomer());
            existingTxn.setStock(updatedTxn.getStock());
            existingTxn.setTxnPrice(updatedTxn.getTxnPrice());
            existingTxn.setTxnType(updatedTxn.getTxnType());
            existingTxn.setQty(updatedTxn.getQty());
            existingTxn.setTxnDate(updatedTxn.getTxnDate());

            Transactions savedTxn = transactionRepository.save(existingTxn);
            return ResponseEntity.ok(savedTxn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //update using patch method
    public ResponseEntity<Transactions> patchTransaction( Integer id,  Transactions patchTxn) {
        Optional<Transactions> existingTxnOpt = transactionRepository.findById(id);

        if (existingTxnOpt.isPresent()) {
            Transactions existingTxn = existingTxnOpt.get();

            // Update only non-null fields
            if (patchTxn.getCustomer() != null) existingTxn.setCustomer(patchTxn.getCustomer());
            if (patchTxn.getStock() != null) existingTxn.setStock(patchTxn.getStock());
            if (patchTxn.getTxnPrice() != null) existingTxn.setTxnPrice(patchTxn.getTxnPrice());
            if (patchTxn.getTxnType() != null) existingTxn.setTxnType(patchTxn.getTxnType());
            if (patchTxn.getQty() != null) existingTxn.setQty(patchTxn.getQty());
            if (patchTxn.getTxnDate() != null) existingTxn.setTxnDate(patchTxn.getTxnDate());

            Transactions savedTxn = transactionRepository.save(existingTxn);
            return ResponseEntity.ok(savedTxn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
