@todolist
Feature: Entretient sur l application TodoList
  Je souhaite tester un ensemble des fonctionnalites sur l application Todo List

  @todolistQA
  Scenario: Entretient sur l application TodoList
    Given Je me connecte sur l application TodoList
    Then les liens Taches et deconnexion apparaissent
    Then lorsque les identifiants de connexion "AYtest@test.fr" et "test" sont incorrects,un message d alerte s affiche "Désolé, les identifiants sont incorrects."
    Then les boutons connexion et ajout de taches ne sont pas active si tous les champs ne sont pas remplis 
    When Je saisis l email "test@test.com"
    And Je saisis le Password "test"
    And Je clique sur le bouton submit
    When J ajoute une tâche "Regression" "REG" "Test" "TEST" "Cahier de test" "CT"
    Then les données dans le localStorage sont mises à jours "Regression"
