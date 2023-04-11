package com.e2eTest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTest.automation.utils.Setup;

public class TodoListPage {

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	public static WebElement email;
	
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public static WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Déconnexion']")
	public static WebElement deconnexion;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Tâches']")
	public static WebElement taches;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[1]")
	public static WebElement typeTaches;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[2]")
	public static WebElement descriptionTaches;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	public static WebElement ajoutTache;
	
	@FindBy(how = How.XPATH, using = "//li[@class='list-group-item d-flex justify-content-between']")
	public static WebElement localStorage;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='alert alert-danger'])[1]")
	public static WebElement allertMsg;
	
	
	public TodoListPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
}
