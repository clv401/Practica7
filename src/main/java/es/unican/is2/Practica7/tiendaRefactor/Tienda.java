package es.unican.is2.Practica7.tiendaRefactor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gestión de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> listaVendedores = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) {	//WCM=1
		this.datos = datos;
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() {	//WCM=1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {	//WCM=1
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException {	//WCM=1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {	//WCM=1	CCog=1
			return false;
		}
		listaVendedores.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {	//WCM=1
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//WCM=1	CCog=1
			return false;
		}
		listaVendedores.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se añade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {	//WCM=1
		Vendedor v = buscaVendedor(id);
		if (v == null) {	//WCM=1	CCog=1
			return false;
		}
		v.anhadeVenta(importe);
		vuelcaDatos();
		return true;
	}
	
	/**
	 * Lee datos y crea la lista de vendedores
	 */
	private void creaListaVendedores() {	//WCM=1
		listaVendedores = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();	//"Senior"
			Vendedor ven = null;
			// lee los vendedores senior
			while (!in.next().equals("Junior")) {	//WCM=1 CCog=1

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorSenior(nombre, idIn);
				ven.setT(totalVentas);
				listaVendedores.add(ven);
			}
			// lee los vendedores junior
			while (!in.next().equals("Prácticas")) {	//WCM=1	CCog=1
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorJunior(nombre, idIn);
				ven.setT(totalVentas);
				listaVendedores.add(ven);
			}
			//lee los vendedores en practicas
			while (in.hasNext()) {	//WCM=1	CCog=1
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nombre, idIn);
				ven.setT(totalVentas);
				listaVendedores.add(ven);
			}
		} catch (FileNotFoundException e) {	//CCog=1
		} finally {
			if (in != null) {	//WCM=1	CCog=1
				in.close();
			}
		} // try
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {	//WCM=1
		creaListaVendedores();
		for (Vendedor v : listaVendedores) {	//WCM=1	CCog=1
			if (v.getId().equals(id)) {	//WCM=1	CCog=2
				return v;
			}
		}
		return null;
	}


	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> getVendedores() {	//WCM=1
		creaListaVendedores();
		return listaVendedores;

	}

	/**
	 * Método que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws IOException {	//WCM=1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : listaVendedores) {	//WCM=1	CCog=1
			if (v instanceof VendedorEnPracticas) {	//WCM=1	CCog=2
				practicas.add(v);
			} else if (v instanceof VendedorSenior) {	//WCM=1	CCog=2
				senior.add(v);
			} else if (v instanceof VendedorJunior) {	//WCM=1	CCog=2
				junior.add(v);
			} 
		}

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("    Senior");
			for (Vendedor v1 : senior)	//WCM=1 CCog=1
				v1.pintaDatos(out); 
			out.println();
			out.println("    Junior");
			for (Vendedor v2 : junior)	//WCM=1	CCog=1
				v2.pintaDatos(out);
			out.println();
			out.println("    Prácticas");
			for (Vendedor v3 : practicas)	//WCM=1	CCog=1
				v3.pintaDatos(out);

		} finally {
			if (out != null)	//WCM=1	CCog=1
				out.close();
		}
	}

	/**
	 * Retorna el vendedor con mas ventas
	 * @return resultado
	 */
	public List<Vendedor> vendedorDelMes() {	//WCM=1
		List<Vendedor> resultado = new LinkedList<Vendedor>();
		double maxVentas = 0.0;
		for (Vendedor v : getVendedores()) {	//WCM=1	CCog=1
			if (v.getTotalVentas() > maxVentas) {	//WCM=1	CCog=2
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {	//WCM=1	CCog=2
				resultado.add(v);
			}
		}
		return resultado;
	}
	
	/**
	 * Retorna la lista de vendedores ordenados por ventas
	 * @return resultado
	 */
	public List<Vendedor> vendedoresOrdenadosPorVentas() {	//WCM=1
		List<Vendedor> vendedores = getVendedores();
		System.out.println(vendedores.size());
		Collections.sort(vendedores, new Comparator<Vendedor>() {
			public int compare(Vendedor o1, Vendedor o2) {
				return (int) Math.signum(o1.getTotalVentas()-o2.getTotalVentas());
			}			
		});
		return vendedores;
	} 
}
