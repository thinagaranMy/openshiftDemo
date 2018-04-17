package com.thina.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/findAllProduct")
	public List<Product> getAllProducts(){
		List<Product> result = new ArrayList<Product>();
		for (Product product:productDAO.findAll() ){
			result.add(product);
		}
		return result;
	}

}
