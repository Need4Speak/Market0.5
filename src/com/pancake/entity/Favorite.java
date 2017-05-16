package com.pancake.entity;

import java.sql.Timestamp;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */

public class Favorite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5519186580026277662L;
	private Long favoriteId;
	private User userByBuyerId;
	private Good good;
	private User userBySellerId;
	private Timestamp creationTime;
	private String description;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** minimal constructor */
	public Favorite(User userByBuyerId, Good good, User userBySellerId) {
		this.userByBuyerId = userByBuyerId;
		this.good = good;
		this.userBySellerId = userBySellerId;
	}

	/** full constructor */
	public Favorite(User userByBuyerId, Good good, User userBySellerId, Timestamp creationTime, String description) {
		this.userByBuyerId = userByBuyerId;
		this.good = good;
		this.userBySellerId = userBySellerId;
		this.creationTime = creationTime;
		this.description = description;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", userByBuyerId=" + userByBuyerId + ", good=" + good
				+ ", userBySellerId=" + userBySellerId + ", creationTime=" + creationTime + ", description="
				+ description + "]";
	}

	public Long getFavoriteId() {
		return this.favoriteId;
	}

	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
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