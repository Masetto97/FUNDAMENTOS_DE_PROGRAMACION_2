package Hito_2;
public class Producto_No_Perecedero extends Producto {

	private int Oferta;

	public Producto_No_Perecedero(String Nombre, int Codigo, double precio, int Unidades, String Perecedero,
			int Oferta) {
		super(Nombre, Codigo, precio, Unidades, Perecedero);
		this.Oferta = Oferta;
	}
	
	// Oferta
	public int getOferta() {
		return Oferta;
	}

	public String toString() {
		return super.toString()+ ", No perecedero. " ;
	}

}
