package com.EShopAlBe.EShop.functions.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.EShopAlBe.EShop.functions.model.DeliveryLocation;

public interface DeliveryLocationDaoRepository extends CrudRepository<DeliveryLocation, Long>, PagingAndSortingRepository<DeliveryLocation, Long> {

	Iterable<DeliveryLocation> findAll(Sort sort);
	List<DeliveryLocation> findByVia(String via);
}
