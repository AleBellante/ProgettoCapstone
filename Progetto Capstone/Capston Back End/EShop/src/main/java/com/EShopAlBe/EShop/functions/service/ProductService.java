package com.EShopAlBe.EShop.functions.service;


import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.auth.exception.MyAPIException;
import com.EShopAlBe.EShop.functions.model.EProductType;
import com.EShopAlBe.EShop.functions.model.Ordine;
import com.EShopAlBe.EShop.functions.model.Product;
import com.EShopAlBe.EShop.functions.repository.ProductDaoRepository;

@Service
public class ProductService {
	@Autowired
	private ProductDaoRepository prodRepo;
	
	public Product salvaProdotto(Product p) {
		prodRepo.save(p);
		return p;
	}
	
	public Page<Product> trovaProdotti(Pageable pageable){
		return (Page<Product>) prodRepo.findAll(pageable);
	}
	
	
	  public Product trovaProdotto(EProductType prodType) {
	  Product p  = prodRepo.findByProductType(prodType);

	  return p ;
	  }
	  
	  public double sell(Ordine ordine) {
			Product p = this.trovaProdotto(ordine.getNomeprodotto());
			
			if (p.getStockNum()-ordine.getQnt()<0) {
				throw new MyAPIException (HttpStatus.BAD_REQUEST, "Ordine non possibile, stock non abbastanza grande.");
			}
			else
			p.setStockNum(p.getStockNum()-ordine.getQnt());
			double importo = (ordine.getQnt()*p.getPrezzounitario());
			return importo;
	  }

	
	public String removeProduct(EProductType ProductType) {
		Product p = this.trovaProdotto(ProductType);
		prodRepo.deleteById(p.getId());
		return "prodotto rimosso";
	}
}
	


