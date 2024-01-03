package com.EShopAlBe.EShop.functions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.functions.model.DeliveryLocation;
import com.EShopAlBe.EShop.functions.repository.DeliveryLocationDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class DeliveryLocationService {
	
	@Autowired DeliveryLocationDaoRepository repo;

	public Page<DeliveryLocation> getAllDeliveryLocation(Pageable pageable) {
		return (Page<DeliveryLocation>) repo.findAll(pageable);
	}
	public List<DeliveryLocation> getAllDeliveryLocationList() {
		return (List<DeliveryLocation>) repo.findAll();
	}
	
	public List<DeliveryLocation>getDeliveryLocation(String via) {

		return repo.findByVia(via);
	}
	
	
//	public void addAddress(Cliente client, Address address) {
//	    if (client.getAddresses().size() < 2) {
//	        address.setClient(client);
//	        client.getAddresses().add(address);
//	    } else {
//	        throw new RuntimeException("Client already has two addresses");
//	    }
//	}

	
	public String removeDeliveryLocation(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Delivery Location not exists!!!");
		}
		repo.deleteById(id);
		return "Delivery Location Deleted!!!";
	}
	
	public DeliveryLocation updateDeliveryLocation(DeliveryLocation d) {
		if(!repo.existsById(d.getId())) {
			throw new EntityExistsException("Delivery Location not exists!!!");
		}
		repo.save(d);
		return  d;
	}
	public DeliveryLocation saveDeliveryLocation(DeliveryLocation d) {
		repo.save(d);
		return  d;
	}


	


}
