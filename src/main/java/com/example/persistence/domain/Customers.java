package com.example.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Customers {
    
	@NotNull
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id ;
	//@Size(min = 0, max = 55)
	//@NotNull
	private String cust_firstname;
	//@Size(min = 0, max = 55)
	private String cust_lastname;
	//@Size(min = 0, max = 55)
	private String cust_address;
	private String cust_city;
	private String cust_countrycode;
	private String cust_zipcode;
	private String cust_dob;
	private long cust_mobileno;
	private String cust_emailid;
    
    
    @OneToMany(mappedBy = "customers", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Orders> orders = new ArrayList<>();


	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public String getCust_firstname() {
		return cust_firstname;
	}


	public void setCust_firstname(String cust_firstname) {
		this.cust_firstname = cust_firstname;
	}


	public String getCust_lastname() {
		return cust_lastname;
	}


	public void setCust_lastname(String cust_lastname) {
		this.cust_lastname = cust_lastname;
	}


	public String getCust_address() {
		return cust_address;
	}


	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}


	public String getCust_city() {
		return cust_city;
	}


	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}


	public String getCust_countrycode() {
		return cust_countrycode;
	}


	public void setCust_countrycode(String cust_countrycode) {
		this.cust_countrycode = cust_countrycode;
	}


	public String getCust_zipcode() {
		return cust_zipcode;
	}


	public void setCust_zipcode(String cust_zipcode) {
		this.cust_zipcode = cust_zipcode;
	}


	public String getCust_dob() {
		return cust_dob;
	}


	public void setCust_dob(String cust_dob) {
		this.cust_dob = cust_dob;
	}


	public long getCust_mobileno() {
		return cust_mobileno;
	}


	public void setCust_mobileno(long cust_mobileno) {
		this.cust_mobileno = cust_mobileno;
	}


	public String getCust_emailid() {
		return cust_emailid;
	}


	public void setCust_emailid(String cust_emailid) {
		this.cust_emailid = cust_emailid;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> Orders) {
		Orders = orders;
	}


	public Customers(int cust_id, String cust_firstname,
			String cust_lastname, String cust_address,
			String cust_city, String cust_countrycode, String cust_zipcode, String cust_dob, long cust_mobileno,
			String cust_emailid, List<com.example.persistence.domain.Orders> orders) {
		super();
		this.cust_id = cust_id;
		this.cust_firstname = cust_firstname;
		this.cust_lastname = cust_lastname;
		this.cust_address = cust_address;
		this.cust_city = cust_city;
		this.cust_countrycode = cust_countrycode;
		this.cust_zipcode = cust_zipcode;
		this.cust_dob = cust_dob;
		this.cust_mobileno = cust_mobileno;
		this.cust_emailid = cust_emailid;
		List<Orders> Orders = orders;
	}


	public Customers() {
		super();
	}


	@Override
	public String toString() {
		return "Customers [cust_id=" + cust_id + ", cust_firstname=" + cust_firstname + ", cust_lastname="
				+ cust_lastname + ", cust_address=" + cust_address + ", cust_city=" + cust_city + ", cust_countrycode="
				+ cust_countrycode + ", cust_zipcode=" + cust_zipcode + ", cust_dob=" + cust_dob + ", cust_mobileno="
				+ cust_mobileno + ", cust_emailid=" + cust_emailid + ", orders=" + orders + "]";
	}


	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setName(Object name) {
		// TODO Auto-generated method stub
		
	}

}	