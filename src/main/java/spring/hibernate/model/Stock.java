package spring.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stock_id;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]+\s)*[a-zA-Z0-9]+$", message="**Invalid Stock Name!**")
	private String name;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]+\s)*[a-zA-Z0-9]+$", message="**Invalid Stock Code!**")
	private String code;
	@NotNull(message="**Invalid Price (Please Entry number only)!**")
//	@Pattern(regexp="^[0-9]+$",message="**Invalid Price (Please Entry number only)!**")
	private Double sale_price;
	@NotNull(message="**Invalid Quantity (Please Entry number only)!**")
//	@Pattern(regexp="^[0-9]+$",message="**Invalid Quantity (Please Entry number only)!**")
	private int qty;
	@NotNull(message="**Invalid Price (Please Entry number only)!**")
//	@Pattern(regexp="^[0-9]+$",message="**Invalid Price (Please Entry number only)!**")
	private Double purchase_price;
	
	public Stock() {
		
	}
	
	@ManyToOne
	@JoinColumn(name="category_id")
	public Category category = new Category();
	
	@OneToMany(mappedBy="stock", targetEntity=Sale.class, cascade=CascadeType.ALL)
	private List<Sale> sale_item = new ArrayList<Sale>();

	public List<Sale> getSale_item() {
		return sale_item;
	}

	public void setSale_item(List<Sale> sale_item) {
		this.sale_item = sale_item;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(Double purchase_price) {
		this.purchase_price = purchase_price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
