package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Liste des pizzas");
		
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		for(int i = 0 ; i < pizzas.length ; i++){
			System.out.print(pizzas[i].code + "->");
			System.out.print(pizzas[i].libelle + "(");
			System.out.println(pizzas[i].prix+ ")");
		}
		
	}

}
