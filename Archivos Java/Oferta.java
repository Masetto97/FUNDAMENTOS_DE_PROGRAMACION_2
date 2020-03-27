package Hito_2;

public abstract class Oferta {

	private int idOferta;

	// Metodo constructor

	public Oferta(int idOferta) {

		this.idOferta = idOferta;

	}

	// Mostrar información
	// id
	public int getid() {
		return idOferta;
	}
	
	public abstract  double Oferta_porcentaje(int numero_productos, double precio );
	
	public abstract  double Oferta3x2(int numero_productos, double precio);
	
	public abstract  double  Oferta2x1(int numero_productos, double precio);


	
	// Modificar información

	public int setid(int idOferta) {
		return idOferta;
	}

	// To String
	public String toString() {
		return " idOferta: " + getid();
	}
}
