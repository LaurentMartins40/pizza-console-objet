package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
/**
 * Superclasse abstraite qui initialise les différentes fonctions proposés dans le menu
 * @author Diginamic
 *
 */
public abstract class MenuService {
	/**
	 * classe abstraite qui exécutera différentes fonctions du menu 
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	public abstract void executeUC(PizzaDao pizzaDao, Scanner scanner);
}
