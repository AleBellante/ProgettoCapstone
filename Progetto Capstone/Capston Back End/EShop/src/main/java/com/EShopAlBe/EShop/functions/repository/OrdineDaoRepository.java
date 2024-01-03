package com.EShopAlBe.EShop.functions.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.EShopAlBe.EShop.functions.model.Ordine;

public interface OrdineDaoRepository extends CrudRepository<Ordine, Long>{
	
//	@Query(value = "SELECT * be_service_eshopAlbl_fatture f WHERE f.clients_id = :clienteId ORDER BY f.clients_id ASC", nativeQuery = true)
//	public Page<Fattura> filterByCliente(Long clienteId, Pageable pageable);
//	
	Iterable<Ordine> findAll(Pageable pageable);
	
	@Query(value = "SELECT * FROM be_service_eshopAlbl_fatture_ordini f WHERE f.fattura_id = :fatturaId ORDER BY f.fattura_id ASC", nativeQuery = true)
	public Page<Ordine> filterByFattura(Long fatturaId, Pageable pageable);
}

