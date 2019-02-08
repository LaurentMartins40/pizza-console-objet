package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;
/**
 * Classe des fonctions du menu ajout des pizzas qui implémente Menuservice
 * @author Diginamic
 *
 */
public class AjouterPizzaService extends MenuService{
	/**
	 * Fonction du menu ajout des pizzas
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Ajout d’une nouvelle pizza");
		
		// récupération des prametres de la nouvelle pizza
		System.out.println("saissisez le code");
		String codeNouveau = scanner.next();
		System.out.println("saissisez le nom(sans espace)");
		String labelNouveau = scanner.next();
		System.out.println("saissisez le prix");
		Double prixNouveau = Double.parseDouble(scanner.next());
		
		Pizza nouvellePizza = new Pizza(codeNouveau,labelNouveau,prixNouveau);
		pizzaDao.saveNewPizza(nouvellePizza);		
		
		
	}

	
	
	
	
}
