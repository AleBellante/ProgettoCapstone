package com.EShopAlBe.EShop.functions.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EShopAlBe.EShop.functions.model.EProductType;
import com.EShopAlBe.EShop.functions.model.Product;
import com.EShopAlBe.EShop.functions.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
	@Autowired ProductService prodService;


	@GetMapping(path= "/all")
	public ResponseEntity<?> getAllProducts(Pageable pageable){
		return new ResponseEntity<>(prodService.trovaProdotti(pageable), HttpStatus.OK);
	}
	@PostMapping(path="/save")
	public ResponseEntity<?>createProduct(@RequestBody Product p){
		return new ResponseEntity<Product>(prodService.salvaProdotto(p), HttpStatus.CREATED);
	}
	
	

	@CrossOrigin(origins = "*")
	@DeleteMapping(path="/delete")
	public ResponseEntity<String>deleteProduct(@RequestBody Product p){
		return new ResponseEntity<String>(prodService.removeProduct(p.getProductType()), HttpStatus.OK);
	}

}
