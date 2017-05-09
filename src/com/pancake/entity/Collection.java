package com.pancake.entity;

import java.sql.Timestamp;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection implements java.io.Serializable {

	// Fields

	private Long collectionId;
	private User userByBuyerId;
	private Good good;
	private User userBySellerId;
	private Timestamp creationTime;
	private String description;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** minimal constructor */
	public Collection(User userByBuyerId, Good good, User userBySellerId) {
		this.userByBuyerId = userByBuyerId;
		this.good = good;
		this.userBySellerId = userBySellerId;
	}

	/** full constructor */
	public Collection(User userByBuyerId, Good good, User userBySellerId, Timestamp creationTime, String description) {
		this.userByBuyerId = userByBuyerId;
		this.good = good;
		this.userBySellerId = userBySellerId;
		this.creationTime = creationTime;
		this.description = description;
	}

	// Property accessors

	public Long getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public User getUserByBuyerId() {
		return this.userByBuyerId;
	}

	public void setUserByBuyerId(User userByBuyerId) {
		this.userByBuyerId = userByBuyerId;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public User getUserBySellerId() {
		return this.userBySellerId;
	}

	public void setUserBySellerId(User userBySellerId) {
		this.userBySellerId = userBySellerId;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}