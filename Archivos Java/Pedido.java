package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Pedido {

	private double Precio;
	int nprocom;
	int selec;
	int cont;
	boolean exit = false;
	int[] Lista;

	public void Menu_pedido(Almacen almacen, Administracion_ofertas ofer, Registro_Empleados empl, Oferta of,
			Producto p) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		int Opcion;

		do {

			System.out.println("Este es el menu para hacer un pedido, ¿qué desea hacer?");
			System.out.println("1. Añadir producto");
			System.out.println("2. Mostrar productos");
			System.out.println("3. Mostrar precio");
			System.out.println("4. Imprimir factura y volver al menú principal");

			Opcion = sc.nextInt();
			sc.nextLine();

			switch (Opcion) {
			case 1:
				añadir_productos(almacen, p);

				break;
			case 2:
				mostrar_pedido(almacen);

				break;
			case 3:
				mostrar_precio(almacen, ofer, p, empl);

				break;
			case 4:
				imprimir_factura(empl, almacen);

				exit = true;
				break;

			}

		} while (!exit);
	}

	private void añadir_productos(Almacen almacen, Producto p) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);

		almacen.mostrar_productos();
		int N = almacen.total();
		Lista = new int[N];

		// Hacer el pedido

		for (cont = 0; cont < N; cont++) {
			System.out
					.println("¿Cuantos Productos: " + cont + " quiere comprar? \n (Cuidado con el numero de unidades)");
			selec = sc.nextInt();
			sc.nextLine();
			int X = almacen.darUnidades(cont);

			if (X == 0) {
				System.out.println("Producto agotado. Lo sentimos");
				Lista[cont] = 0;
			}
			if ((X - selec) < 0) {
				System.out.println("No disponemos de tantas unidades, seleccione las que quiera dentro del rango");
				añadir_productos(almacen,p);
				
			} else {

				int restar = (X - selec);
				almacen.cambiar(cont, restar);
				Lista[cont] = selec;

			}
		}
	}

	private void mostrar_pedido(Almacen almacen) throws FileNotFoundException, IOException {
		System.out.println("Los productos de tu pedido son:");

		for (int i = 0; i < Lista.length; i++) {

			System.out.println("Numero de unidades comprados: " + Lista[i]);
			almacen.darproducto(i);

		}

	}

	private void mostrar_precio(Almacen almacen, Administracion_ofertas ofer, Producto p, Registro_Empleados empl)
			throws FileNotFoundException, IOException {

		this.Precio = 0;
		for (int i = 0; i < Lista.length; i++) {

			double prec = almacen.getPrecio(i);
			String tipo = almacen.P_per(i);

			if (tipo.equals("si")) {
				Precio = Precio + (Lista[i] * prec);

			}
			if (tipo.equals("no")) {
				double pre = almacen.getPrecio(i);
				int ID = almacen.Ident(i);
				int uni = Lista[i];

				double precioperecedero = ofer.cacularPrecio(pre, uni, ID);

				Precio = Precio + precioperecedero;

			}
		}
		System.out.println("El precio final es: " + Precio);

	}

	private void imprimir_factura(Registro_Empleados empl, Almacen almacen) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cual es tu codigo?");
		int Codigo = sc.nextInt();
		sc.nextLine();
		empl.AñadirBonificacion(Codigo, Precio);
		mostrar_pedido(almacen);
		System.out.println("El precio final es: " + Precio);

	}

}