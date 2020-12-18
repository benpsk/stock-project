package spring.hibernate.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.hibernate.model.Category;
import spring.hibernate.model.Sale;
import spring.hibernate.model.Stock;
import spring.hibernate.services.StockServices;

@Controller
public class StockController {

	@Autowired
	private StockServices stockServices;

	@RequestMapping("/index.htm")
	public String home(Model m) {

		m.addAttribute("stock", stockServices.getStock());
		m.addAttribute("cat", stockServices.getCat());
		return "home";
	}
	
	@RequestMapping(value="/manageStock")
	public String mStock(Model m) {
		m.addAttribute("stock", stockServices.getStock());
		m.addAttribute("cat", stockServices.getCat());
		return "manageStock";
	}

	@RequestMapping(value = "/upStockForm/{id}")
	public String manageStock(@PathVariable int id, Model m) {
		m.addAttribute("stock", stockServices.getStockbyID(id));
		m.addAttribute("cat", stockServices.getCat());
		return "upStockForm";
	}

	@RequestMapping(value = "updateStock")
	public String updateStock(@Valid @ModelAttribute(value = "stock") Stock stock, BindingResult br) {

		if (br.hasErrors()) {
			return "manageStock";
		} else {
			stockServices.updateStock(stock);
			return "redirect:/manageStock";
		}
	}
	
	@RequestMapping(value="deleteStock/{id}")
	public String deletStock(@PathVariable int id) {
		stockServices.deleteStock(id);
		return "redirect:/manageStock";
	}

	@RequestMapping(value = "/filterCat/{id}")
	public String filter(@PathVariable int id, Model m) {
		m.addAttribute("stock", stockServices.filterCat(id));
		return "filterPage";
	}
	
	@RequestMapping(value="/mFilterList/{id}")
	public String mFilterList(@PathVariable int id, Model m) {
		m.addAttribute("stock", stockServices.filterCat(id));
		return "mFilterList";
	}

	@RequestMapping(value = "/getSale/{id}")
	public String getSale(@PathVariable int id, Model m) {
		m.addAttribute("stock", stockServices.getStock());
		m.addAttribute("sale", stockServices.getSalebyID(id));
		return "updateSale";
	}

	@RequestMapping(value = "/saveUpdate")
	public String updateSale(@ModelAttribute(value = "sale") Sale sale) {
//		System.out.println(sale.getSale_id());
		stockServices.updateSale(sale);
		return "redirect:/saleList";
	}

	@RequestMapping(value = "/deleteSale/{id}")
	public String deleteSale(@PathVariable int id) {
		stockServices.deleteSale(id);
		return "redirect:/saleList";
	}

	@RequestMapping("/stockForm")
	public String stockForm(Model m) {
		m.addAttribute("stock", new Stock());
		m.addAttribute("cat", stockServices.getCat());
		return "stockForm";
	}

	@RequestMapping("/saleList")
	public String saleList(Model m) {
		m.addAttribute("sale", stockServices.getSale());
		return "saleList";
	}

	@RequestMapping(value = "/saleForm/{id}")
	public String saleForm(@PathVariable int id, Model m) {
		Stock s = stockServices.getStockbyID(id);
		m.addAttribute("stock", s);
		m.addAttribute("sale", new Sale());
		return "saleForm";
	}

	@RequestMapping(value = "/addSale", method = RequestMethod.POST)
	public String saleForm(@Valid @ModelAttribute(value = "sale") Sale sale, BindingResult br) {

		if (br.hasErrors()) {
			return "saleForm";
		} else {

			Double tamount = sale.getPrice() * sale.getQty();
			sale.setTotal_amount(tamount);

			int stock_id = sale.getStock().getStock_id();
			Stock s = stockServices.getStockbyID(stock_id);

			int qty = s.getQty() - sale.getQty();
			stockServices.upStockQty(stock_id, qty);

			stockServices.addSale(sale);
			return "redirect:/saleList";
		}
	}

	@RequestMapping(value = "/addStock", method = RequestMethod.POST)
	public String stock(@Valid @ModelAttribute(value = "stock") Stock stock, BindingResult br) {

		if (br.hasErrors()) {
			return "redirect:/stockForm";
		} else {
			stockServices.addStock(stock);
			return "redirect:/index.htm";
		}
	}

	@RequestMapping("/catForm")
	public String catForm(Model m) {
		m.addAttribute("cat", new Category());
		m.addAttribute("catList", stockServices.getCat());
		return "addCat";
	}

	@RequestMapping("/addCat")
	public String addCat(@Valid @ModelAttribute(value = "cat") Category cat, BindingResult br) {

		if (br.hasErrors()) {
			return "addCat";
		} else {
			stockServices.addCat(cat);
			return "redirect:/index.htm";
		}
	}

}
