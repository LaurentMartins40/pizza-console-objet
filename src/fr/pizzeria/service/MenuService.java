package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.CategoryPizzaException;
import fr.pizzeria.exception.StockageException;
/**
 * Superclasse abstraite qui initialise les diff�rentes fonctions propos�s dans le menu
 * @author Diginamic
 *
 */
public abstract class MenuService {
	/**
	 * classe abstraite qui ex�cutera diff�rentes fonctions du menu 
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 */
	public abstract void executeUC(PizzaDao pizzaDao, Scanner scanner)throws StockageException,CategoryPizzaException;
}
