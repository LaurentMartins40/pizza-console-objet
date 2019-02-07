package fr.pizzeria.model;

public final class  Pizza {
	public int id;
	public String code ;
	public String libelle;
	public double prix ;
	 
	 public Pizza(){
		this.id = 0 ;
		this.code = "code";
		this.libelle = "libelle";
		this.prix = 0;
	 }
	 
	public Pizza( String code , String libelle, double prix){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	public Pizza(int id, String code , String libelle, double prix){
		this.id = id ;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	public String pizzaInfo(){
		return (this.code + "->" + this.libelle +"("+ this.prix+"€)");
	}
	
}
