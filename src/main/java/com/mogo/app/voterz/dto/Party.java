/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 15, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.app.voterz.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mogo
 *
 */

@Entity
@Table(name = "PARTY")
public class Party implements java.io.Serializable {

    private static final long serialVersionUID = 7440297955003302414L;

    @GeneratedValue
	@Id
    @Column(name="party_id")
    private int partyId;

    @Column(name="party_name", nullable = false, length=200)
    private String partyName;

    @Column(name="party_symbol", nullable = true)
    private String partySymbol;

    @Column(name="party_short_name", length=10)
    private String partyShortName;

	/**
	 * 
	 */
	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param partyId
	 * @param partyName
	 * @param partySymbol
	 * @param partyShortName
	 */
	public Party(String partyName, String partySymbol,
			String partyShortName) {
		super();
		this.partyName = partyName;
		this.partySymbol = partySymbol;
		this.partyShortName = partyShortName;
	}

	/**
	 * @return the partyId
	 */
	public int getPartyId() {
		return partyId;
	}

	/**
	 * @param partyId the partyId to set
	 */
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the partySymbol
	 */
	public String getPartySymbol() {
		return partySymbol;
	}

	/**
	 * @param partySymbol the partySymbol to set
	 */
	public void setPartySymbol(String partySymbol) {
		this.partySymbol = partySymbol;
	}

	/**
	 * @return the partyShortName
	 */
	public String getPartyShortName() {
		return partyShortName;
	}

	/**
	 * @param partyShortName the partyShortName to set
	 */
	public void setPartyShortName(String partyShortName) {
		this.partyShortName = partyShortName;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Party [partyId=" + partyId + ", partyName=" + partyName
				+ ", partySymbol=" + partySymbol + ", partyShortName="
				+ partyShortName + "]";
	}
    
}
