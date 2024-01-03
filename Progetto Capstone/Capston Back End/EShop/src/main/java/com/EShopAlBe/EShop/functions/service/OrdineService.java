package com.EShopAlBe.EShop.functions.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.functions.model.Ordine;
import com.EShopAlBe.EShop.functions.repository.OrdineDaoRepository;

@Service
public class OrdineService {
	@Autowired
	private OrdineDaoRepository repo;
	
	
public Ordine salvaPeQ(Ordine p) {
	repo.save(p);
	return p;
}
public Page<Ordine> trovaOrdini(Pageable pageable){
	return (Page<Ordine>) repo.findAll(pageable);
}

public Page<Ordine> trovaOrdiniTramiteFattura(Pageable pageable, Long id){
	return (Page<Ordine>)repo.filterByFattura(id, pageable);
}

}
