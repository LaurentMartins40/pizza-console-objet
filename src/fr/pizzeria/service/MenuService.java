package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public abstract class MenuService {
	public abstract void executeUC(PizzaDao pizzaDao, Scanner scanner);
}
