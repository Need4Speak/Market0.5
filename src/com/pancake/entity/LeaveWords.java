package com.pancake.entity;

/**
 * LeaveWords entity. @author MyEclipse Persistence Tools
 */

public class LeaveWords implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8499405801904816107L;
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

//	@Override
//	public String toString() {
//		return "LeaveWords [id=" + id + ", good=" + good + ", user=" + user + ", content=" + content + "]";
//	}

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