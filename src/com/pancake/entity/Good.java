package com.pancake.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2601422599566748979L;
	private Long goodId;
	private User userByOwnerId;
	private Classification classification;
	private User userByDelUserId;
	private String name;
	private Double price;
	private String pictures;
	private Double freight;
	private String description;
	private Integer status;
	private Timestamp addTime;
	private Timestamp delTime;
	private Timestamp comleteTime;
	private Set leaveWordses = new HashSet(0);
	private Set favorites = new HashSet(0);

	// Constructors

	/** default constructor */
	public Good() {
	}

	/** minimal constructor */
	public Good(Classification classification, String name, Double price, String pictures, Timestamp addTime) {
		this.classification = classification;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.addTime = addTime;
	}

	public Good(Classification classification, String name, Double price, String pictures, Timestamp addTime, User userByOwnerId) {
		this.classification = classification;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.addTime = addTime;
		this.userByOwnerId = userByOwnerId;
	}
	
	public Good(Classification classification, String name, Double price, String pictures, Timestamp addTime, User userByOwnerId, Integer status, Double freight) {
		this.classification = classification;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.addTime = addTime;
		this.userByOwnerId = userByOwnerId;
		this.status = status;
		this.freight = freight;
	}
	
	
	public Good(User userByOwnerId, Classification classification, String name, Double price,
			String pictures, Double freight, String description, Integer status, Timestamp addTime) {
		super();
		this.goodId = goodId;
		this.userByOwnerId = userByOwnerId;
		this.classification = classification;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.description = description;
		this.status = status;
		this.addTime = addTime;
	}

	/** full constructor */
	public Good(User userByOwnerId, Classification classification, User userByDelUserId, String name, Double price,
			String pictures, Double freight, String description, Integer status, Timestamp addTime, Timestamp delTime,
			Timestamp comleteTime, Set leaveWordses, Set favorites) {
		this.userByOwnerId = userByOwnerId;
		this.classification = classification;
		this.userByDelUserId = userByDelUserId;
		this.name = name;
		this.price = price;
		this.pictures = pictures;
		this.freight = freight;
		this.description = description;
		this.status = status;
		this.addTime = addTime;
		this.delTime = delTime;
		this.comleteTime = comleteTime;
		this.leaveWordses = leaveWordses;
		this.favorites = favorites;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Good name: " + this.name;
	}

	public Long getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}

	public User getUserByOwnerId() {
		return this.userByOwnerId;
	}

	public void setUserByOwnerId(User userByOwnerId) {
		this.userByOwnerId = userByOwnerId;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public User getUserByDelUserId() {
		return this.userByDelUserId;
	}

	public void setUserByDelUserId(User userByDelUserId) {
		this.userByDelUserId = userByDelUserId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getDelTime() {
		return this.delTime;
	}

	public void setDelTime(Timestamp delTime) {
		this.delTime = delTime;
	}

	public Timestamp getComleteTime() {
		return this.comleteTime;
	}

	public void setComleteTime(Timestamp comleteTime) {
		this.comleteTime = comleteTime;
	}

	public Set getLeaveWordses() {
		return this.leaveWordses;
	}

	public void setLeaveWordses(Set leaveWordses) {
		this.leaveWordses = leaveWordses;
	}

	public Set getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set favorites) {
		this.favorites = favorites;
	}

}