package com.EShopAlBe.EShop.functions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.functions.model.Fattura;
import com.EShopAlBe.EShop.functions.repository.FatturaDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {
	@Autowired
	private FatturaDaoRepository fattRep;
	
	public double caricaImporto(double x, double y) {
		return x +y;
	}
	
	public Fattura salvaFatture(Fattura fattura) {
		fattRep.save(fattura);
		return fattura;
	}
	public Page<Fattura> ascendingFatture(Pageable pageable){
		return (Page<Fattura>) fattRep.ascendingName(pageable);
	}
	public Page<Fattura> trovaFattureCliente(Pageable pageable){
		return (Page<Fattura>) fattRep.findAll(pageable);
	}
	public Fattura updateFatture(Fattura fattura) {
		if(!fattRep.existsById(fattura.getId())) {
			throw new EntityExistsException("Fattura not exists!!!");
		}
		fattRep.save(fattura);
		return fattura;
	}
	public Fattura findById(Long id) {
		if(!fattRep.existsById(id)) {
			throw new EntityNotFoundException("Fattura not exists!!!");
		}
		return fattRep.findById(id).get();
	}
	
	public Page<Fattura> filterByCliente(Long clienteId, Pageable pageable) {
		return fattRep.filterByCliente(clienteId, pageable);
	}
	
//	public Page<Fattura> filterByStato(int stato, Pageable pageable) {
//		
//		return fattRep.filterByStato(stato, pageable);
//	}
}
