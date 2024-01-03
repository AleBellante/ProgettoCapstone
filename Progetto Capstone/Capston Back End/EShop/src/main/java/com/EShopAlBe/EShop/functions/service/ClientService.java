package com.EShopAlBe.EShop.functions.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.functions.model.Client;
import com.EShopAlBe.EShop.functions.repository.ClientDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService {
	
	@Autowired ClientDaoRepository repo;
	
	 @Autowired @Qualifier("FakeClient") private ObjectProvider<Client> fakeProvider;
	

	public Page<Client> findAllClienti(Pageable pageable) {
		return (Page<Client>) repo.findAll(pageable);
	}
	public ArrayList<Client> findAllClientiList() {
		return (ArrayList<Client>) repo.findAll();
	}
	public Page<Client> sortAll(Sort sort) {
		return (Page<Client>) repo.findAll(sort);
	}

	
	public Client findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("User does not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	public Client saveClient(Client client) {
		if(repo.existsByEmail(client.getEmail())) {
			throw new EntityExistsException("Email exists!!!");
		} else {
			repo.save(client);
		}
		return client;
	}
	
	public String removeClient(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Client not exists!!!");
		}
		repo.deleteById(id);
		return "Client Deleted!!!";
	}
	
	public Client updateClient(Client client) {
		if(!repo.existsById(client.getId())) {
			throw new EntityExistsException("Client not exists!!!");
		}
		repo.save(client);
		return client;
	}
	
	
	public Client findByEmail(String email) {
		return repo.findByEmail(email);
	}
	public Client findByUsername(String username) {
		return repo.findByUsername( username);
	}

	public Page<Client> ascendingName(Pageable pageable) {
		return repo.orderByName(pageable);
	}
	
}
