import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class DaoTest {
private PizzaMemDao pizzaDaoTest ; 
	@Before
	public void setUp() throws Exception {
		pizzaDaoTest = new PizzaMemDao();
	}
	@Test
	public void testAjout() throws SavePizzaException {
		pizzaDaoTest.saveNewPizza(new Pizza("CHO","Chorizal",13.5));
		assertTrue("il y a une pizza",pizzaDaoTest.pizzaExists("CHO"));
	}
	@Test
	public void testmodif() throws SavePizzaException, UpdatePizzaException {
		pizzaDaoTest.saveNewPizza(new Pizza("CHO","Chorizal",13.5));
		pizzaDaoTest.updatePizza("CHO", new Pizza("BBQ","Barbecue",14.0));
		assertTrue("la pizza a été modifié",pizzaDaoTest.pizzaExists("BBQ"));
	}
	@Test
	public void testsuppr() throws SavePizzaException, DeletePizzaException {
		pizzaDaoTest.saveNewPizza(new Pizza("CHO","Chorizal",13.5));
		pizzaDaoTest.deletePizza("CHO");
		assertFalse("la pizza a été supprimé",pizzaDaoTest.pizzaExists("CHO"));
	}

}