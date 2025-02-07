package org.Pages;

import java.util.ArrayList;
import java.util.List;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProtienPage extends BasePage {

	public ProtienPage(WebDriver driver) {
		super(driver);
	}

	private final By Title = By.xpath("//h1[@id='responsive-product-list-title']");

	private final By listofItems = By.xpath("//ul[@class='productListProducts_products']");

	public String verifyProtienPageTitle() {
		String pageTitle =	wait.until(ExpectedConditions.visibilityOfElementLocated(Title)).getText();
		return pageTitle;
	}


	public List<String> getItemNames() {
	    List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listofItems));
	    List<String> itemNames = new ArrayList<>();  // Use List<String> instead of List<WebElement>
	    
	    for (WebElement element : elements) {
	        itemNames.add(element.getText().trim());  // Now this is valid
	    }
	    
	    return itemNames;
	}

	
	public Boolean verifyCartProducts(String ProductName) {
	    return getItemNames().stream()
	            .anyMatch(product -> product.equalsIgnoreCase(ProductName)); // Directly compare strings
	}

	
	

}
