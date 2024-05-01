package com.fb.pages;

import com.fb.SUT;
import com.fb.util.WaitHandler;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class BasePage {
	
	protected SUT testEnv = null;
	public Page page = null;
	protected WaitHandler waitUtil = null;
	
	public BasePage(SUT testEnv) {
		this.testEnv = testEnv;
		this.page = testEnv.getPage();
		this.waitUtil = testEnv.handleWaits();
	}

	public Locator findElement(String locator){
		page.waitForSelector(locator);
		return page.locator(locator);
	}
	
	public void pressEnter() {
		page.keyboard().press("Enter");
	}
	
	public void type(String locator, String text){
		page.waitForSelector(locator);
		page.fill(locator, text);
	}
	
	public void wait(int seconds) {
		waitUtil.sleep(seconds);
	}
	
	public void click(String locator){
		findElement(locator).click();
		testEnv.handleWaits().waitForPageLoad();
	}

	public void forceClick(String locator){
		findElement(locator).dispatchEvent("click");
		testEnv.handleWaits().waitForPageLoad();
	}
	
	public boolean verifyElement(String locator) {
		return page.isVisible(locator);
	}
}
