package com.EShopAlBe.EShop.functions.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EShopAlBe.EShop.functions.model.Client;
import com.EShopAlBe.EShop.functions.service.ClientService;


@RestController
@RequestMapping("/clients")
public class ClientController {
		
		@Autowired 
		ClientService clientService;
		
		@GetMapping(path = "/all")
		public ResponseEntity<?> getAllClienti(Pageable pageable){
			return new ResponseEntity<>(clientService.findAllClienti(pageable), HttpStatus.OK);
		}
		
		@GetMapping(path = "/{id}")
		public ResponseEntity<?> getClient(@PathVariable(name = "id") Long id){
			return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<?> createClient(@RequestBody Client client) {
			return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.CREATED);

		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteClient(@PathVariable Long id){
			return new ResponseEntity<String>(clientService.removeClient(id), HttpStatus.OK);

		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateUser(@RequestBody Client client) {
			return new ResponseEntity<Client>(clientService.updateClient(client), HttpStatus.CREATED);
		}
		
		@GetMapping(path = "/nome")
		public ResponseEntity<?> ascendingName(Pageable pageable) {
			return new ResponseEntity<>(clientService.ascendingName(pageable), HttpStatus.OK);
		}
//		
//		@GetMapping(path = "/order/fatturato")
//		public ResponseEntity<?> ascendingFatturato(Pageable pageable) {
//			return new ResponseEntity<>(clientService.ascendingFatturato(pageable), HttpStatus.OK);
//		}
//		
//		@GetMapping(path = "/order/data-ins")
//		public ResponseEntity<?> ascendingDataIns(Pageable pageable) {
//			return new ResponseEntity<>(clientService.ascendingDataIns(pageable), HttpStatus.OK);
//		}
//		
//		@GetMapping(path = "/order/data-ultimo")
//		public ResponseEntity<?> ascendingDataUltimo(Pageable pageable) {
//			return new ResponseEntity<>(clientService.ascendingDataUltimo(pageable), HttpStatus.OK);
//		}
//		
//		@GetMapping(path = "/filter/{fatturato}/above")
//		public ResponseEntity<?> filterByFatturatoUp(@PathVariable(name = "fatturato") Double fatturato, Pageable pageable) {
//			return new ResponseEntity<>(clientService.filterByFatturatoUp(fatturato,pageable), HttpStatus.OK);
//		}
//		
//		@GetMapping(path = "/filter/{fatturato}/below")
//		public ResponseEntity<?> filterByFatturatoDown(@PathVariable(name = "fatturato") Double fatturato, Pageable pageable) {
//			return new ResponseEntity<>(clientService.filterByFatturatoDown(fatturato,pageable), HttpStatus.OK);
//		}
		
//		@GetMapping(path = "/filter/data")
//		public ResponseEntity<?> filterByDataIns(@RequestParam("data")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate data, Pageable pageable) {
//			return new ResponseEntity<>(clientService.filterByDataIns(data,pageable), HttpStatus.OK);
//		}
		
//		@GetMapping(path = "/filter/{data}/before")
//		public ResponseEntity<?> filterByDataIns(@PathVariable(name = "data") LocalDate data, Pageable pageable) {
//			return new ResponseEntity<>(clientService.filterByDataIns(data,pageable), HttpStatus.OK);
//		}
}

