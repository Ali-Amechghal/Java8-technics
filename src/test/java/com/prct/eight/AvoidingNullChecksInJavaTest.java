package com.prct.eight;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.prct.eight.model.Account;
import com.prct.eight.model.ReadMe;
import com.prct.eight.model.Repository;

public class AvoidingNullChecksInJavaTest {

	private final String readMeContent = "#Null Checks In Java 8";
	private final String defaultReadMEContent = "Empty ReadMe.md";
	
	private Account account;
	private Repository repo;
	private ReadMe readMe;
	
	@Before
	public void setUp() {
	
		this.account = new Account();
		this.repo = new Repository();
		this.readMe = new ReadMe();

	}
	
	@Test
	public void getReadMeContentBeforeJShouldReturnNull() {
		assertNull(AvoidingNullChecksInJava8.getReadMeContentBeforeJ8(account));
	}
	
	@Test
	public void getReadMeContentBeforeJShouldReturnNotNullValue() {
		readMe.setContent(readMeContent);
		repo.setReadMe(readMe);
		account.setRepository(repo);
		assertNotNull(AvoidingNullChecksInJava8.getReadMeContentBeforeJ8(account));
		assertEquals(readMeContent, AvoidingNullChecksInJava8.getReadMeContentBeforeJ8(account));
	}
	
	@Test
	public void getReadMeContentWithJ8ShouldReturnDefaultValue() {
		assertNull(AvoidingNullChecksInJava8.getReadMeContentBeforeJ8(account));
		assertEquals(defaultReadMEContent, AvoidingNullChecksInJava8.getReadMeContentWithJ8(account));;
	}
	
}
