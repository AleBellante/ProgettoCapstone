package com.EShopAlBe.EShop.functions.controller;

import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EShopAlBe.EShop.functions.model.DeliveryLocation;
import com.EShopAlBe.EShop.functions.model.Fattura;
import com.EShopAlBe.EShop.functions.service.DeliveryLocationService;
import com.EShopAlBe.EShop.functions.service.FatturaService;

@RestController
@RequestMapping("/delivery-location")
public class DeliveryLocationController {

	
	@Autowired 
	DeliveryLocationService deliveryLocationService;
	@Autowired 
	FatturaService fatturaService;
	
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllDeliveryLocation(Pageable pageable){
		return new ResponseEntity<>(deliveryLocationService.getAllDeliveryLocation(pageable), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save/{fattura-id}")
	public ResponseEntity<?> assignIndirizzo(@PathVariable(name = "fattura-id") Long id,@RequestBody DeliveryLocation d) {
		Fattura f = fatturaService.findById(id);
		d.setFattura(f);
		return new ResponseEntity<>(deliveryLocationService.saveDeliveryLocation(d), HttpStatus.CREATED);
	}

	
}

