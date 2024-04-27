package com.fb.pages;

import com.fb.SUT;

/**
 * @author Chanukya Vempati
 * @since 27 Apr 2024
 */
public class FbHomePage extends BasePage {

	public FbHomePage(SUT testEnv) {
		super(testEnv);
	}
	
	public void search(String keyword) {
		type("input[placeholder='Search Facebook']", keyword);
		pressEnter();
		waitUtil.waitForSelector("//span[text()='Join']");
	}

}
