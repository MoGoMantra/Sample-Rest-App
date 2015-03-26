/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.service;

import java.util.List;

import com.mogo.app.voterz.dto.Party;

/**
 * @author mogo
 * 
 */
public interface PartyService {

	
	public List<Party> getAllPartys();
	
	public Party getPartyByName(String partyShortName);
	
	public void saveParty(String partyName, String partySymbol, String partyShortName);
	
	public void updateParty(int partyId, String partyName, String partySymbol, String partyShortName);
	
	public void deletePartyByName(String partyShortName);
}
