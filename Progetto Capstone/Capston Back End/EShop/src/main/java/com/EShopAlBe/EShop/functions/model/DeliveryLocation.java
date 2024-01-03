package com.EShopAlBe.EShop.functions.model;


import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
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
@Table(name = "be_service_eshopAlbl_deliveryinfo")
public class DeliveryLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String via;
	private int CAP;
	private String città;
	private String provincia;
	private String comune;
	private String additionalInfo;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "be_service_eshopAlbl_deliveryinfo_fatture",
    joinColumns = @JoinColumn(name = "deliveryinfo_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "fattura_id", referencedColumnName = "id"))
	private Fattura fattura;
	
}
