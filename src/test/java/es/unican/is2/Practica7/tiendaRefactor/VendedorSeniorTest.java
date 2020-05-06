package es.unican.is2.Practica7.tiendaRefactor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.Practica7.tiendaRefactor.VendedorSenior;

public class VendedorSeniorTest {
	
	private static VendedorSenior sutSenior;
	
	@Before
	public void setUp(){
		sutSenior = new VendedorSenior("Ana", "1");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutSenior.getId(), "1");
		assertEquals(sutSenior.getNombre(), "Ana");
		assertEquals(sutSenior.getComision(), 0.01, 0);
		
	}

	@Test
	public void testAnhadeVenta() {
		
		sutSenior.anhadeVenta(200);
		assertEquals(sutSenior.getTotalVentas(), 202, 0);
		
		sutSenior.anhadeVenta(300);
		assertEquals(sutSenior.getTotalVentas(), 505, 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutSenior.setT(2000);
		assertEquals(sutSenior.getTotalVentas(), 2000, 0);	
		sutSenior.setT(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);	
		sutSenior.setT(0);
		assertEquals(sutSenior.getTotalVentas(), 0, 0);
		
	}
	
	@Test
	public void testEquals() {
		VendedorSenior igualSenior = new VendedorSenior("Ana", "1");
		VendedorSenior distintoIdSenior = new VendedorSenior("Ana", "2");
		VendedorSenior distintoNombreSenior = new VendedorSenior("Pepe", "1");
		VendedorSenior distintoSenior = new VendedorSenior("Pepe", "6");
		
		assertTrue(sutSenior.equals(igualSenior));
		assertFalse(sutSenior.equals(distintoIdSenior));
		assertFalse(sutSenior.equals(distintoNombreSenior));
		assertFalse(sutSenior.equals(distintoSenior));
		
	}

}
