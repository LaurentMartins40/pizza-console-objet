package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * Classe des fonctions du menu supression des pizzas qui implémente Menuservice
 * @author Diginamic
 *
 */
public class SupprimerPizzaService extends MenuService{
	/**
	 * Fonction du menu supression des pizzas
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) throws DeletePizzaException{
		System.out.println("Suppression d’une pizza");
		System.out.println("Liste des pizzas");
		
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		for(int i=0;i < pizzas.size();i++){
			System.out.println(pizzas.get(i).pizzaInfo());
		}
		String codeSuppr="";
		do{
			System.out.println("choisissez la pizza a supprimer");
			codeSuppr = scanner.next();
			if(!pizzaDao.pizzaExists(codeSuppr)){
				throw new DeletePizzaException("la pizza n'existe pas");
			}
		}while(!pizzaDao.pizzaExists(codeSuppr));
		pizzaDao.deletePizza(codeSuppr);
	}

}
