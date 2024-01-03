package com.EShopAlBe.EShop.functions.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.EShopAlBe.EShop.functions.model.Client;


public interface ClientDaoRepository extends CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {
	
	public Client findByEmail(String email);
	public boolean existsByEmail(String email);
	
//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c orderby c.fatturatoAnnuale ")
//	public Page<Client> filterByFatturato(Double f, String s);
	
//	Data_inserimento
//	Data_ultimo_contratto


	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c ORDER BY c.nome ASC", nativeQuery = true)
	public Page<Client> orderByName(Pageable pageable);
	public Client findByUsername(String username);

//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c ORDER BY c.data_inserimento ASC", nativeQuery = true)
//	public Page<Client> orderByDataIns(Pageable pageable);
//	
//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c ORDER BY c.data_ultimo_contatto ASC", nativeQuery = true)
//	public Page<Client> orderByDataUltimo(Pageable pageable);
//	
//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c WHERE c.fatturato_annuale >= :fatturato ORDER BY c.fatturato_annuale ASC", nativeQuery = true)
//	public Page<Client> filterByFatturatoUp(double fatturato, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c WHERE c.fatturato_annuale <= :fatturato ORDER BY c.fatturato_annuale ASC", nativeQuery = true)
//	public Page<Client> filterByFatturatoDown(double fatturato, Pageable pageable);
//	
//	@Query(value = "SELECT * FROM be_service_eshopAlbl_clients c WHERE c.data_inserimento LIKE :data ORDER BY c.data_inserimento ASC", nativeQuery = true)
//	public Page<Client> filterByDataIns(LocalDate data, Pageable pageable);
//	
//	
//	Page<Client> findByPec(String pec, Pageable pageable);
	Iterable<Client> findAll(Sort sort);
	
	

}
