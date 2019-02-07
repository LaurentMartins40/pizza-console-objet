package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

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
