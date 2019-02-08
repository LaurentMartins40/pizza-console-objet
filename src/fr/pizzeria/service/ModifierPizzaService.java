package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * Classe des fonctions du menu modification des pizzas qui implémente Menuservice
 * @author Diginamic
 *
 */
public class ModifierPizzaService extends MenuService{
	/**
	 * Fonction du menu modification des pizzas
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) throws UpdatePizzaException{
		String codeModif = "";
		do{
			System.out.println("Mise à jour d’une pizza");
			System.out.println("quelle pizza modifier");
			codeModif = scanner.next();
			if(!pizzaDao.pizzaExists(codeModif)){
				throw new UpdatePizzaException("la pizza n'existe pas");
			}
		}while(!pizzaDao.pizzaExists(codeModif));
		
		
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
