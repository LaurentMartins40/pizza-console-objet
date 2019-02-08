package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;
/**
 * 
 * @author Diginamic
 *
 */
public class ListerPizzaService extends MenuService{
	/**
	 * Fonction du menu d'affichage des pizzas
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Liste des pizzas");
		
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		for(int i = 0 ; i < pizzas.size() ; i++){
			System.out.println(pizzas.get(i).pizzaInfo());
			
		}
		
	}

}
