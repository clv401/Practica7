package es.unican.is2.Practica7.tienda;


/**
 * Vendedor de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	public Vendedor(String nombre, String id) {	//WCM=1
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {	//WCM=1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {	//WCM=1
		return id;
	}

	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {	//WCM=1
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {	//WCM=1
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){	//WCM=1
		t += importe;
	}
	
	
	@Override
	public boolean equals(Object obj) {	//WCM=1 
		if (!(obj instanceof Vendedor)) 	//WCM=1	CCog=1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.id.equals(id) && v.nombre.equals(nombre));	//WCM=2 CCog=1
	}
	
	
}
