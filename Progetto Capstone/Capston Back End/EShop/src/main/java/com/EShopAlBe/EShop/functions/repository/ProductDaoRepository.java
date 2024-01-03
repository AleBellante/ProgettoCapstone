package com.EShopAlBe.EShop.functions.repository;



import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.EShopAlBe.EShop.functions.model.EProductType;
import com.EShopAlBe.EShop.functions.model.Product;

public interface ProductDaoRepository extends CrudRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{

	Iterable<Product> findAll(Sort sort);
	Product findByProductType(EProductType prodType);

}
