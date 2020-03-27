package Hito_2;

public class Producto_Perecedero extends Producto {

	private int Dias;
	
  
	
	
	public Producto_Perecedero(String Nombre, int Codigo, double precio, int Unidades, String Perecedero,int Dias) {
		super(Nombre, Codigo, precio, Unidades, Perecedero);
		this.Dias = Dias;

	}
	public int getdias(){
		return Dias;
	
	}

	public String toString() {
		return super.toString()+ ", Perecedero(dias): " +Dias ;
	}
	
	public int getOferta() {
		// TODO Auto-generated method stub
		return 0;
	}
}
