package com.EShopAlBe.EShop.functions.singleRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.EShopAlBe.EShop.functions.model.ETipologia;
import com.EShopAlBe.EShop.functions.repository.ClientDaoRepository;
import com.EShopAlBe.EShop.functions.repository.FatturaDaoRepository;


@Component
public class Runner implements ApplicationRunner{
	
	@Autowired FatturaDaoRepository fatturaRepo;
//	@Autowired TipologiaDaoRepository tipoRepo;
	@Autowired ClientDaoRepository productRepo;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(" Running...");
//		setTipologiaDefault();
		
	}
	
	/*
	 * private void setTipologiaDefault() {
	 * 
	 * Tipologia prenotazione = new Tipologia();
	 * prenotazione.setTipologiaName(ETipologia.PRENOTAZIONE);
	 * tipoRepo.save(prenotazione);
	 * 
	 * Tipologia consegna =new Tipologia();
	 * consegna.setTipologiaName(ETipologia.CONSEGNA); tipoRepo.save(consegna); }
	 */
	
}
