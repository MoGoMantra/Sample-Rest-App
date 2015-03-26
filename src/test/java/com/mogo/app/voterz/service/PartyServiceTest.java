/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 16, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mogo.app.voterz.dto.Party;

/**
 * @author mogo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class PartyServiceTest {
	
	@Autowired
	private PartyService partyService;
	
	@Test
	public void getAllPartys() {
		List<Party> partys = partyService.getAllPartys();
		Assert.assertNotNull(partys);
	}
	

}
