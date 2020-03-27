package Hito_2;

public class Empleado_Diurno extends Empleado {

	private double retencion;
	private double reto;

	public Empleado_Diurno(String Nombre, int codigo, String Contraseña, int Nivel, double retencion, String Turno) {
		super(Nombre, codigo, Contraseña, Turno, Nivel);
		this.retencion = retencion;
	}

	public double getretencion() {
		reto = retencion / 100;
		return reto;

	}

	public String toString() {
		return super.toString() + ", Retencion: " + getretencion();
	}

	@Override
	public double getPlus() {
		return 0;
	}

}
