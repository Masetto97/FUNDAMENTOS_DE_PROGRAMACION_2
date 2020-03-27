package Hito_2;

public class Empleado_Nocturno extends Empleado {

	private double Plus;
	private double plusnoc;
	public Empleado_Nocturno(String Nombre, int codigo, String Contraseña, int Nivel, double Plus, String Turno) {
		super(Nombre, codigo, Contraseña, Turno, Nivel);
		this.Plus = Plus;
	}

	public double getPlus() {
		plusnoc = Plus / 100;
		return plusnoc;
	}

	public String toString() {
		return super.toString() + ", Plusnocturnidad: " + getPlus();
	}

	@Override
	public double getretencion() {
		return 0;
	}

}