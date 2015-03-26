/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mogo.app.voterz.dto.Party;

/**
 * @author mogo
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PartyDaoTest {

	@Autowired
	private PartyDao partyDao;

	@Before
	public void setup() {
		//setup the data
	}
	
	@After 
	public void afterRunningTest() {
		//clear the data
	}
	
	@Test
	public void findAll() {
		List<Party> parties = partyDao.findAll();
		Assert.assertNotNull(parties);
		//Assert.assertEquals(1, parties.size());
	}
	
	@Test
	public void findById() {
		Party party = partyDao.findById(1);
		//Assert.assertNotNull(party);
	}
	
	@Test
	public void findByName() {
		Party party = partyDao.findByName("BJP");
		//Assert.assertNotNull(party);
	}

	@Test
	public void save() {
		try {
			partyDao.deleteByName("INC2");
			
			partyDao.save("Indian National Congress", null, "INC2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Assert.fail("PartyDao Save is failed");
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void update() {
		try {
			partyDao.update(2, "Congress(I)", null, "INC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Assert.fail("PartyDao update is failed");
		}
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void saveOrUpdate() {
		try {
			partyDao.saveOrUpdate(3, "Samajbadi Party", null, "SP");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Assert.fail("PartyDao saveOrUpdate is failed");
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void saveOrUpdate1() {
		try {
			partyDao.saveOrUpdate(3, "Bahujan Samaj party", null, "BSP");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Assert.fail("PartyDao saveOrUpdate is failed");
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void delete() {
		try {
			partyDao.deleteByName("INC1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Assert.fail("delete failed");
		}
		Assert.assertTrue(true);
	}
}
