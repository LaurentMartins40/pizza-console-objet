package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.CategoryPizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * Classe des fonctions du menu ajout des pizzas qui implémente Menuservice
 * @author Diginamic
 *
 */
public class AjouterPizzaService extends MenuService{
	/**
	 * Fonction du menu ajout des pizzas
	 * @param pizzaDao type PizzaDao
	 * @param scanner type Scanner
	 * @throws CategoryPizzaException 
	 */
	@Override
	public void executeUC(PizzaDao pizzaDao, Scanner scanner)throws SavePizzaException, CategoryPizzaException {
		System.out.println("Ajout d’une nouvelle pizza");
		
		// récupération des prametres de la nouvelle pizza
		System.out.println("saissisez le code");
		String codeNouveau = scanner.next();
		if(pizzaDao.pizzaExists(codeNouveau)){
			throw new SavePizzaException("la pizza existe deja ! ");
		}
		else{
			System.out.println("saissisez le nom(sans espace)");
			String labelNouveau = scanner.next();
			System.out.println("saissisez le prix");
			Double prixNouveau = Double.parseDouble(scanner.next());
			
			System.out.println("saissisez la categorie");
			System.out.println("1 : VIANDE");
			System.out.println("2 : POISSON");
			System.out.println("1 : SANS_VIANDE");
			int categorieNouvelle = scanner.nextInt();
			CategoriePizza nouvelleCategorie =  CategoriePizza.chooseCategoriePizza(categorieNouvelle);
			Pizza nouvellePizza = new Pizza(codeNouveau,labelNouveau,prixNouveau, nouvelleCategorie);
			pizzaDao.saveNewPizza(nouvellePizza);		
		}
		
	}

	
	
	
	
}
