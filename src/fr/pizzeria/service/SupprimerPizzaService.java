package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Suppression d’une pizza");
		System.out.println("Liste des pizzas");
		
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		for(int i=0;i < pizzas.length;i++){
			System.out.print(pizzas[i].pizzaInfo());
		}
		System.out.println("choisissez la pizza a supprimer");
		
		String codeSuppr = scanner.next();
		
		pizzaDao.deletePizza(codeSuppr);
		
		
	}

}
