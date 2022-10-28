package com.example.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Orders 
{
	
	@NotNull
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ord_id ;
	@NotNull
	private int cust_id;
	@NotNull
	private int prod_qty;
	@NotNull
    private float prod_price;
	private  float prod_discount;
	@NotNull
	private float total_amount;
	@NotNull
	private int total_qty;
	@NotNull
	private float saving_amount;
    
	
    @ManyToOne
    private Customers customers;

    @NotNull
	public long getOrd_id()
    {
		return ord_id;
	}


	public void setOrd_id(long ord_id) 
	{
		this.ord_id = ord_id;
	}


	public int getCust_id()
	{
		return cust_id;
	}


	public void setCust_id(int cust_id)
	{
		this.cust_id = cust_id;
	}


	public int getProd_qty()
	{
		return prod_qty;
	}


	public void setProd_qty(int prod_qty)
	{
		this.prod_qty = prod_qty;
	}


	public float getProd_price()
	{
		return prod_price;
	}


	public void setProd_price(float prod_price)
	{
		this.prod_price = prod_price;
	}


	public float getProd_discount()
	{
		return prod_discount;
	}


	public void setProd_discount(float prod_discount)
	{
		this.prod_discount = prod_discount;
	}


	public float getTotal_amount()
	{
		return total_amount;
	}


	public void setTotal_amount(float total_amount)
	{
		this.total_amount = total_amount;
	}


	public int getTotal_qty()
	{
		return total_qty;
	}


	public void setTotal_qty(int total_qty)
	{
		this.total_qty = total_qty;
	}


	public float getSaving_amount()
	{
		return saving_amount;
	}


	public void setSaving_amount(float saving_amount) 
	{
		this.saving_amount = saving_amount;
	}


	public Customers getCustomers()
	{
		return customers;
	}


	public void setCustomers(Customers customers)
	{
		this.customers = customers;
	}


	public Orders(@NotNull long ord_id, @NotNull int cust_id, int prod_qty, float prod_price, float prod_discount,
			float total_amount, int total_qty, float saving_amount, Customers customers)
	{
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
    

	public Orders()
	{
		super();
	}


	@Override
	public String toString()
	{
		return "Orders [ord_id=" + ord_id + ", cust_id=" + cust_id + ", prod_qty=" + prod_qty + ", prod_price="
				+ prod_price + ", prod_discount=" + prod_discount + ", total_amount=" + total_amount + ", total_qty="
				+ total_qty + ", saving_amount=" + saving_amount + ", orders=" + customers + "]";
	}

}  