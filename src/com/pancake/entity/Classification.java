package com.pancake.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classification entity. @author MyEclipse Persistence Tools
 */

public class Classification implements java.io.Serializable {

	// Fields

	private Integer classificationId;
	private String classificationName;
	private Set goods = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classification() {
	}

	/** minimal constructor */
	public Classification(String classificationName) {
		this.classificationName = classificationName;
	}

	/** full constructor */
	public Classification(String classificationName, Set goods) {
		this.classificationName = classificationName;
		this.goods = goods;
	}

	// Property accessors

	public Integer getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationName() {
		return this.classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public Set getGoods() {
		return this.goods;
	}

	public void setGoods(Set goods) {
		this.goods = goods;
	}

}