package es.unican.is2.Practica7.tiendaRefactor;

import java.io.PrintWriter;

/**
 * Vendedor de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	private double comision;

	// Valor total de las ventas mensuales realizadas por el vendedor
	private double valorTotalVentas;
	
	public Vendedor(String nombre, String id, double comision) {	//WCM=1
		this.nombre = nombre;
		this.id = id;
		this.comision=comision;
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
		return valorTotalVentas;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {	//WCM=1
		this.valorTotalVentas = totalVentas;
	}
	
	public double getComision() {	//WCM=1
		return comision;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhadeVenta(double importe){	//WCM=1
		importe += importe*comision;
		valorTotalVentas += importe;
	}
	
	
	@Override
	public boolean equals(Object obj) {	//WCM=1 
		if (!(obj instanceof Vendedor)) 	//WCM=1	CCog=1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.id.equals(id) && v.nombre.equals(nombre));	//WCM=2 CCog=1
	}

	
	/**
	 * Pinta los datos del vendedor en el PrintWriter pasado por parametro
	 * @param out
	 */
	public void pintaDatos(PrintWriter out) {	//WCM=1
		out.println("      Nombre: " + getNombre() + "   Id: " + getId() + "   TotalVentasMes: "
				+ getTotalVentas());
	}
	
	
}
