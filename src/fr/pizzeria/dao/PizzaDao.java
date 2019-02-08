package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * Classe abstraite des fonctions de d'acces aux données de l'application
 * @author Diginamic
 *
 */
public interface PizzaDao {
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza) throws SavePizzaException; 
	void updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException;
	void deletePizza(String codePizza)throws DeletePizzaException;
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
