package Hito_2;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Almacen {

	// Escanner

	Scanner sc = new Scanner(System.in);

	// Atributos

	private Producto[] Almacen;

	// Constructor del array de empleados

	public Almacen(String archivo) throws FileNotFoundException, IOException {

		String Nombre;
		int Codigo;
		double precio;
		int cont = 0;
		String Perecedero;
		int Dias;
		int Oferta;
		int Unidades;
		String No_Perecedero = "no";
		// Scanners para leer el fichero

		FileReader Fichero = new FileReader(archivo);
		Scanner b = new Scanner(Fichero);

		// Creador del array

		// Creador del array

		b.nextLine();
		int N = b.nextInt();
		Almacen = new Producto[N];
		b.nextLine();
		while (b.hasNext()) {

			b.nextLine();
			Codigo = b.nextInt();
			b.nextLine();
			b.nextLine();
			Nombre = b.nextLine();
			b.nextLine();
			precio = b.nextDouble();
			b.nextLine();
			b.nextLine();
			Unidades = b.nextInt();
			b.nextLine();
			b.nextLine();
			Perecedero = b.nextLine();
			b.nextLine();
			if (Perecedero.equals(No_Perecedero)) {
				Oferta = b.nextInt();
				if (b.hasNextLine()){
					b.nextLine();
				}
				Almacen[cont] = new Producto_No_Perecedero(Nombre, Codigo, precio, Unidades, Perecedero, Oferta);
				cont++;
				
			} else {
				Dias = b.nextInt();
				if (b.hasNextLine()){
					b.nextLine();
				}
				Almacen[cont] = new Producto_Perecedero(Nombre, Codigo, precio, Unidades, Perecedero, Dias);
				cont++;
				
			}
		}
	}

	// Menu
	public void Menu_Almacen() throws FileNotFoundException, IOException {

		boolean exit = false;

		do {
			System.out.println(
					"Esta usted en el almacen, ¿qué desea hacer? \n1. Mostrar productos \n2. Modificar producto \n3. Volver menu principal");

			int opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				mostrar_productos();
				break;
			case 2:
				modificar_producto();
				break;
			case 3:
				exit = true;
				break;

			}
		} while (!exit);

	}

	public void mostrar_productos() throws FileNotFoundException, IOException {

		System.out.println("Los productos disponibles en la tienda son: ");

		for (int i = 0; i < Almacen.length; i++) {

			System.out.println(Almacen[i]);
		}
	}

	public void modificar_producto() throws FileNotFoundException, IOException {
		boolean exit = false;

		do {
			System.out.println("¿Qué producto desea modificar?");
			int producto_elegido = sc.nextInt();
			System.out
					.println("¿Qué desea modificar? \n1. Modificar nombre \n2. Modificar código \n3. Modificar precio \n4. Modificar unidades");
			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Introduzca nombre nuevo: ");
				String nombre = sc.next();
				System.out.println("El nombre se ha guardado como: " + Almacen[producto_elegido].setNombre(nombre));
				exit = true;
				break;
			case 2:
				System.out.println("Introduzca código nuevo: ");
				int codigo = sc.nextInt();
				System.out.println("El código se ha guardado como: " + Almacen[producto_elegido].setCodigo(codigo));
				exit = true;
				break;
			case 3:
				System.out.println("Introduzca precio nuevo: ");
				double precio = sc.nextDouble();
				sc.nextLine();
				System.out.println("El precio se ha guardado como: " + Almacen[producto_elegido].setPrecio(precio));
				exit = true;
				break;
			case 4:
				System.out.println("Introduzca nº de unidades nuevo: ");
				int unidades = sc.nextInt();
				System.out.println("Las unidades se han guardado como: " + Almacen[producto_elegido].setUnidades(unidades));
				exit = true;
				break;
			}
		} while (!exit);

	}

	public Almacen Ver_producto(int selec) {
		Almacen[selec].getNombre();
		Almacen[selec].getPrecio();
		Almacen[selec].getCodigo();
		return null;

	}

	public double getPrecio(int i) {
		double E;
		E=Almacen[i].getPrecio();
		return E;
	}

	public void  darproducto(int n) {
		System.out.println(Almacen[n]);
	}
	
	public String  P_per(int n) {
		String X=Almacen[n].getPerecedero();
		return  X;
	}

	public int Ident(int i){
		int Iden;
		
		Iden=Almacen[i].getOferta();
		
		return Iden;
	}
public int total(){
	int X=Almacen.length;
	return X;
	
}

public int darUnidades(int i){
	int Y=Almacen[i].getUnidades();
	return Y;
	
}
public void cambiar(int cont,int i){
	Almacen[cont].setUnidades(i);
	
	
}
	

}