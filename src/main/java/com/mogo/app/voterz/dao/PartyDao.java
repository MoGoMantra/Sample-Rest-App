/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.dao;

import java.util.List;

import com.mogo.app.voterz.dto.Party;

/**
 * @author mogo
 * 
 */
public interface PartyDao {

	public Party findById(int partyId);

	public Party findByName(String partyShortName);
	
	public List<Party> findAll();
	
	public void save(String partyName, String partySymbol,
			String partyShortName) throws Exception;

	public void update(int partyId, String partyName, String partySymbol,
			String partyShortName) throws Exception;

	public void saveOrUpdate(int partyId, String partyName,
			String partySymbol, String partyShortName) throws Exception;

	public void delete(int partyId) throws Exception;
	
	public void deleteByName(String partyShortName) throws Exception;

}
