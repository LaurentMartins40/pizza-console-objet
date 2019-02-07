package fr.pizzeria.console;

import java.awt.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ListerPizzaService;
import fr.pizzeria.service.MenuService;

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
			Pizza[] pizzasTemp = pizzaDao.findAllPizzas() ;
			// lecture du choix de l'utilisateur
			int choix = questionUser.nextInt();
			switch (choix){
			case 1 :  // l'utilisateur choisis d'afficher le menu
				MenuService service = new ListerPizzaService();
				service.executeUC(pizzaDao, questionUser);
				break;
			case 2 :	// l'utilisateur choisis d'ajouter une nouvelle pizza
				System.out.println("Ajout d’une nouvelle pizza");
				
				// récupération des prametres de la nouvelle pizza
				System.out.println("saissisez le code");
				String codeNouveau = questionUser.next();
				System.out.println("saissisez le nom(sans espace)");
				String labelNouveau = questionUser.next();
				System.out.println("saissisez le prix");
				Double prixNouveau = Double.parseDouble(questionUser.next());
				
				Pizza nouvellePizza = new Pizza(codeNouveau,labelNouveau,prixNouveau);
				pizzaDao.saveNewPizza(nouvellePizza);				
				
				break;
			case 3 :
				System.out.println("Mise à jour d’une pizza");
				System.out.println("quelle pizza modifier");
				String codeModif = questionUser.next();
				
				
				System.out.println("saissisez le nouveau code");
				String modifCode = questionUser.next();
				System.out.println("saissisez le nouveau nom(sans espace)");
				String modifLabel = questionUser.next();
				System.out.println("saissisez le nouveau prix");
				Double modifPrix = Double.parseDouble(questionUser.next());
				
				Pizza tempPizza = new Pizza(modifCode,modifLabel,modifPrix);
				pizzaDao.updatePizza(codeModif,tempPizza);
				 
				break;
			case 4 :
				System.out.println("Suppression d’une pizza");
				System.out.println("Liste des pizzas");
				
				for(int i=0;i < pizzasTemp.length;i++){
					System.out.print(pizzasTemp[i].code + "->");
					System.out.print(pizzasTemp[i].libelle + "(");
					System.out.println( pizzasTemp[i].prix + ")");
				}
				System.out.println("choisissez la pizza a supprimer");
				
				String codeSuppr = questionUser.next();
				
				pizzaDao.deletePizza(codeSuppr);
				
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
