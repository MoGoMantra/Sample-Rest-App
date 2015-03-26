/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 16, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogo.app.voterz.dto.Party;
import com.mogo.app.voterz.service.PartyService;

/**
 * @author mogo
 * 
 */
@Controller
@RequestMapping("/partyservice")
public class PartyServiceController {

	@Autowired
	PartyService partyService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Party findParty(@PathVariable("id") String partyShortName) {
		return partyService.getPartyByName(partyShortName);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Party> findAllParty() {
            return partyService.getAllPartys();
    }

	@RequestMapping(value = "/{id}/{partyName}/{partySymbol}", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String saveParty(@PathVariable("id") String partyShortName,
			@PathVariable String partyName, @PathVariable String partySymbol)
			throws Exception {
		partyService.saveParty(partyName, partySymbol, partyShortName);
		return "redirect:/rest/partyService/" + partyShortName;
	}

	@RequestMapping(value = "/{id}/{partyName}/{partySymbol}/{partyShortName}", method = RequestMethod.PUT)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String updateParty(@PathVariable("id") int partyId,
			@PathVariable String partyName, @PathVariable String partySymbol,
			@PathVariable("partyShortName") String partyShortName)
			throws Exception {
		partyService.updateParty(partyId, partyName, partySymbol,
				partyShortName);
		return "redirect:/rest/partyService/" + partyShortName;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@ResponseBody
	public String deleteParty(@PathVariable("id") String partyShortName)
			throws Exception {
		partyService.deletePartyByName(partyShortName);
		return "OK";
	}

}
