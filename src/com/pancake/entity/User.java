package com.pancake.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long userId;
	private School school;
	private String userName;
	private String password;
	private String phone;
	private String wechat;
	private String email;
	private String gender;
	private String userPhoto;
	private String userAddress;
	private Set leaveWordses = new HashSet(0);
	private Set favoritesForBuyerId = new HashSet(0);
	private Set favoritesForSellerId = new HashSet(0);
	private Set goodsForDelUserId = new HashSet(0);
	private Set goodsForOwnerId = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(School school, String userName, String password, String wechat, String email, String userAddress) {
		this.school = school;
		this.userName = userName;
		this.password = password;
		this.wechat = wechat;
		this.email = email;
		this.userAddress = userAddress;
	}

	/** full constructor */
	public User(School school, String userName, String password, String phone, String wechat, String email,
			String gender, String userPhoto, String userAddress, Set leaveWordses, Set favoritesForBuyerId,
			Set favoritesForSellerId, Set goodsForDelUserId, Set goodsForOwnerId) {
		this.school = school;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.wechat = wechat;
		this.email = email;
		this.gender = gender;
		this.userPhoto = userPhoto;
		this.userAddress = userAddress;
		this.leaveWordses = leaveWordses;
		this.favoritesForBuyerId = favoritesForBuyerId;
		this.favoritesForSellerId = favoritesForSellerId;
		this.goodsForDelUserId = goodsForDelUserId;
		this.goodsForOwnerId = goodsForOwnerId;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Set getLeaveWordses() {
		return this.leaveWordses;
	}

	public void setLeaveWordses(Set leaveWordses) {
		this.leaveWordses = leaveWordses;
	}

	public Set getFavoritesForBuyerId() {
		return this.favoritesForBuyerId;
	}

	public void setFavoritesForBuyerId(Set favoritesForBuyerId) {
		this.favoritesForBuyerId = favoritesForBuyerId;
	}

	public Set getFavoritesForSellerId() {
		return this.favoritesForSellerId;
	}

	public void setFavoritesForSellerId(Set favoritesForSellerId) {
		this.favoritesForSellerId = favoritesForSellerId;
	}

	public Set getGoodsForDelUserId() {
		return this.goodsForDelUserId;
	}

	public void setGoodsForDelUserId(Set goodsForDelUserId) {
		this.goodsForDelUserId = goodsForDelUserId;
	}

	public Set getGoodsForOwnerId() {
		return this.goodsForOwnerId;
	}

	public void setGoodsForOwnerId(Set goodsForOwnerId) {
		this.goodsForOwnerId = goodsForOwnerId;
	}

}