package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {
	public static void main(String args[]) {
		boolean quit = false;// initialisation de la variable "quit" a 0
		Scanner questionUser = new Scanner(System.in ) ; // activation de la lecture
		PizzaDao pizzaDao = new PizzaMemDao();
			
		while(!quit){ // la boucle se répetera jusqu'a ce que la variable "quit" change d'etat
			
			// affichage du menu utilisateur
			System.out.println("1 : Lister les pizzas");
			System.out.println("2 : Ajouter une nouvelle pizza");
			System.out.println("3 : Mettre à jour une pizza");
			System.out.println("4 : Supprimer une pizza");
			System.out.println("99 : Sortir");
			// lecture du choix de l'utilisateur
			
			int choix = questionUser.nextInt();
			if (choix != 99){
			
				// exécution de menuService dans MenuServiceFactory
				MenuService menuService = MenuServiceFactory.getService(choix);
				try{
					menuService.executeUC(pizzaDao, questionUser);	
				}
				catch(StockageException stockageException){
					stockageException.getMessage();
				}
			}
			else{
				//Fin du programme
				System.out.println("Aurevoir ☹");
					quit = true;
			}
			
		}
		
		questionUser.close();
	}
	
}
