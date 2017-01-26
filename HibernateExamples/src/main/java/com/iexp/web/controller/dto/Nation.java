package com.iexp.web.controller.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="NATION")
public class Nation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nation_sequence")
	@SequenceGenerator(name = "nation_sequence", sequenceName = "nation_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name="NATION_ID")
	Long nationId;
	
	@Column(name="NATION_NAME", unique=true)
	String nationName;
	
	@OneToOne(mappedBy = "nation", cascade = CascadeType.ALL)
	PrimeMinister primeminister;

	@OneToMany(mappedBy="nation", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)	
	List<Party> parties = new ArrayList<Party>();

	
	@Temporal(TemporalType.DATE)
	Date dateObject;
	
	public Date getDateObject() {
		return dateObject;
	}

	public void setDateObject(Date date) {
		this.dateObject = date;
	}


	public Long getNationId() {
		return nationId;
	}

	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public PrimeMinister getPrimeminister() {
		return primeminister;
	}

	public void setPrimeminister(PrimeMinister primeminister) {
		this.primeminister = primeminister;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
}
