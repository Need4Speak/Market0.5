package com.pancake.entity;

/**
 * LeaveWords entity. @author MyEclipse Persistence Tools
 */

public class LeaveWords implements java.io.Serializable {

	// Fields

	private Integer id;
	private Good good;
	private User user;
	private String content;

	// Constructors

	/** default constructor */
	public LeaveWords() {
	}

	/** full constructor */
	public LeaveWords(Good good, User user, String content) {
		this.good = good;
		this.user = user;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}