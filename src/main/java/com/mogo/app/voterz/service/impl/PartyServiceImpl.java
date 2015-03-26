/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mogo.app.voterz.dao.PartyDao;
import com.mogo.app.voterz.dto.Party;
import com.mogo.app.voterz.service.PartyService;

/**
 * @author mogo
 *
 */
@Service("partyService")
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDao partyDao;
	
	
	/** 
	 * @see com.mogo.app.voterz.service.PartyService#getAllPartys()
	 *  
	 */
	
	public List<Party> getAllPartys() {
		return partyDao.findAll();
	}

	
	/** 
	 * @see com.mogo.app.voterz.service.PartyService#getPartyByName(java.lang.String)
	 *  
	 */
	public Party getPartyByName(String partyShortName) {
		return partyDao.findByName(partyShortName);
	}


	/** 
	 * @see com.mogo.app.voterz.service.PartyService#saveParty(java.lang.String, java.lang.String, java.lang.String)
	 *  
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveParty(String partyName, String partySymbol,
			String partyShortName) {
		try {
			partyDao.save(partyName, partySymbol, partyShortName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/** 
	 * @see com.mogo.app.voterz.service.PartyService#updateParty(java.lang.String, java.lang.String, java.lang.String)
	 *  
	 */
	public void updateParty(int partyId, String partyName, String partySymbol,
			String partyShortName) {
		try {
			partyDao.update(partyId, partyName, partySymbol, partyShortName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/** 
	 * @see com.mogo.app.voterz.service.PartyService#deletePartyByName(java.lang.String)
	 *  
	 */
	public void deletePartyByName(String partyShortName) {
		try {
			partyDao.deleteByName(partyShortName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
