package Hito_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Registro_Empleados {

	// Atributos

	private Empleado[] Empleados;
	private String codigo111 = "Error. Login incorrecto";
	private String codigo222 = "Error. Password incorrecto";
	private String Diario = "diurno";
	private String Noche = "nocturno";

	// Escaner
	Scanner sc = new Scanner(System.in);
	// Constructor del array de empleados

	public void Registro_Empleados(String archivo) throws FileNotFoundException, IOException {
		String Nombre;
		int Codigo;
		String Contraseña;
		int Nivel;
		int cont = 0;
		double retencion;
		double PlusNocturnidad;
		String Turno;

		// Scanners para leer el fichero

		FileReader Fichero = new FileReader(archivo);
		Scanner c = new Scanner(Fichero);

		// Creador del array

		c.nextLine(); // Salto de linea
		int N = c.nextInt();
		Empleados = new Empleado[N];
		c.nextLine();
		while (c.hasNext()) {
			c.nextLine();
			Nombre = c.nextLine();
			c.nextLine();
			Codigo = c.nextInt();
			c.nextLine();
			c.nextLine();
			Contraseña = c.nextLine();
			c.nextLine();
			Nivel = c.nextInt();
			c.nextLine();
			c.nextLine();
			Turno = c.nextLine();
			c.nextLine();

			if (Turno.equals(Diario)) {
				retencion = c.nextDouble();
				c.nextLine();
				Empleados[cont] = new Empleado_Diurno(Nombre, Codigo, Contraseña, Nivel, retencion, Turno);
				cont++;

			}
			if (Turno.equals(Noche)) {
				PlusNocturnidad = c.nextDouble();

				if (c.hasNextLine()) {
					c.nextLine();
				}

				Empleados[cont] = new Empleado_Nocturno(Nombre, Codigo, Contraseña, Nivel, PlusNocturnidad, Turno);
				cont++;

			}
		}
	}

	// Comparar
	public void Compara_code(int Codigo, double Precio) {

		int i = 0;
		int Code;

		do {
			Code = Empleados[i].getCodigo();
			i++;
		} while (Code != Codigo);

	}

	// Menu
	public void Menu_Empleado() throws FileNotFoundException, IOException {

		boolean exit = false;

		do {
			System.out.println(
					"Esta usted en el registro de empleados, ¿qué desea hacer? \n1. Mostrar empleados \n2. Modificar Contraseña \n3. Volver menu principal");

			int opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				mostrar_empleados();
				break;
			case 2:
				modificar_empleado();
				break;
			case 3:
				exit = true;
				break;

			}
		} while (!exit);

	}

	public void modificar_empleado() throws FileNotFoundException, IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué empleado/a desea modificar?");
		int emp = sc.nextInt();
		System.out.println("¿Qué desea modificar? \n1. Modificar nombre \n2. Modificar contraseña ");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("Introduzca nombre nuevo: ");
			String nom = sc.next();
			System.out.println("El nombre se ha guardado como: " + Empleados[emp].setNombre(nom));

			break;
		case 2:
			System.out.println("Introduzca contraseña nueva: ");
			String con = sc.next();
			System.out.println("La contreseña se ha guardado como: " + Empleados[emp].setContraseña(con));

			break;

		}

	}

	// toString
	public void mostrar_empleados() throws FileNotFoundException, IOException {

		System.out.println("Los empleados en la tienda son: ");

		for (int i = 0; i < Empleados.length; i++) {

			System.out.println(Empleados[i]);

		}
	}

	public void AñadirBonificacion(int codigo, double precio) throws FileNotFoundException, IOException {

		logincod(codigo);

		double total = 0;
		boolean exit = false;

		do {

			for (int i = 0; i < Empleados.length;) {

				int Cod = Empleados[i].getCodigo();
				double Produc = Empleados[i].getProductividad();
				String tur = Empleados[i].geTurno();
				double reten = Empleados[i].getretencion();

				if (Cod == codigo) {
					if (tur.equals(Diario)) {

						int Nivel = Empleados[i].getNivel();

						switch (Nivel) {
						case 1:
							total = Produc + Nivel;
							Empleados[i].setProductividad(total);
							System.out.println("La productividad es: " + total);
							exit = true;
							break;
						case 2:
							if (precio <= 300) {
								total = Produc + Nivel;
								Empleados[i].setProductividad(total);
								System.out.println("La productividad es: " + total);
								exit = true;
							}
							if (precio > 300) {
								total = Produc + (Nivel - (Nivel * reten));
								Empleados[i].setProductividad(total);
								System.out.println("La productividad es: " + total);
							}
							exit = true;
							break;
						case 3:
							total = Produc + (Nivel - (Nivel * reten));
							Empleados[i].setProductividad(total);
							System.out.println("La productividad es: " + total);
							exit = true;
							break;
						}
					}
					if (tur.equals(Noche)) {
						int Nivel = Empleados[i].getNivel();
						double plus = Empleados[i].getPlus();
						
						total = Produc + (Nivel + (precio * plus));
						Empleados[i].setProductividad(total);
						System.out.println("La productividad es: " + total);
						exit = true;
					}

				}

				i++;
			}
		} while (!exit);
	}

	public boolean login() throws FileNotFoundException, IOException {

		Scanner read = new Scanner(System.in);
		System.err.println("Introduce Codigo");
		int codigo = read.nextInt();
		System.err.println("Introduce Contraseña");
		String psw = read.next();

		try {
			int i = 0;
			while (true) {
				if (this.Empleados[i].getCodigo() != codigo && (this.Empleados[i].getContraseña() == null ? psw == null
						: this.Empleados[i].getContraseña().equals(psw))) {
					System.err.println(codigo111);
					System.err.println("Vuelva a repetir todo de nuevo");
					login();
					return false;
				}
				if (this.Empleados[i].getCodigo() == codigo && (this.Empleados[i].getContraseña() == null ? psw == null
						: this.Empleados[i].getContraseña().equals(psw))) {
					return true;
				}
				if (this.Empleados[i].getCodigo() == codigo && (this.Empleados[i].getContraseña() != psw)) {
					System.err.println(codigo222);
					System.err.println("Vuelva a repetir todo de nuevo");
					login();
					return false;
				}
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("No coincide nada");
			System.err.println("Vuelva a repetir todo de nuevo");
			login();
			return false;
		}

	}

	public boolean logincod(int codigo) throws FileNotFoundException, IOException {

		Scanner read = new Scanner(System.in);

		try {
			int i = 0;
			while (true) {

				if (this.Empleados[i].getCodigo() == codigo) {
					return true;
				}
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No coincide el codigo");
			System.out.println("Vuelva a repetir todo de nuevo");
			System.out.println("Introduce Codigo");
			int cod = read.nextInt();
			logincod(cod);
			return false;
		}

	}
}

