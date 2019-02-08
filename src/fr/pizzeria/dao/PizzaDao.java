package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;
/**
 * Classe abstraite des fonctions de l'application
 * @author Diginamic
 *
 */
public interface PizzaDao {
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
