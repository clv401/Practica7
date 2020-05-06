package es.unican.is2.Practica7.tiendaRefactor;


public class VendedorSenior extends Vendedor{
	
	private static final double CONST_COMISION = 0.01;	//1%

	/**
	 * Retorna un nuevo vendedor senior
	 * @param nombre
	 * @param dni
	 */
	public VendedorSenior(String nombre, String dni) {	//WCM=1
		super(nombre, dni, CONST_COMISION);
	}

}