package com.EShopAlBe.EShop.functions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EShopAlBe.EShop.functions.service.OrdineService;

@RestController
@RequestMapping("/ordini")
public class OrderController {
	@Autowired
	OrdineService ordService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllOrdini(Pageable pageable){
		return new ResponseEntity<>(ordService.trovaOrdini(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity<?> getOrdiniByFattura(@PathVariable(name = "id")Long id, Pageable pageable){
		return new ResponseEntity<>(ordService.trovaOrdiniTramiteFattura(pageable, id), HttpStatus.OK);
	}
	
}
