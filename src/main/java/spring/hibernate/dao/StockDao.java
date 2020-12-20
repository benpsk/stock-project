package spring.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.hibernate.model.Category;
import spring.hibernate.model.Sale;
import spring.hibernate.model.Stock;

@Repository
public class StockDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("deprecation")
	public void deleteStock(int id) {
		Serializable ide = new Integer(id);
		Object obj = getSession().load(Stock.class, ide);
		if (obj != null) {
		    getSession().delete(obj);
		}
		
//		String hql = "DELETE FROM Stock WHERE stock_id=:id";
//		Query q = getSession().createQuery(hql);
//		q.setParameter("id", id);
//		q.executeUpdate();
	}
	
	public void updateStock(Stock stock) {
//		String hql = "UPDATE Stock SET name=:name, code=:code, sale_price=:s_price, qty=:qty, purchase_price=:p_price, category_id=:catId WHERE stock_id=:id";
//		Query q = getSession().createQuery(hql);
//		q.setParameter("name", stock.getName());
//		q.setParameter("code", stock.getCode());
//		q.setParameter("s_price", stock.getSale_price());
//		q.setParameter("qty", stock.getQty());
//		q.setParameter("p_price", stock.getPurchase_price());
//		q.setParameter("catId", stock.getCategory().getId());
//		q.setParameter("id", stock.getStock_id());
//		q.executeUpdate();
		getSession().update(stock);
	}
	
	public void upStockQty(int id, int qty) {
		String hql = "UPDATE Stock SET qty=:qty WHERE stock_id=:id";
		Query q = getSession().createQuery(hql);
		q.setParameter("qty", qty);
		q.setParameter("id", id);
		q.executeUpdate();
	}
	
	
	public Stock getStockbyID(int id) {
		Criteria cr = getSession().createCriteria(Stock.class);
		cr.add(Restrictions.eq("id", id));
		return (Stock) cr.uniqueResult();
	}

	public void updateSale(Sale sale) {
//		String hql = "UPDATE Sale SET date=:date, qty=:qty, price=:price, total_amount=:total_amount, stock_id=:stock_id WHERE sale_id=:id";
//		Query q = getSession().createQuery(hql);
//		q.setParameter("date", sale.getDate());
//		q.setParameter("qty", sale.getQty());
//		q.setParameter("price", sale.getPrice());
//		q.setParameter("total_amount", sale.getTotal_amount());
//		q.setParameter("stock_id", sale.getStock().getStock_id());
//		q.setParameter("id", sale.getSale_id());
//		q.executeUpdate();
		getSession().update(sale);
	}

	@SuppressWarnings("unchecked")
	public List<Stock> filterCat(int id) {
		Criteria cr = getSession().createCriteria(Stock.class);
		cr.add(Restrictions.eq("category.id", id));
		return (List<Stock>) cr.list();
	}

	public Sale getSalebyID(int id) {
		Criteria cr = getSession().createCriteria(Sale.class);
		cr.add(Restrictions.eq("id", id));
		return (Sale) cr.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	public void deleteSale(int id) {
//		String hql = "DELETE FROM Sale WHERE sale_id = :id";
//		Query query = getSession().createQuery(hql);
//		query.setParameter("id", id);
//		query.executeUpdate();
		
		Serializable ide = new Integer(id);
		Object obj = getSession().load(Sale.class, ide);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Sale> getSale() {
		Criteria cr = getSession().createCriteria(Sale.class);
		return (List<Sale>) cr.list();
	}

	public void addSale(Sale sale) {
		getSession().save(sale);
	}

	@SuppressWarnings("unchecked")
	public List<Stock> getStock() {
		Criteria cr = getSession().createCriteria(Stock.class);
		return (List<Stock>) cr.list();
	}

	public void addStock(Stock stock) {
		getSession().save(stock);
	}

	public void addCat(Category cat) {
		getSession().save(cat);
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCat() {
		// TODO Auto-generated method stub
		Criteria cr = getSession().createCriteria(Category.class);
		return (List<Category>) cr.list();
	}

}
