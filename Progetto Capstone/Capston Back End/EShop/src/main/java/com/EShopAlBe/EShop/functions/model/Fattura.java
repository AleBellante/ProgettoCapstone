package com.EShopAlBe.EShop.functions.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "be_service_eshopAlbl_fatture")
public class Fattura implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Client cliente;
	
	@Builder.Default
	private LocalDate data = LocalDate.now();
	
	private double importo;
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinTable(name = "be_service_eshopAlbl_fatture_ordini",
    joinColumns = @JoinColumn(name = "fattura_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "id"))
    @Column(nullable = false)
	private List<Ordine>ordine = new ArrayList<>();
	
	  
    @Enumerated(EnumType.STRING)
	private ETipologia tipologia;
	
}
