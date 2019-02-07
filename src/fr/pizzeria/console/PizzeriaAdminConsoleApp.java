package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzaService;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {
	public static void main(String args[]) {
		boolean quit = false;// initialisation de la variable "quit" a 0
		Scanner questionUser = new Scanner(System.in ) ; // activation de la lecture
		PizzaDao pizzaDao = new PizzaMemDao();
			
		while(!quit){ // la boucle se répetera jusqu'a ce que la variable "quit" change d'etat
			
			// affichage du menu
			System.out.println("1 : Lister les pizzas");
			System.out.println("2 : Ajouter une nouvelle pizza");
			System.out.println("3 : Mettre à jour une pizza");
			System.out.println("4 : Supprimer une pizza");
			System.out.println("99 : Sortir");
			// lecture du choix de l'utilisateur
			int choix = questionUser.nextInt();
			switch (choix){
			case 1 :  // l'utilisateur choisis d'afficher le menu
				MenuService serviceLister = new ListerPizzaService();
				serviceLister.executeUC(pizzaDao, questionUser);
				break;
			case 2 :	// l'utilisateur choisis d'ajouter une nouvelle pizza
				MenuService serviceAjouter = new AjouterPizzaService();
				serviceAjouter.executeUC(pizzaDao, questionUser);
				break;
			case 3 :
				MenuService serviceModifier = new ModifierPizzaService();
				serviceModifier.executeUC(pizzaDao, questionUser);
				break;
			case 4 :
				MenuService serviceSupprimer = new SupprimerPizzaService();
				serviceSupprimer.executeUC(pizzaDao, questionUser);
				break;
			case 99 :
				System.out.println("Aurevoir ☹");
				quit = true;
				break;
			}
		}
		
		questionUser.close();
	}
	
}
