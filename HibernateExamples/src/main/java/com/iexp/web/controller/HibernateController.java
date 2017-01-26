package com.iexp.web.controller;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iexp.web.controller.dto.Minister;
import com.iexp.web.controller.dto.Nation;
import com.iexp.web.controller.dto.Party;
import com.iexp.web.controller.dto.PrimeMinister;

@Controller
public class HibernateController {

	@Autowired
	SessionFactory SessionFactory;

	@Transactional
	@RequestMapping(value="/perform")
	@ResponseBody
	public String testRelationship(){
	Session session =	SessionFactory.getCurrentSession();
	
	Nation nation = new Nation();
	nation.setNationName("INDIA");
	Party partiy1 = new Party();
	partiy1.setNation(nation);
	partiy1.setPartyName("BJP");
	Party partiy2 = new Party();
	partiy2.setNation(nation);
	partiy2.setPartyName("Congress");
	PrimeMinister primeminister = new PrimeMinister();
	primeminister.setNation(nation);
	primeminister.setName("Shri Narendra Modi");
	Minister minister1 = new Minister();
	minister1.setMinisterName("Piyus");
	minister1.setPrimeminister(primeminister);
	Minister minister2 = new Minister();
	minister2.setMinisterName("N G");
	minister2.setPrimeminister(primeminister);
	primeminister.getMinisters().add(minister1);
	primeminister.getMinisters().add(minister2);
	nation.setPrimeminister(primeminister);
	nation.getParties().add(partiy1);
	nation.getParties().add(partiy2);
    nation.setDateObject(new Date());
	session.save(nation);

	
	
	
	Nation nation1 = new Nation();
	nation1.setNationName("US");
	Party partiy12 = new Party();
	partiy12.setNation(nation1);
	partiy12.setPartyName("DEMOCRATIC");
	Party partiy22 = new Party();
	partiy22.setNation(nation1);
	partiy22.setPartyName("REPUBLIC");
	PrimeMinister primeminister1 = new PrimeMinister();
	primeminister1.setNation(nation1);
	primeminister1.setName("Mr Donald Tump");
	Minister minister12 = new Minister();
	minister12.setMinisterName("XY");
	minister12.setPrimeminister(primeminister1);
	Minister minister22 = new Minister();
	minister22.setMinisterName("NGGGG");
	minister22.setPrimeminister(primeminister1);
	
	primeminister1.getMinisters().add(minister12);
	primeminister1.getMinisters().add(minister22);
	nation1.setPrimeminister(primeminister1);
	nation1.getParties().add(partiy12);
	nation1.getParties().add(partiy22);
    nation1.setDateObject(new Date());
	session.save(nation1);

	return "testing";
	}
	
	@Transactional
	@RequestMapping(value="/nation/{nationName}")
	@ResponseBody
	public String getNationObject(@PathVariable("nationName") String nationName){
		Session session = SessionFactory.getCurrentSession();
		System.out.println(nationName);
		Criteria nationCriteria = session.createCriteria(Nation.class);
		nationCriteria.add(Restrictions.eq("nationName", nationName));
		Nation nationObject = (Nation)nationCriteria.uniqueResult();
		nationObject.getPrimeminister().getMinisters();
		nationObject.getParties();

		return "good";
	}
	
}
