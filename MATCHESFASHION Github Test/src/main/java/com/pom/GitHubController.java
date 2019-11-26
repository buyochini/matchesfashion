package com.pom;

import org.openqa.selenium.By;

public class GitHubController {

	public static By readmeFile = By.id("04c6e90faac2675aa89e2176d2eec7d8-0d39b3770b5d4945da412c8315a6ec6bd047d35d");
	public static By enterSearchValue = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/div/div/form/label/input[1]");
	public static By search = By.id("jump-to-suggestion-search-global");
	public static By searchResult = By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div/div[1]/h3");
	public static By firstSearchItem = By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div/ul/li[1]/div[1]/h3/a");
}