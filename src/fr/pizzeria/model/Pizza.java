package fr.pizzeria.model;

public final class  Pizza {
	public static int nbPizza = 0;
	
	public int id = 0;
	public String code ;
	public String libelle;
	public double prix ;
	
	private CategoriePizza categorie;
	
	 /**
	  * constructeur de la classe pizza
	  */
	 public Pizza(){
		this.id = nbPizza++ ;
		this.code = "code";
		this.libelle = "libelle";
		this.prix = 0;
		this.categorie = null;
	 }
	 /**
	  * constructeur de la classe pizza
	  * @param code
	  * @param libelle
	  * @param prix
	  */
	public Pizza( String code , String libelle, double prix , CategoriePizza categorie){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		
	}
	/**
	 * constructeur de la classe pizza
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code , String libelle, double prix, CategoriePizza categorie){
		this.id = id ;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;

	}
	/**
	 * fonction de mise en place d'un message
	 * @return pizzaInfo type String
	 */
	public String pizzaInfo(){
		return (this.code + "->" + this.libelle +"("+ this.prix+"€) de categorie : " + this.categorie);
	}
	/**
	 * 
	 * @param id type int
	 * @param code type String
	 * @param libelle type String
	 * @param prix type double 
	 */
	public void setPizza(int id, String code , String libelle, double prix, CategoriePizza categorie){
		this.id = id ;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	public CategoriePizza getCategorie(){
		return this.categorie;
	}
	
}
