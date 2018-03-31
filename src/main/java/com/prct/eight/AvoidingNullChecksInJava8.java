package com.prct.eight;

import java.util.Optional;

import com.prct.eight.model.Account;
import com.prct.eight.model.ReadMe;
import com.prct.eight.model.Repository;

/**
 * 
 * describes a couple of techniques how to prevent writing needless null 
 * checks by utilizing new features of Java 8 like lambda expressions.
 * 
 * @author Ali
 *
 */
public class AvoidingNullChecksInJava8 {

	public static String getReadMeContentBeforeJ8(Account gitAccount) {
		// huge null control juste to get a content value
		if(gitAccount != null && gitAccount.getRepository()!= null && gitAccount.getRepository().getReadMe() != null)
			return gitAccount.getRepository().getReadMe().getContent();
		
		return null;
	}
	/**
	 * We can handle null pointer exception using a map function of Optional
	 * the map method will return an empty optional if the given object is null
	 * 
	 * @param gitAccount
	 * @return
	 */
	public  static String getReadMeContentWithJ8(Account gitAccount) {
	
		return Optional.of(gitAccount)
			.map(account -> account.getRepository())
			.map(repo -> repo.getReadMe())
			.map(readme -> readme.getContent()).orElseGet(() -> "Empty ReadMe.md");
		
	}
	
	/**
	 * Same as getReadMeContentWithJ8
	 * With  a method reference
	 * @param gitAccount
	 * @return
	 */
	public  static String getReadMeContentWithJ8MR(Account gitAccount) {
		
		return Optional.of(gitAccount)
			.map(Account::getRepository)
			.map(Repository::getReadMe)
			.map(ReadMe::getContent).orElseGet(() -> "Empty ReadMe.md");
		
	}
}
