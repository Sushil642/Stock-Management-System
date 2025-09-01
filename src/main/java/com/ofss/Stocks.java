package com.ofss;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STOCKS")
public class Stocks {

    @Id
    @Column(name = "STOCK_ID")
    private Integer stockId;

    @Column(name = "STOCK_NAME")
    private String stockName;

    @Column(name = "STOCK_PRICE")
    private Double stockPrice;

    public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Long getStockVolume() {
		return stockVolume;
	}

	public void setStockVolume(Long stockVolume) {
		this.stockVolume = stockVolume;
	}

	public Double getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(Double listingPrice) {
		this.listingPrice = listingPrice;
	}

	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	public String getListedExchange() {
		return listedExchange;
	}

	public void setListedExchange(String listedExchange) {
		this.listedExchange = listedExchange;
	}

	public Stocks(Integer stockId, String stockName, Double stockPrice, Long stockVolume, Double listingPrice,
			Date listedDate, String listedExchange) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockVolume = stockVolume;
		this.listingPrice = listingPrice;
		this.listedDate = listedDate;
		this.listedExchange = listedExchange;
	}

	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "STOCK_VOLUME")
    private Long stockVolume;

    @Column(name = "LISTING_PRICE")
    private Double listingPrice;

    @Column(name = "LISTED_DATE")
    @Temporal(TemporalType.DATE)
    private Date listedDate;

    @Column(name = "LISTED_EXCHANGE")
    private String listedExchange;

    // Getters and Setters
}
