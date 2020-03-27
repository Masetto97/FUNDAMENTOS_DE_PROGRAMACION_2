package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Tienda {

	// Crear los objetos y ponerlo en el menu
	private String tienda = "Tienda";
	private Almacen Alm;
	private Registro_Empleados Rem;
	private Pedido pedido;
	private Administracion_ofertas ofer;
	private Oferta ofert;
	private Producto p;
	// Constructor

	public Tienda(String Empleados, String Productos, String Ofertas) throws FileNotFoundException, IOException {

		pedido = new Pedido();
		Rem = new Registro_Empleados();
		this.Rem.Registro_Empleados(Empleados);
		Alm = new Almacen(Productos);
		ofer = new Administracion_ofertas(Ofertas);

		identificarse();
		Menu_Tienda();
	}

	// Login
	public void identificarse() throws FileNotFoundException, IOException {

		Rem.login();

	}

	public void Menu_Tienda() throws FileNotFoundException, IOException {

		// Escaner
		Scanner sc = new Scanner(System.in);
		// Variables del menú
		boolean exit = false;
		int Opcion;

		do {
			System.out.println("Este es el menu principal de la Tienda");
			System.out.println("1. Hacer pedido");
			System.out.println("2. Almacen");
			System.out.println("3. Gestion empleado");
			System.out.println("4. Log out");

			Opcion = sc.nextInt();
			sc.nextLine();

			switch (Opcion) {

			case 1:
				pedido.Menu_pedido(Alm, ofer, Rem, ofert, p);
				break;
			case 2:
				Alm.Menu_Almacen();

				break;
			case 3:
				Rem.Menu_Empleado();
				break;
			case 4:
				identificarse();
				Menu_Tienda();
				exit = true;
				break;
			}
		} while (!exit);
	}
}
