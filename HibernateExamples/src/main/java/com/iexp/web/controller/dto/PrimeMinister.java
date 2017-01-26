package com.iexp.web.controller.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="PRIME_MINISTER")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class PrimeMinister {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pm_sequence")
	@SequenceGenerator(name = "pm_sequence", sequenceName = "primeminister_sequence_db",allocationSize=1)	
	@Column(name="PRIMEMINISTER_ID")
	Long primerministerId;

	@Column(name="PRIME_MINISTER_NAME", unique=true)
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="primeminister", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)	
	List<Minister> ministers = new ArrayList<Minister>();

	@OneToOne
	@JsonIgnore
	Nation nation;

	
	public Long getPrimerministerId() {
		return primerministerId;
	}

	public void setPrimerministerId(Long primerministerId) {
		this.primerministerId = primerministerId;
	}

	public List<Minister> getMinisters() {
		return ministers;
	}

	public void setMinisters(List<Minister> ministers) {
		this.ministers = ministers;
	}

	@JsonIgnore
	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

}
