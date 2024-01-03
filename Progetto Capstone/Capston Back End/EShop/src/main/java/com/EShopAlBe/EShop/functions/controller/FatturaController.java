package com.EShopAlBe.EShop.functions.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.EShopAlBe.EShop.auth.exception.MyAPIException;
import com.EShopAlBe.EShop.functions.model.*;
import com.EShopAlBe.EShop.functions.service.ClientService;
import com.EShopAlBe.EShop.functions.service.FatturaService;
import com.EShopAlBe.EShop.functions.service.OrdineService;
import com.EShopAlBe.EShop.functions.service.ProductService;


@RestController
@RequestMapping("/fatture")
public class FatturaController {
		
		@Autowired 
		FatturaService fatturaService;
		@Autowired 
		ClientService clientService;
		@Autowired
		ProductService prodService;
		@Autowired
		OrdineService ordService;
		
		@GetMapping(path = "/all")
		public ResponseEntity<?> getAllFatture(Pageable pageable){
			return new ResponseEntity<>(fatturaService.trovaFattureCliente(pageable), HttpStatus.OK);
		}
		
//		@PostMapping(path = "/save/{id}")
//		public ResponseEntity<?> assignCliente(@PathVariable(name = "id") Long id, @RequestBody Fattura f ){
//			Client c = clientService.findById(id);
//			f.setCliente(c);
//			return new ResponseEntity<>(fatturaService.salvaFatture(f), HttpStatus.CREATED);
//		}
		
		
		@PostMapping(path = "/save/{username}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> saveFattura(@PathVariable(name = "username") String username, @RequestBody Fattura f ){
			Client c = clientService.findByUsername(username);
			f.setCliente(c);
			return new ResponseEntity<>(fatturaService.salvaFatture(f), HttpStatus.CREATED);
		}
			
		@PostMapping(path="/save/fattura/{username}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> assignOrdini(@PathVariable(name = "username")String username, @RequestBody Fattura f){
			Fattura fat =  new Fattura();
			fat.setCliente(clientService.findByUsername(username));
			fat.setTipologia(f.getTipologia());
			List<Ordine> pList = new ArrayList<>();
			f.getOrdine().forEach(ordine -> {
				try {
				fat.setImporto((fat.getImporto()+ prodService.sell(ordine)));
				ordService.salvaPeQ(ordine);
				pList.add(ordine);
				}
				catch(MyAPIException e) {
					throw new MyAPIException(HttpStatus.BAD_REQUEST, "Qualcosa è andata storta");
				}
				
			});
				fat.setOrdine(pList);
				return new ResponseEntity<>(fatturaService.salvaFatture(fat), HttpStatus.CREATED);
			
		}
		
		@GetMapping(path = "/ascending")
		public ResponseEntity<?> getAllFattureAscending(Pageable pageable){
			return new ResponseEntity<>(fatturaService.ascendingFatture(pageable), HttpStatus.OK);
		}
		
		@GetMapping(path = "/filter/id/{clienteId}")
		public ResponseEntity<?> filterByCliente(@PathVariable(name = "clienteId") Long clienteId, Pageable pageable) {
			return new ResponseEntity<>(fatturaService.filterByCliente(clienteId, pageable), HttpStatus.OK);
		}

		@CrossOrigin(origins = "*", maxAge = 3600)
		@GetMapping(path = "/cliente/{username}")
		public ResponseEntity<?> filterByClienteUsername(@PathVariable(name = "username") String username, Pageable pageable) {
			Client c = clientService.findByUsername(username);
			return new ResponseEntity<>(fatturaService.filterByCliente(c.getId(), pageable), HttpStatus.OK);
		}
		
		@GetMapping(path="/id/{id}")
		public ResponseEntity<?> getById(@PathVariable(name = "id") Long fatturaId){
			return new ResponseEntity<>(fatturaService.findById(fatturaId), HttpStatus.OK);
		}
//		@GetMapping(path = "/filter/state/{stato}")
//		public ResponseEntity<?> filterByStato(@PathVariable(name = "stato") int stato, Pageable pageable) {
//			return new ResponseEntity<>(fatturaService.filterByStato(stato, pageable), HttpStatus.OK);
//		}
//		
//		@PostMapping(path= "/save")
//		public ResponseEntity<?> createFattura(@RequestBody Fattura fattura) {
//			return new ResponseEntity<Fattura>(fatturaService.salvaFatture(fattura), HttpStatus.CREATED);
//
//		}
//		
//		@DeleteMapping("/{id}")
//		public ResponseEntity<String> deleteClient(@PathVariable Long id){
//			return new ResponseEntity<String>(fatturaService.removeClient(id), HttpStatus.OK);
//
//		}
//		
//		@PutMapping("/{id}")
//		public ResponseEntity<?> updateUser(@RequestBody Fattura fattura) {
//			return new ResponseEntity<Cliente>(fatturaService.updateClient(client), HttpStatus.CREATED);
//		}
//
//		@GetMapping(path = "/pec/{pec}")
//		public ResponseEntity<?> getByPec(@PathVariable(name = "pec") String pec, Pageable pageable) {
//			return new ResponseEntity<>(fatturaService.findByPec(pec, pageable), HttpStatus.OK);
//		}
//		
////		@GetMapping(path = "/all")
////		public ResponseEntity<?> orderByName(Pageable pageable){
////			return new ResponseEntity<>(clientService.findAllClienti(pageable), HttpStatus.OK);
////		}
//		@GetMapping(path = "/nome")
//		public ResponseEntity<?> ascendingName(Pageable pageable) {
//			return new ResponseEntity<>(fatturaService.ascendingName(pageable), HttpStatus.OK);
//		}
//		
////		@GetMapping(path = "/fatturato/{fatturato}")
////		public ResponseEntity<?> filterByFatturato()
}

