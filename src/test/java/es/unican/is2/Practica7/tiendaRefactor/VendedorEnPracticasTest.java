package es.unican.is2.Practica7.tiendaRefactor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.Practica7.tiendaRefactor.VendedorEnPracticas;

public class VendedorEnPracticasTest {
	
	private static VendedorEnPracticas sut;

	@Before
	public void setUp(){
		sut = new VendedorEnPracticas("Ana", "1");
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sut.getId(), "1");
		assertEquals(sut.getNombre(), "Ana");
		assertEquals(sut.getComision(), 0, 0);
	}
	
	@Test
	public void testSetTotalVentas() {
		sut.setT(100);
		assertTrue(sut.getTotalVentas()==100.0);
		
		sut.setT(230);
		assertTrue(sut.getTotalVentas()==230.0);
		
		sut.setT(0);
		assertTrue(sut.getTotalVentas()==0.0);
	}

	@Test
	public void testAnhadeVenta() {
		sut.anhadeVenta(200);
		assertTrue(sut.getTotalVentas() == 200.0);
		
		sut.anhadeVenta(300);
		assertTrue(sut.getTotalVentas() == 500.0);	
		
		sut.anhadeVenta(0);
		assertTrue(sut.getTotalVentas() == 500.0);
		
	}
	
	@Test
	public void testEquals() {
		VendedorEnPracticas igual = new VendedorEnPracticas("Ana", "1");
		VendedorEnPracticas distintoId = new VendedorEnPracticas("Ana", "2");
		VendedorEnPracticas distintoNombre = new VendedorEnPracticas("Pepe", "1");
		VendedorEnPracticas distinto = new VendedorEnPracticas("Pepe", "6");
		
		assertTrue(sut.equals(igual));
		assertFalse(sut.equals(distintoId));
		assertFalse(sut.equals(distintoNombre));
		assertFalse(sut.equals(distinto));
	}
	
}
