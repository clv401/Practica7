package es.unican.is2.Practica7.tiendaRefactor;


public class VendedorEnPracticas extends Vendedor{
	
	private static final int CONST_COMISION = 0;	//0%

	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String dni) {	//WCM=1
		super(nombre, dni, CONST_COMISION);
	}

}
