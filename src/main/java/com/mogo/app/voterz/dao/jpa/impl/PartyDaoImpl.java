/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.dao.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mogo.app.voterz.dao.PartyDao;
import com.mogo.app.voterz.dto.Party;

/**
 * @author mogo
 * 
 */
@Repository("partyDao")
public class PartyDaoImpl implements PartyDao {

	// Injected database connection:
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#findParty(int)
	 * 
	 */
	public Party findById(int partyId) {
		try {
			TypedQuery<Party> query = entityManager.createNamedQuery(
					"Party.findById", Party.class);
			query.setParameter("partyId", partyId);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
	/** 
	 * @see com.mogo.app.voterz.dao.PartyDao#findByName(java.lang.String)
	 *  
	 */
	public Party findByName(String partyShortName) {
		try {
			TypedQuery<Party> query = entityManager.createNamedQuery(
					"Party.findByName", Party.class);
			query.setParameter("partyShortName", partyShortName);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}	}

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#findAll()
	 * 
	 */
	public List<Party> findAll() {
		TypedQuery<Party> query = entityManager.createNamedQuery(
				"Party.findAll", Party.class);
		return query.getResultList();
	}

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#saveParty(int, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 * 
	 */
	// @Transactional
	public void save(String partyName, String partySymbol,
			String partyShortName) throws Exception {
		Party party = new Party(partyName, partySymbol, partyShortName);
		entityManager.persist(party);

	}

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#updateParty(int, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 * 
	 */
	public void update(int partyId, String partyName, String partySymbol,
			String partyShortName) throws Exception {
		Party party = this.findByName(partyShortName);
		party.setPartyName(partyName);
		party.setPartySymbol(partySymbol);
		party.setPartyShortName(partyShortName);
		entityManager.merge(party);
	}

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#saveOrUpdateParty(int,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 * 
	 */
	public void saveOrUpdate(int partyId, String partyName, String partySymbol,
			String partyShortName) throws Exception {
		Party party = this.findByName(partyShortName);
		if (party == null) {
			this.save(partyName, partySymbol, partyShortName);
		} else {
			party.setPartyName(partyName);
			party.setPartySymbol(partySymbol);
			party.setPartyShortName(partyShortName);
			entityManager.merge(party);
		}
	}

	/**
	 * @see com.mogo.app.voterz.dao.PartyDao#deleteParty(int)
	 * 
	 */
	public void delete(int partyId) throws Exception {
		Party party = this.findById(partyId);
		if (party == null) {
			entityManager.remove(party);
		}
	}


	/** 
	 * @see com.mogo.app.voterz.dao.PartyDao#deleteByName(java.lang.String)
	 *  
	 */
	public void deleteByName(String partyShortName) throws Exception {
		Party party = this.findByName(partyShortName);
		if (party == null) {
			entityManager.remove(party);
		}		
	}
	
	
	
}
