package fr.pizzeria.exception;

public class CategoryPizzaException extends StockageException{
	public CategoryPizzaException () {
	}
	public CategoryPizzaException (String msg) {
		super(msg);
	}
}
