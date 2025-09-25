package Repaso;

public abstract class Persona implements Comparable<Persona>{

	String dNI;
	String nombre;
	String apellidos;
	int salario;
	
	public Persona(String dNI, String nombre, String apellidos, int salario) {
		super();
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}

	public String getdNI() {
		return dNI;
	}
	public void setdNI(String dNI) {
		this.dNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	protected abstract int getsalario() ;

	
	@Override
	public String toString() {
		return " de DNI= " + dNI + ", Nombre= " + nombre + ", Apellidos= " + apellidos;
	}
	@Override
	public int compareTo(Persona o) {
		if(salario>o.getsalario()) 
			return 1;
		if(salario<o.getsalario())
			return -1;
		return 0;
	}

	

}
