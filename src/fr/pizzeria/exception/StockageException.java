package fr.pizzeria.exception;

public class StockageException extends Exception{
	public StockageException() {
	}
	public StockageException(String msg) {
		System.out.println(msg);
	}

}
