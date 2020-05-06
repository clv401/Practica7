package es.unican.is2.Practica7.tiendaRefactor;


public class VendedorJunior extends Vendedor{
	
	private static final double CONST_COMISION = 0.005;	//0.5%

	/**
	 * Retorna un nuevo vendedor junior
	 * @param nombre
	 * @param dni
	 */
	public VendedorJunior(String nombre, String dni) {	//WCM=1
		super(nombre, dni, CONST_COMISION);
	}

}