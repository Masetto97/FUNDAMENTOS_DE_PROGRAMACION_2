package Hito_2;

public abstract class Producto {

	private String Nombre;
	private int Codigo;
	private double Precio;
	private int Unidades;
	private String Perecedero;

	// Metodo constructor

	public Producto(String Nombre, int Codigo, double precio, int Unidades, String Perecedero) {

		this.Nombre = Nombre;
		this.Codigo = Codigo;
		this.Precio = precio;
		this.Unidades = Unidades;
		this.Perecedero = Perecedero;
	}

	// Metodo para mostrar información del producto
	// Nombre
	public String getNombre() {
		return Nombre;
	}
     //Perecedero
	public String getPerecedero() {
		return Perecedero;
	}
	
	// Precio
	public double getPrecio() {
		return Precio;
	}

	// Codigo
	public int getCodigo() {
		return Codigo;
	}
	// Unidades
	public int getUnidades() {
		return Unidades;
	}
	// Metodos para modificar productos
	// Nombre
	public String setNombre(String Nombre) {
		return this.Nombre = Nombre;
	}
	// Codigo

	public int setCodigo(int Codigo) {
		return this.Codigo = Codigo;
	}
	// Unidades

	public int setUnidades(int Unidad) {
		return this.Unidades = Unidad;
	}
      public abstract int getOferta();
	

	// Precio
	public double setPrecio(double Precio) {
		return this.Precio = Precio;
	}

	public String toString() {
		return " Nombre: " + getNombre() + ", Código:  " + getCodigo() + ", Precio: " + getPrecio()+ ", Unidades:  " + getUnidades();
	}
public boolean equals(Object p){
	return this==p||(p instanceof Producto && Codigo==((Producto)p).Codigo);
	
}
}