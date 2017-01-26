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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PARTY_TABLE")
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "p_sequence")
	@SequenceGenerator(name = "p_sequence", sequenceName = "party_sequence_db",allocationSize=1)	
	Long partyId;
	
	@Column(name="PARTY_NAME")
	String partyName;

	@ManyToOne
	@JoinColumn(name = "NATION_ID")
	@JsonIgnore
	Nation nation;
	
	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/*@JsonIgnore
	public Nation getNation() {
		return nation;
	}*/

	public void setNation(Nation nation) {
		this.nation = nation;
	}

}
