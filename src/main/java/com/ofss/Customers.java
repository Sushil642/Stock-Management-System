package com.ofss;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @Column(name = "CUST_ID")
    private Integer custId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Customers(Integer custId, String firstName, String lastName, Long phoneNumber, String city, String emailId) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.emailId = emailId;
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    @Column(name = "CITY")
    private String city;

    @Column(name = "EMAIL_ID")
    private String emailId;

    // Getters and Setters
}
