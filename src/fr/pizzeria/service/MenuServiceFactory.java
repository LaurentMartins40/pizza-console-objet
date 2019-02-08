package fr.pizzeria.service;


/**
 * Gestion du choix de l'utilisateur
 * @author Diginamic
 *
 */
public class MenuServiceFactory{
	/**
	 * Gestion du choix de l'utilisateur
	 * @param choix de type int
	 * @return Fonctions des différentes options du menu
	 */
	public static MenuService getService(int choix){
		
		switch (choix){
		case 1 :  
			return new ListerPizzaService();
		
		case 2 :	
			return new AjouterPizzaService();
			
		case 3 :
			return new ModifierPizzaService();
			
		case 4 :
			return new SupprimerPizzaService();
	
		default:
			return null ;
	}
	}
}
