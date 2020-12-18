package spring.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.hibernate.dao.StockDao;
import spring.hibernate.model.Category;
import spring.hibernate.model.Sale;
import spring.hibernate.model.Stock;

@Service
@Transactional
public class StockServices {
	
	@Autowired
	StockDao stockDao;
	
	
	// Delete Stock by ID
	public void deleteStock(int id) {
		stockDao.deleteStock(id);
	}
	
	// Update Stock
	public void updateStock(Stock stock) {
		stockDao.updateStock(stock);
	}
	
	// Update Stock Qty
	public void upStockQty(int id, int qty) {
		stockDao.upStockQty(id, qty);
	}
	
	// Get Stock Item by ID to sale
	public Stock getStockbyID(int id) {
		return stockDao.getStockbyID(id);
	}
	
	// Update Sale
	public void updateSale(Sale sale) {
		stockDao.updateSale(sale);
	}
	
	// Get id for Filter
	public List<Stock> filterCat(int id) {
		return stockDao.filterCat(id);
	}
	
	// Add Category 
	public void addCat(Category cat) {
		stockDao.addCat(cat);
	}
	
	// Get Category
	public List<Category> getCat() {
		return stockDao.getCat();
	}
	
	// Add Stock Items
	public void addStock(Stock stock) {
		stockDao.addStock(stock);
	}
	
	// Get All Stock Items
	public List<Stock> getStock() {
		return stockDao.getStock();
	}
	
	// Add Sale Items
	public void addSale(Sale sale) {
		stockDao.addSale(sale);
	}
	
	// Get All Sale Items
	public List<Sale> getSale() {
		return stockDao.getSale();
	}
	
	// Delete Sale Items by ID
	public void deleteSale(int id) {
		stockDao.deleteSale(id);
	}
	
	// Get Sale Item by ID to update
	public Sale getSalebyID(int id) {
		return stockDao.getSalebyID(id);
	}
	
}
