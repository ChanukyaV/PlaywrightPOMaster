package com.fb;

import com.fb.pages.FbHomePage;
import com.microsoft.playwright.Page;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class FbBrowser{
	
	private SUT testEnv = null;
	private Page page = null;
	private Configuration config = null;
	
	public FbBrowser(SUT testEnv) {
		this.testEnv = testEnv;
		this.page = testEnv.getPage();
		this.config = testEnv.getConfiguration();
	}

	public void open() {
		open(config.getInstanceURL());
		testEnv.handleWaits().waitForPageLoad();
	}

	public void close() {
		page.close();
	}
	
	public FbHomePage login(String username, String password) {
		page.fill("#email", username);
		page.fill("#pass", password);
		page.click("button[name='login']");
		page.waitForSelector("input[aria-label='Search Facebook']");
		return new FbHomePage(testEnv);
	}
	
	public FbHomePage login() {
		return login(config.getEmail(), config.getPassword());
	}

	public void open(String url) {
		page.navigate(url);
	}

}
