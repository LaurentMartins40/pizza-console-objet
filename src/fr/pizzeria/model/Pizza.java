package fr.pizzeria.model;

public final class  Pizza {
	public static int nbPizza = 0;
	
	public int id = 0;
	public String code ;
	public String libelle;
	public double prix ;
	 /**
	  * constructeur de la classe pizza
	  */
	 public Pizza(){
		this.id = nbPizza++ ;
		this.code = "code";
		this.libelle = "libelle";
		this.prix = 0;
	 }
	 /**
	  * constructeur de la classe pizza
	  * @param code
	  * @param libelle
	  * @param prix
	  */
	public Pizza( String code , String libelle, double prix){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	/**
	 * constructeur de la classe pizza
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code , String libelle, double prix){
		this.id = id ;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	/**
	 * fonction de mise en place d'un message
	 * @return pizzaInfo type String
	 */
	public String pizzaInfo(){
		return (this.code + "->" + this.libelle +"("+ this.prix+"€)");
	}
	/**
	 * 
	 * @param id type int
	 * @param code type String
	 * @param libelle type String
	 * @param prix type double 
	 */
	public void setPizza(int id, String code , String libelle, double prix){
		this.id = id ;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
}
