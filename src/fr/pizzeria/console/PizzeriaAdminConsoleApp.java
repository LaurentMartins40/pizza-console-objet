package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String args[]) {
		String[] tableauPizzaCode = {"PEP","MAR", "REIN","FRO","CAN","SAV","ORI","IND"};
		String[] tableauPizzaLabel = {"Peperoni","Margherita", "La Reine","La 4 Fromage","La Cannibale","La Savoyarde","L'orientale","L'indienne"};
		Double[] tableauPizzaPrix = {12.50,14.00,11.50,12.00,12.50,13.00,13.50,14.00};
		
		Pizza[] menu = new Pizza[8];
		boolean quit = false;
		Scanner questionUser = new Scanner(System.in ) ;
		for(int i = 0 ; i < menu.length ; i++){
			menu[i] = new Pizza(i+1,tableauPizzaCode[i],tableauPizzaLabel[i],tableauPizzaPrix[i]);
		}
		
		while(!quit){
			System.out.println("1 : Lister les pizzas");
			System.out.println("2 : Ajouter une nouvelle pizza");
			System.out.println("3 : Mettre à jour une pizza");
			System.out.println("4 : Supprimer une pizza");
			System.out.println("99 : Sortir");
			
			int choix = questionUser.nextInt();
			switch (choix){
			case 1 :
				System.out.println("Liste des pizzas");
				for(int i=0;i<menu.length;i++){
					System.out.println(menu[i].code + "->" + menu[i].libelle +"(" + menu[i].prix +")");
				}
				break;
			case 2 :
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println("saissisez le code");
				String codeNouveau = questionUser.next();
				System.out.println("saissisez le nom(sans espace)");
				String labelNouveau = questionUser.next();
				System.out.println("saissisez le prix");
				Double prixNouveau = Double.parseDouble(questionUser.next());
				
				Pizza[] tempMenu = new Pizza[menu.length+1]; 
				 for(int i=0;i<menu.length;i++){
					 tempMenu[i] = menu[i];
				 }
				 tempMenu[menu.length] = new Pizza(menu.length,codeNouveau,labelNouveau,prixNouveau);
				 menu = tempMenu;
				
				
				break;
			case 3 :
				System.out.println("Mise à jour d’une pizza");
				System.out.println("quelle pizza modifier");
				String codeModif = questionUser.next();
				int modifId = -1;
				for(int i=0;i<menu.length;i++){
					if(menu[i].code.equals(codeModif) ){
						modifId = i;
					}
				}
				System.out.println("saissisez le nouveau code");
				String modifCode = questionUser.next();
				System.out.println("saissisez le nouveau nom(sans espace)");
				String modifLabel = questionUser.next();
				System.out.println("saissisez le nouveau prix");
				Double modifPrix = Double.parseDouble(questionUser.next());
				
				menu[modifId].code = modifCode;
				menu[modifId].libelle = modifLabel;
				menu[modifId].prix = modifPrix;
				 
				 if (modifId == -1){
					 System.out.println("cette pizza n'existe pas");
				 }
				 
				break;
			case 4 :
				System.out.println("Suppression d’une pizza");
				System.out.println("Liste des pizzas");
				for(int i=0;i<menu.length;i++){
					System.out.println(menu[i].code + "->" + menu[i].libelle +"(" + menu[i].prix +")");
				}
				System.out.println("choisissez la pizza a supprimer");
				
				String codeSuppr = questionUser.next();
				int supprId = -1;
				for(int i=0;i<menu.length;i++){
					if(menu[i].code.equals(codeSuppr) ){
						supprId = i;
					}
				}
				if (supprId == -1){
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
