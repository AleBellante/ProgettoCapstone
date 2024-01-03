package com.EShopAlBe.EShop.functions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Table(name = "be_service_eshopAlbl_clients")
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Builder
	public class Client {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String cognome;
		private String email;
	    private String nome;
	    private String telefono;
	    private String username;
//	    @Enumerated(EnumType.STRING)
//	    private CustomerType tipoCliente;
//	    @OneToOne(cascade = CascadeType.ALL)
//	    private Address indirizzoSedeLegale;
//	    @OneToOne(cascade = CascadeType.ALL)
//	    private Address indirizzoSedeOperativa;
	}



