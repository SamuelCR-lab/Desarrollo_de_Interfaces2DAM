package Repaso;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroMain {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList <Persona> listaEmpleados = new ArrayList<>();
	private static void buscarMaxSal() {
		listaEmpleados.sort(null);
		System.out.println(listaEmpleados);
		System.out.println("La persona que mas cobra: "+listaEmpleados.get(listaEmpleados.size()-1));
	}
	
	public static void menu() {
		boolean bandera = true;
		do {
		int eleccion =0;
		String dNI;
		String nombre;
		String apellidos;
		int salario;
		int numAsignaturas;
		boolean tutor;
		String estudios;
		int antiguedad;
		boolean salesiano;
		boolean turno;
		String fechaNacimiento;
		String sexo;
		boolean repetidor;
		
		
		System.out.println("Menu:\n"
				+ "1. Introducir un nuevo Administrativo\n"
				+ "2. Introducir un nuevo Directivo\n"
				+ "3. Introducir un nuevo Profesor\n"
				+ "4. Introducir un nuevo Alumno\n"
				+ "5. Introducir un nuevo Módulo\n"
				+ "6. Salir del menú\n");
		eleccion = entrada.nextInt();
		switch (eleccion){
		case 1:
			Administracion admin2 = new Administracion(null, null, null, 0, null, 0);
			System.out.print("Introduce el nombre del administrativo: ");
			nombre = entrada.nextLine();
			admin2.setNombre(nombre);
			System.out.print("Introduce los apellidos: ");
			apellidos = entrada.nextLine();
			admin2.setApellidos(apellidos);
			System.out.print("Introduce el DNI: ");
			dNI = entrada.nextLine();
			admin2.setdNI(dNI);
			System.out.print("Introduce el salario del administrativo: ");
			salario = entrada.nextInt();
			admin2.salario = salario;
			System.out.print("Introduce los estudios: ");
			estudios = entrada.nextLine();
			admin2.setEstudios(estudios);
			System.out.print("Introduce su Antigüedad");
			antiguedad = entrada.nextInt();
			admin2.setAntigüedad(antiguedad);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
			default:
				bandera = false;
		}
		
		
	}while(!bandera);
	}
	
	
	
	
	public static void main(String[] args) {
		




		listaEmpleados.add(new Profesor("y354833","Paco","Ramos ",1500,5,false));
		listaEmpleados.add(new Profesor("t435654","Marijose","Caridad Blanco",1800,6,true));
		listaEmpleados.add(new Administracion("378326O","Rigoberto","Fernandez Ruiz",2500,"ADE",8));
		listaEmpleados.add(new Directivo("3984645E","Maria Jesus","Garcia Rodriguez",2800,true,true));
		Modulo modulo1 = new Modulo("Acceso a Datos",5,listaEmpleados.get(0),false);
		Modulo modulo2 = new Modulo("Ingles de grado Superior",2,listaEmpleados.get(1),true);
		Alumno alumno1 = new Alumno("U3254655","Ignacio","Cuadrado Redondo",0, "19/12/2003","Hombre",false,modulo1);
		Alumno alumno2 = new Alumno("6438472OP","Sara","Perez",0, "12/05/2003","Mujer",false,modulo2);
		Alumno[] alumnos= {alumno1,alumno2};
		Modulo [] Modulos =  {modulo1,modulo2};
		for(int i = 0;i<2;i++) {
			System.out.println(""+alumnos[i].toString());
		}
		menu();
		
		
		buscarMaxSal();
	}
	
}
