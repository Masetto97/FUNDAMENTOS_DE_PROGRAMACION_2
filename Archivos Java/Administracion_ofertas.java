package Hito_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Administracion_ofertas {
	// Atributos

	private Oferta[] Ofertas;

	// Escaner
	Scanner sc = new Scanner(System.in);

	// Constructor del array de empleados
	public Administracion_ofertas(String archivo) throws FileNotFoundException, IOException {
		int idOferta;
		int cont = 0;
		String Tipo;
		int tantoporciento;
		int maximo;
		// Scanners para leer el fichero

		FileReader Fichero = new FileReader(archivo);
		Scanner d = new Scanner(Fichero);

		// Creador del array

		d.nextLine(); // Salto de linea
		int N = d.nextInt();
		Ofertas = new Oferta[N];
		d.nextLine();
		while (d.hasNext()) {

			d.nextLine();
			idOferta = d.nextInt();
			d.nextLine();
			d.nextLine();
			Tipo = d.nextLine();

			if (idOferta==12) {
				d.nextLine();
				tantoporciento = d.nextInt();
				d.nextLine();
				d.nextLine();
				maximo = d.nextInt();
				d.nextLine();
				Ofertas[cont] = new Oferta_porcentaje(idOferta, tantoporciento, maximo);
				cont++;

			}
			if (idOferta==11) {

				Ofertas[cont] = new Oferta2x1(idOferta);
				cont++;

			}
			if (idOferta==13) {

				Ofertas[cont] = new Oferta3x2(idOferta);
				cont++;
			}
		}
	}

	public Oferta getOferta(int i) {
		return Ofertas[i];
	}

	public double cacularPrecio(double precio, int numero, int Id) {
		boolean exit = false;
			double Precio=0;
			
			for (int j = 0; j < Ofertas.length;) {
				int ID = Ofertas[j].getid();

				if (ID == Id) {
					if (ID==11){
						Precio = Ofertas[j].Oferta2x1(numero, precio);
						return Precio;

					}if (ID==13){
						Precio = Ofertas[j].Oferta3x2(numero, precio);
						return Precio;
					}if (ID==12){
						Precio = Ofertas[j].Oferta_porcentaje(numero, precio);
						return Precio;
					}

				
				}else{
				
				j++;
			}
			}
			return 0;

	}

	public int MostrarOferta(int j) {
		for (int i = 0; i < Ofertas.length;) {

			int E = Ofertas[i].getid();

			if (j == E) {
				return E;

			}

			i++;
		}
		return 0;

	}

}
