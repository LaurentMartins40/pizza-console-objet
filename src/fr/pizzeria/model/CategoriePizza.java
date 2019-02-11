package fr.pizzeria.model;

import fr.pizzeria.exception.CategoryPizzaException;

public enum CategoriePizza {
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	private String categorie;
	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	public String getCategoriePizza() {
		return categorie;
	}
	public void setCategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	 public static CategoriePizza chooseCategoriePizza(int choose) throws CategoryPizzaException{
		CategoriePizza tabCategories[] = CategoriePizza.values();
		for(int i=0;i<CategoriePizza.values().length;i++){
			if(i==choose){
				return tabCategories[i];
			}
		}
		throw new CategoryPizzaException("cette categorie n'existe pas");
	}
}