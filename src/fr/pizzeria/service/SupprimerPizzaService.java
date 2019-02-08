package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner) {
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
				System.out.println("la pizza n'existe pas");
			}
		}while(!pizzaDao.pizzaExists(codeSuppr));
		pizzaDao.deletePizza(codeSuppr);
	}

}
