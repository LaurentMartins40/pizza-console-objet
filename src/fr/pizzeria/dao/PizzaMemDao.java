package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements PizzaDao{
	
		private Pizza[] menu = new Pizza[8];
		
	public PizzaMemDao() {
		
		String[] tableauPizzaCode = {"PEP","MAR", "REIN","FRO","CAN","SAV","ORI","IND"};
		String[] tableauPizzaLabel = {"Peperoni","Margherita", "La Reine","La 4 Fromage","La Cannibale","La Savoyarde","L'orientale","L'indienne"};
		Double[] tableauPizzaPrix = {12.50,14.00,11.50,12.00,12.50,13.00,13.50,14.00};
		
		for(int i = 0 ; i < menu.length ; i++){
			menu[i] = new Pizza(i+1,tableauPizzaCode[i],tableauPizzaLabel[i],tableauPizzaPrix[i]);
		}
		
	}
	@Override
	public Pizza[] findAllPizzas() {	
		return menu;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		Pizza[] tempMenu = new Pizza[menu.length+1]; 
		 for(int i=0;i<menu.length;i++){
			 tempMenu[i] = menu[i];
		 }
		 tempMenu[menu.length] = pizza ;
		 menu = tempMenu;
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<menu.length;i++){
			if(menu[i].code.equals(codePizza)){
				menu[i] = pizza;
			}
		}
	
	}

	@Override
	public void deletePizza(String codePizza) {
		int supprId = -1;
		for(int i=0;i<menu.length;i++){
			if(menu[i].code.equals(codePizza) ){
				supprId = i;
			}
		}
		if (!pizzaExists(codePizza)){
			 System.out.println("cette pizza n'existe pas");
		 }
		else{
			Pizza[] tempMenuSuppr = new Pizza[menu.length-1]; 
			for(int i=0;i<menu.length;i++){
				if (supprId>i){
					tempMenuSuppr[i] = menu[i];
				}
				else if(supprId<i){
					tempMenuSuppr[i-1] = menu[i];
				}
			}
				menu = tempMenuSuppr;
		}
		
	}
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int idPizza = -1;
		if (pizzaExists(codePizza)){
			for(int i=0;i<menu.length;i++){
				if(menu[i].code.equals(codePizza)){
					idPizza = i;
				}
			}
			return menu[idPizza];
		}
		return null;	
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i=0;i<menu.length;i++){
			if(menu[i].code.equals(codePizza)){
				return true;
			}
		}
		return false;
	}

}
