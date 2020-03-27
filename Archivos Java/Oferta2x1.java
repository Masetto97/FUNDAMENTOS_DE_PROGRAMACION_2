package Hito_2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Oferta2x1 extends Oferta {

	public Oferta2x1(int idOferta) {
		super(idOferta);
		
	}
	
	
	public double Oferta2x1 (int numero_productos, double precio) {
		
		double preciofinal=0;
		
		if (numero_productos%2==0){
			preciofinal=(numero_productos/2)*precio;
    
		}else{
		   
			int Resta=numero_productos-1;
			int division=Resta/2;
			preciofinal=(division+1)*precio;
				
		}
		return preciofinal;
		
	}

	@Override
	public double Oferta3x2(int numero_productos, double precio) {
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


