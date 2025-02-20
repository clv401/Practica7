package es.unican.is2.Practica7.tienda;


public class VendedorEnPlantilla extends Vendedor {
	
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String dni, TipoVendedor tipo) {	//WCM=1
		super(nombre, dni);
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() {	//WCM=1
		return tipo;
	}
}
