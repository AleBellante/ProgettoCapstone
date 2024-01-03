package com.EShopAlBe.EShop.functions.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "be_service_eshopAlbl_products",uniqueConstraints = @UniqueConstraint(columnNames = "productType"))
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    @Enumerated(EnumType.STRING)
	private EProductType productType;
	private int stockNum;
	@Column(length= 50000)
	private String immagine;
	private double prezzounitario;

}
