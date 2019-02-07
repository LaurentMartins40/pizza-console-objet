package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Mise à jour d’une pizza");
		System.out.println("quelle pizza modifier");
		String codeModif = scanner.next();
		
		
		System.out.println("saissisez le nouveau code");
		String modifCode = scanner.next();
		System.out.println("saissisez le nouveau nom(sans espace)");
		String modifLabel = scanner.next();
		System.out.println("saissisez le nouveau prix");
		Double modifPrix = Double.parseDouble(scanner.next());
		
		Pizza tempPizza = new Pizza(modifCode,modifLabel,modifPrix);
		pizzaDao.updatePizza(codeModif,tempPizza);
		 
		
	}

}
