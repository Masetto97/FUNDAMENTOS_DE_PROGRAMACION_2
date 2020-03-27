package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Oferta3x2 extends Oferta {

	public Oferta3x2(int idOferta) {
		super(idOferta);
		
	}
	
	
	public double Oferta3x2 (int numero_productos, double precio){

		double preciofinal=0;
			
		if (numero_productos==1 || numero_productos==2){
			preciofinal=numero_productos*precio;
			
		}else{
			
			preciofinal= (numero_productos-1)*precio;
		}
			
		return preciofinal;			
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


	@Override
	public double Oferta_porcentaje(int numero_productos, double precio) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
