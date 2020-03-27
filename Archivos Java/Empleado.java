package Hito_2;

public abstract class Empleado {

	private String Nombre;
	private int Codigo;
	private String Contrase�a;
	private int Nivel;
	private double Productividad = 0;
	private String Turno;

	// Metodo constructor

	public Empleado(String Nombre, int codigo, String Contrase�a, String Turno, int Nivel) {

		this.Nombre = Nombre;
		this.Codigo = codigo;
		this.Contrase�a = Contrase�a;
		this.Turno = Turno;
		this.Nivel = Nivel;

	}

	// Nivel
	public int getNivel() {
		return Nivel;
	}

	// Productividad
	public double getProductividad() {
		return Productividad;
	}

	// Metodo para mostrar informaci�n del Trabajador
	// Nombre
	public String getNombre() {
		return Nombre;
	}

	// Contrase�a
	public String getContrase�a() {
		return Contrase�a;
	}

	// Turno
	public String geTurno() {
		return Turno;
	}

	// Codigo
	public int getCodigo() {
		return Codigo;
	}

	// Metodos para modificar informaci�n
	// Nombre
	public String setNombre(String Nombre) {
		return this.Nombre = Nombre;

	}

	// Contrase�a
	public String setContrase�a(String Contrase�a) {
		return this.Contrase�a = Contrase�a;
	}
	
	// Productividad
	public double setProductividad(double total) {
		return this.Productividad = total;
	}


	// To String
	public String toString() {
		return " Nombre: " + getNombre() + ", C�digo: " + getCodigo() + ", Turno:" + geTurno() + ", Nivel: " + getNivel()+ ", Productividad: " + getProductividad();
	}

	public abstract double getPlus();

	public abstract double getretencion();
}
