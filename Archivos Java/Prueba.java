package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Prueba {
	 private static Tienda tien;
 
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 tien= new Tienda("c:/Users/Eduardo/Desktop/empleados2.txt", "c:/Users/Eduardo/Desktop/productos2.txt", "c:/Users/Eduardo/Desktop/ofertas.txt");
		 
		
	}
}