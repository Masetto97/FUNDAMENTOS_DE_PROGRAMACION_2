package Hito_2;

public abstract class Empleado {

	private String Nombre;
	private int Codigo;
	private String Contraseña;
	private int Nivel;
	private double Productividad = 0;
	private String Turno;

	// Metodo constructor

	public Empleado(String Nombre, int codigo, String Contraseña, String Turno, int Nivel) {

		this.Nombre = Nombre;
		this.Codigo = codigo;
		this.Contraseña = Contraseña;
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

	// Metodo para mostrar información del Trabajador
	// Nombre
	public String getNombre() {
		return Nombre;
	}

	// Contraseña
	public String getContraseña() {
		return Contraseña;
	}

	// Turno
	public String geTurno() {
		return Turno;
	}

	// Codigo
	public int getCodigo() {
		return Codigo;
	}

	// Metodos para modificar información
	// Nombre
	public String setNombre(String Nombre) {
		return this.Nombre = Nombre;

	}

	// Contraseña
	public String setContraseña(String Contraseña) {
		return this.Contraseña = Contraseña;
	}
	
	// Productividad
	public double setProductividad(double total) {
		return this.Productividad = total;
	}


	// To String
	public String toString() {
		return " Nombre: " + getNombre() + ", Código: " + getCodigo() + ", Turno:" + geTurno() + ", Nivel: " + getNivel()+ ", Productividad: " + getProductividad();
	}

	public abstract double getPlus();

	public abstract double getretencion();
}
