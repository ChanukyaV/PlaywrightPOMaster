package com.fb.util;

import com.fb.SUT;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class WaitHandler {
	
	private Page page = null;
	
	public WaitHandler(SUT testEnv) {
		this.page = testEnv.getPage();
	}

	public void waitForSelector(String selector) {
		this.page.waitForSelector(selector);
	}
	
	public void waitForSelector(String selector, WaitForSelectorOptions waitOptons) {
		this.page.waitForSelector(selector, waitOptons);
	}
	
	public void waitForPageLoad() {
		this.page.waitForLoadState();
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
