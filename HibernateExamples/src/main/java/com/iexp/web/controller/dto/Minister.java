package com.iexp.web.controller.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Minister")
public class Minister {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_sequence")
	@SequenceGenerator(name = "m_sequence", sequenceName = "minister_sequence_db",allocationSize=1)	
	Long ministerId;
	
	@Column
	String ministerName;
	
	@ManyToOne
	@JoinColumn(name= "PRIMEMINISTER_ID")
	@JsonIgnore
	PrimeMinister primeminister;
	
	public Long getMinisterId() {
		return ministerId;
	}

	public void setMinisterId(Long ministerId) {
		this.ministerId = ministerId;
	}

	public String getMinisterName() {
		return ministerName;
	}

	public void setMinisterName(String ministerName) {
		this.ministerName = ministerName;
	}
	
	@JsonIgnore
	public PrimeMinister getPrimeminister() {
		return primeminister;
	}
	public void setPrimeminister(PrimeMinister primeminister) {
		this.primeminister = primeminister;
	}
}
