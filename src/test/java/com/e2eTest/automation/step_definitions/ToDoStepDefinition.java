package com.e2eTest.automation.step_definitions;

import com.e2eTest.automation.page_objects.TodoListPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToDoStepDefinition {

	public TodoListPage todoList;
	public SeleniumUtils seleniumUtils;
	public Validations validations;
	public ConfigFileReader configFileReader;

	public ToDoStepDefinition() {
		seleniumUtils = new SeleniumUtils();
		validations = new Validations();
		configFileReader = new ConfigFileReader();
		todoList = new TodoListPage();
	}

	@Given("Je me connecte sur l application TodoList")
	public void jeMeConnecteSurLApplicationTodoList() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
	}

	@Then("les liens Taches et deconnexion apparaissent")
	public void lesLiensTachesEtDeconnexionApparaissent() {
		validations.isElementEnabled(TodoListPage.deconnexion);
		// validations.assertTrue(TodoListPage.deconnexion,
		// configFileReader.getProperties("home.btn"));

	}

	@Then("lorsque les identifiants de connexion {string} et {string} sont incorrects,un message d alerte s affiche {string}")
	public void lorsqueLesIdentifiantsDeConnexionEtSontIncorrectsUnMessageDAllerteSAffiche(String email,
			String password, String alerte) {
		seleniumUtils.writeText(TodoListPage.email, email);
		seleniumUtils.writeText(TodoListPage.password, password);
		seleniumUtils.click(TodoListPage.btnSubmit);
		String Err = TodoListPage.allertMsg.getText();
		validations.assertEquals(TodoListPage.allertMsg, Err);

	}

	@Then("les boutons connexion et ajout de taches ne sont pas active si tous les champs ne sont pas remplis")
	public void lesBoutonsConnexionEtAjoutDeTachesNeSontPasActiveSiTousLesChampsNeSontPasRemplis() {
		validations.isElementEnabled(TodoListPage.btnSubmit);
		validations.isElementPresentFalse(TodoListPage.ajoutTache);
	}

	@When("Je saisis l email {string}")
	public void jeSaisisLEmail(String email) {
		seleniumUtils.clearField(TodoListPage.email);
		seleniumUtils.writeText(TodoListPage.email, email);
	}

	@When("Je saisis le Password {string}")
	public void jeSaisisLePassword(String psw) {
		seleniumUtils.clearField(TodoListPage.password);
		seleniumUtils.writeText(TodoListPage.password, psw);
	}

	@When("Je clique sur le bouton submit")
	public void JeCliqueSurLeBoutonSubmit() {
		seleniumUtils.click(TodoListPage.btnSubmit);
	}

	@When("J ajoute une tâche {string} {string} {string} {string} {string} {string}")
	public void jAjouteUneTâche(String tache1, String des1, String tache2, String des2, String tache3, String des3) {
		seleniumUtils.writeText(TodoListPage.typeTaches, tache1);
		seleniumUtils.writeText(TodoListPage.descriptionTaches, des1);
		seleniumUtils.click(TodoListPage.ajoutTache);
		seleniumUtils.writeText(TodoListPage.typeTaches, tache2);
		seleniumUtils.writeText(TodoListPage.descriptionTaches, des2);
		seleniumUtils.click(TodoListPage.ajoutTache);
		seleniumUtils.writeText(TodoListPage.typeTaches, tache3);
		seleniumUtils.writeText(TodoListPage.descriptionTaches, des3);
		seleniumUtils.click(TodoListPage.ajoutTache);
	}

	@Then("les données dans le localStorage sont mises à jours {string}")
	public void lesDonnéesDansLeLocalStorageSontMisesÀJours(String Regression) throws InterruptedException {
		// Thread.sleep(3000);
		validations.isElementEnabled(TodoListPage.localStorage);
		validations.assertTrue(TodoListPage.localStorage, Regression);
	}

}
