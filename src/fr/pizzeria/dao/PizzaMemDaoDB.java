package fr.pizzeria.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoDB implements PizzaDao {
	
	private Connection connexion;
	private Statement st;
	private List<Pizza> menu = new ArrayList<Pizza>();
	CategoriePizza[] tableauPizzacat = {CategoriePizza.VIANDE,CategoriePizza.SANS_VIANDE,CategoriePizza.VIANDE,
			CategoriePizza.SANS_VIANDE,CategoriePizza.VIANDE,CategoriePizza.SANS_VIANDE,
			CategoriePizza.POISSON,CategoriePizza.POISSON};
	
	public PizzaMemDaoDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		try {
			
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet resultats;
		try {
			resultats = st.executeQuery("SELECT * FROM PIZZA");
			while(resultats.next()) {
				//CategoriePizza nouvelleCategorie =  CategoriePizza.
				menu.add(new Pizza(resultats.getInt("ID"),
						resultats.getString("CODE"), 
						resultats.getString("LIBELLE"),
						resultats.getDouble("PRIX"),
						CategoriePizza.VIANDE)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement addPizzaSt;
		try {
			addPizzaSt = connexion.prepareStatement("INSERT INTO PIZZA(code ,libelle ,prix,categorie) values(?,?,?,?)");
			addPizzaSt.setString(1, pizza.code);
			addPizzaSt.setString(2, pizza.libelle);
			addPizzaSt.setDouble(3, pizza.prix);
			addPizzaSt.setString(4, "viande");
			addPizzaSt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		PreparedStatement updatePizzaSt;
		try {
			updatePizzaSt = connexion.prepareStatement("UPDATE PIZZA SET code = ? ,libelle = ? ,prix = ? ,categorie = ?  WHERE id=?");
			Pizza prevpizza = findPizzaByCode(codePizza);
			updatePizzaSt.setString(1, pizza.code);
			updatePizzaSt.setString(2, pizza.libelle);
			updatePizzaSt.setDouble(3, pizza.prix);
			updatePizzaSt.setString(4, "viande");
			updatePizzaSt.setInt(5, prevpizza.id);
			updatePizzaSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		PreparedStatement deletePizzaSt;
		try {
			deletePizzaSt = connexion.prepareStatement("DELETE FROM pizza where id = ?");
			Pizza removepizza = findPizzaByCode(codePizza);
			deletePizzaSt.setInt(1, removepizza.id);
			deletePizzaSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza result = null;
		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet resultats = st.executeQuery("SELECT * FROM PIZZA where code = '"+ codePizza + "'");
			while(resultats.next()){
				int id = resultats.getInt("ID");
				String code = resultats.getString("code");
				String libelle = resultats.getString("libelle");
				double prix = resultats.getDouble("prix");
				
				result = new Pizza(id,code,libelle,prix,CategoriePizza.VIANDE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		
		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzadao","root","");
			st = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int valeur = 0;
		try {
			ResultSet result = st.executeQuery("SELECT * FROM PIZZA where code = '"+ codePizza + "'");
			while(result.next()){
				valeur = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (valeur == 0){
			return false;
		}else
		{
			return true;
		}
	}

}