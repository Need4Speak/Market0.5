package com.pancake.dao.impl;

import org.junit.Test;

import com.pancake.entity.LeaveWords;

public class LeaveWordsDaoImplTest {

	@Test
	public void testFindById() {
		LeaveWordsDaoImpl lwdi = new LeaveWordsDaoImpl();
		LeaveWords lw = lwdi.findById(0);
		System.out.println(lw);
	}

}
