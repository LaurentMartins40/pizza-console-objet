package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
/**
 * sous classe de la super classe PizzaDao
 * @author Diginamic
 *
 */
public class PizzaMemDao implements PizzaDao{
	
		private List<Pizza> menu = new ArrayList<Pizza>();
		/**
		 * constructeur d'initialisation des premieres pizzas
		 */
	public PizzaMemDao() {
		
		String[] tableauPizzaCode = {"PEP","MAR", "REIN","FRO","CAN","SAV","ORI","IND"};
		String[] tableauPizzaLabel = {"Peperoni","Margherita", "La Reine","La 4 Fromage","La Cannibale","La Savoyarde","L'orientale","L'indienne"};
		Double[] tableauPizzaPrix = {12.50,14.00,11.50,12.00,12.50,13.00,13.50,14.00};
		
		for(int i = 0 ; i < tableauPizzaCode.length ; i++){
			menu.add(new Pizza(i+1,tableauPizzaCode[i],tableauPizzaLabel[i],tableauPizzaPrix[i]));
		}
		
	}
	/**
	 * fonction de recherche de toutes les pizzas
	 * @return menu de type List<Pizza>
	 */
	@Override
	public List<Pizza> findAllPizzas() {	
		return menu;
	}
	/**
	 * Fonction d'enregistrement d'une nouvelle pizza
	 * @param pizza de type Pizza
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException{
	
			menu.add(pizza);
	}
	/**
	 * Fonction de modification de pizza
	 * @param codePizza de String
	 * @param pizza de type Pizza
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException {
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).code.equals(codePizza)){
				menu.get(i).setPizza(pizza.id,pizza.code,pizza.libelle,pizza.prix);
			}
		}
	}
	/**
	 * Fonction de supression d'une pizza
	 * @param codePizza de type String
	 */
	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException{
		int supprId = -1;
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).code.equals(codePizza) ){
				supprId = i;
			}
		}
			menu.remove(supprId) ;
	}
	/**
	 * fonction permettant de retrouver une pizza par sun code
	 * @param codePizza de type String
	 * @return pizza de type Pizza
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int idPizza = -1;
		if (pizzaExists(codePizza)){
			for(int i=0;i<menu.size();i++){
				if(menu.get(i).code.equals(codePizza)){
					idPizza = i;
				}
			}
			return menu.get(idPizza);
		}
		return null;	
	}
	/**
	 * fonction permettant de vérifier si une pizza existe
	 * @param codePizza de type String
	 * @return Boolean
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).code.equals(codePizza)){
				return true;
			}
		}
		return false;
	}

}
