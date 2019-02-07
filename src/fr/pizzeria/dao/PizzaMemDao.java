package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements PizzaDao{
	
		private List<Pizza> menu = new ArrayList<Pizza>();
		
	public PizzaMemDao() {
		
		String[] tableauPizzaCode = {"PEP","MAR", "REIN","FRO","CAN","SAV","ORI","IND"};
		String[] tableauPizzaLabel = {"Peperoni","Margherita", "La Reine","La 4 Fromage","La Cannibale","La Savoyarde","L'orientale","L'indienne"};
		Double[] tableauPizzaPrix = {12.50,14.00,11.50,12.00,12.50,13.00,13.50,14.00};
		
		for(int i = 0 ; i < menu.size() ; i++){
			menu.add(new Pizza(i+1,tableauPizzaCode[i],tableauPizzaLabel[i],tableauPizzaPrix[i]));
		}
		
	}
	@Override
	public List<Pizza> findAllPizzas() {	
		return menu;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		menu.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).code.equals(codePizza)){
				menu.get(i).setPizza(pizza.id,pizza.code,pizza.libelle,pizza.prix);
			}
		}
	
	}

	@Override
	public void deletePizza(String codePizza) {
		int supprId = -1;
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).code.equals(codePizza) ){
				supprId = i;
			}
		}
		if (!pizzaExists(codePizza)){
			 System.out.println("cette pizza n'existe pas");
		 }
		else{
			
				menu.remove(supprId) ;
		}
		
	}
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
