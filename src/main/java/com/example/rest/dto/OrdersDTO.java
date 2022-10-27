package com.example.rest.dto;

import com.example.persistence.domain.Customers;


public class OrdersDTO {

    private long ord_id;
    private int cust_id;
	private int prod_qty;
	private float prod_price;
	private  float prod_discount;
	private float total_amount;
	private int total_qty;
	private float saving_amount;

    private Customers customers;

	public long getOrd_id()
	{
		return ord_id;
	}

	public void setOrder_id(long ord_id) {
		this.ord_id = ord_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getProd_qty() {
		return prod_qty;
	}

	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public float getProd_discount() {
		return prod_discount;
	}

	public void setProd_discount(float prod_discount) {
		this.prod_discount = prod_discount;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public int getTotal_qty() {
		return total_qty;
	}

	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}

	public float getSaving_amount() {
		return saving_amount;
	}

	public void setSaving_amount(float saving_amount) {
		this.saving_amount = saving_amount;
	}

	public Customers getOrders() {
		return customers;
	}

	public void setOrders(Customers orders) {
		this.customers = orders;
	}

	public OrdersDTO(long ord_id, int cust_id, int prod_qty, float prod_price, float prod_discount, float total_amount,
			int total_qty, float saving_amount, Customers customers) {
		super();
		this.ord_id = ord_id;
		this.cust_id = cust_id;
		this.prod_qty = prod_qty;
		this.prod_price = prod_price;
		this.prod_discount = prod_discount;
		this.total_amount = total_amount;
		this.total_qty = total_qty;
		this.saving_amount = saving_amount;
		this.customers = customers;
	}

	public OrdersDTO() {
		super();
	}

	@Override
	public String toString() {
		return "OrdersDTO [order_id=" + ord_id + ", cust_id=" + cust_id + ", prod_qty=" + prod_qty + ", prod_price="
				+ prod_price + ", prod_discount=" + prod_discount + ", total_amount=" + total_amount + ", total_qty="
				+ total_qty + ", saving_amount=" + saving_amount + ", orders=" + customers + "]";
	}  

}