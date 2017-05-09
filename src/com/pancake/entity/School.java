package com.pancake.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer schoolId;
	private String schoolName;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public School() {
	}

	/** full constructor */
	public School(String schoolName, Set users) {
		this.schoolName = schoolName;
		this.users = users;
	}

	// Property accessors

	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}