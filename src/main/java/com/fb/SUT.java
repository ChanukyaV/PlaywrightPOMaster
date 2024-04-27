package com.fb;

import com.fb.util.WaitHandler;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author Chanukya Vempati
 * @since 26 Apr 2024
 */
public class SUT{
	
	private Configuration config = null;
	private FbBrowser pzBrowser = null;
	private WaitHandler waitHandler = null;
	private Browser browser = null;
	private BrowserContext context = null;
	private Page page = null;
	
	public SUT() {
		initializeDriver();
	}
	
	public void terminate(){
		context.close();
		browser.close();
	}

	private void initializeDriver() {
		String browserName = getConfiguration().getBrowserName();
		Playwright playwright = Playwright.create();
		boolean headless = getConfiguration().getHeadlessMode();
		LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless);
		if (browserName.equals("chrome")) {
			browser = playwright.chromium().launch(launchOptions);
		} else if (browserName.equals("firefox")) {
			browser = playwright.firefox().launch();
		} else if (browserName.equals("webkit")) {
			browser = playwright.webkit().launch();
		}
		context = browser.newContext();
		page = context.newPage();
		page.setDefaultTimeout(90000);
	}

	public FbBrowser getBrowser() {
		if(pzBrowser==null){
			pzBrowser = new FbBrowser(this);
		}
		return pzBrowser;
	}

	public Configuration getConfiguration() {
		if(config == null){
			config = new Configuration();
		}
		return config;
	}
	
	public WaitHandler handleWaits(){
		if(waitHandler == null){
			waitHandler = new WaitHandler(this);
		}
		return waitHandler;
	}
	
	public Page getPage(){
		return page;
	}
}
