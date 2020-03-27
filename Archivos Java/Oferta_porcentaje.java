package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Oferta_porcentaje extends Oferta {

	private int tantoporciento;
	private int maximo;

	public Oferta_porcentaje(int idOferta, int tantoporciento, int maximo) {
		super(idOferta);
		this.tantoporciento = tantoporciento;
		this.maximo = maximo;
	}

	public int tantoporciento() {
		return tantoporciento;
	}
	public int maximo() {
		return maximo;
	}
	public String toString() {
		return super.toString() + "Tanto porciento (%): " + tantoporciento + "% /n Maximo: "+maximo;
	}
	public double Oferta_porcentaje (int numero_productos, double precio) {
		
		double preciofinal=(numero_productos*precio)-(numero_productos*precio*tantoporciento());
		
				
		return preciofinal;
	
			
			
		}




	@Override
	public double Oferta3x2(int numero_productos, double precio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Oferta2x1(int numero_productos, double precio) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double Oferta_porcentaje(int idOferta, int tantoporciento) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}

