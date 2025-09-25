package Repaso;

public class Administracion extends Persona {
	int salario;
	String estudios;
	int antiguedad;
	public Administracion(String dNI, String nombre, String apellidos, int salario, String estudios, int antigüedad) {
		super(dNI, nombre, apellidos,salario);
		this.salario = salario;
		this.estudios = estudios;
		this.antiguedad = antigüedad;
	}

	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public int getAntigüedad() {
		return antiguedad;
	}
	public void setAntigüedad(int antigüedad) {
		this.antiguedad = antigüedad;
	}
	@Override
	public String toString() {
		return "Administracion"+super.toString()+" Salario= " + salario + ", Estudios= " + estudios + ", Antigüedad= " + antiguedad;
	}

	@Override
	protected int getsalario() {
		// TODO Auto-generated method stub
		return salario;
	}


	
}
