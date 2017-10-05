package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productService.getProducts());
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editForm(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("product/edit-product-form");
		modelAndView.addObject("product", productService.find(id));
		return modelAndView;
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("product/detail");
		modelAndView.addObject("product", productService.find(id));
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("product")Product product) {
		productService.update(product);
		ModelAndView modelAndView = list();
		return modelAndView;
	}

	@RequestMapping(value = "/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("product/add-product-form");
		modelAndView.addObject("command", new Product());
		return modelAndView;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("product")Product product) {
		productService.create(product);
		ModelAndView modelAndView = list();
		return modelAndView;
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("searchText") String searchText) {
	   List<Product> foundProducts = productService.searchForProduct(searchText);
	      
	   ModelAndView modelAndView = new ModelAndView("foundProducts");
	   modelAndView.addObject("foundProducts", foundProducts);
	   return modelAndView;
	}
	
}
