package com.ofss;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {

    @Id
    @Column(name = "TXN_ID")
    private Integer txnId;

    @ManyToOne
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "STOCK_ID", referencedColumnName = "STOCK_ID")
    private Stocks stock;

    @Column(name = "TXN_PRICE")
    private Double txnPrice;

    @Column(name = "TXN_TYPE")
    private String txnType;

    @Column(name = "QTY")
    private Long qty;

    @Column(name = "TXN_DATE")
    @Temporal(TemporalType.DATE)
    private Date txnDate;

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(Integer txnId, Customers customer, Stocks stock, Double txnPrice, String txnType, Long qty,
			Date txnDate) {
		super();
		this.txnId = txnId;
		this.customer = customer;
		this.stock = stock;
		this.txnPrice = txnPrice;
		this.txnType = txnType;
		this.qty = qty;
		this.txnDate = txnDate;
	}

	public Integer getTxnId() {
		return txnId;
	}

	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Stocks getStock() {
		return stock;
	}

	public void setStock(Stocks stock) {
		this.stock = stock;
	}

	public Double getTxnPrice() {
		return txnPrice;
	}

	public void setTxnPrice(Double txnPrice) {
		this.txnPrice = txnPrice;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

    // Getters and Setters
    
    
}

