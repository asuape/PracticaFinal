import java.util.ArrayList;

public class Agenda {
	
	String nombre = "";
	String apellido1 = "";
	String apellido2 = "";
	String telefono = "";
	String email = "";
	String fechaNacimiento = "";
	private int posicion;
	
	public Agenda(){
		
	}
	
	public Agenda(String nombre, String apellido1, String apellido2, String telefono, String email, String fechaNacimiento){
		
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	
	//Agenda general de contactos
	ArrayList<Agenda> agendaContactos = new ArrayList<Agenda>();
	//Agenda auxiliar de contactos
	ArrayList<Agenda> agendaContactoAux = new ArrayList<Agenda>();
	//ArrayList de posiciones
	ArrayList<Integer> posicionList = new ArrayList<Integer>();
	
	
	
	
	//Este metodo Busca contactos dentro del arraylist agendaContactos y los que coinciden los mete en un arraylist de objetos auxiliar
	public int buscarContacto(){
		
		agendaContactoAux.clear();
			
		String buscarNombre = "";
		String contestacion = "";
		int posicion = 0;
		Integer posicionAuto = 0;
		
		System.out.println("¿Que contacto necesitas? (nombre)");
		buscarNombre = Entrada.cadena();
				
		System.out.println("Contacto/s encontrado/s en las posición/posiciones: ");
		for (int i = 0; i < agendaContactos.size(); i++) {
			
			if (agendaContactos.get(i).nombre.equals(buscarNombre)) {
			
				System.out.println("Posición: " + (i+1));
				i = posicionAuto;
				posicionList.add(posicionAuto);
				agendaContactoAux.add(new Agenda(agendaContactos.get(i).nombre, agendaContactos.get(i).apellido1, agendaContactos.get(i).apellido2, agendaContactos.get(i).telefono, agendaContactos.get(i).email, agendaContactos.get(i).fechaNacimiento));
				
			}	
		}
		
		if (agendaContactoAux.size() == 0) {
			
			System.out.println("No he encontrado el contacto: ¿Desea introducirlo?");
			contestacion = Entrada.cadena();
			
			if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
											
				anadirContacto();
				
			} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
				
				//Aquí volvería a la clase asistente
			}
			
		} else if (agendaContactoAux.size() > 0) {
			
			//Mostramos todos los contactos con la coincidencia

			for (int i = 0; i < agendaContactoAux.size(); i++) {
				
				System.out.println("----------------------");
				System.out.println("Contacto" + (i+1)+ ":");
				System.out.println("Nombre:" + agendaContactoAux.get(i).nombre);
				System.out.println("Apellidos:" + agendaContactoAux.get(i).apellido1 + agendaContactoAux.get(i).apellido2);			
			}
			
			System.out.println("Seleccione el número de la lista. (1, 2, 3...)");
			posicion = Entrada.entero();
			
			System.out.println("Contacto " + posicion + "completo de " + agendaContactoAux.get(posicion-1).nombre );
			System.out.println("Nombre:" + agendaContactoAux.get(posicion-1).nombre);
			System.out.println("Apellidos:" + agendaContactoAux.get(posicion-1).apellido1 + agendaContactoAux.get(posicion-1).apellido2);
			System.out.println("Telefono: " + agendaContactoAux.get(posicion-1).telefono);
			System.out.println("Correo electrónico: " + agendaContactoAux.get(posicion-1).email);
			System.out.println("Fecha de nacimiento: " + agendaContactoAux.get(posicion-1).fechaNacimiento);

		}
		return posicion;
		
		//Aquí volvería a la clase asistente
			
	}
	
	//Este metodo añade un contacto en el arraylist agendaContactos en forma de objeto
	public String anadirContacto(){
		
		//Este metodo añadrirá contactos a un array de objetos.
		
		System.out.println("Introduzca los datos del contacto.");
		System.out.println("Nombre: ");
		nombre = Entrada.cadena();
		System.out.println("Apellido1: ");
		apellido1 = Entrada.cadena();
		System.out.println("Apellido2");
		apellido2 = Entrada.cadena();
		System.out.println("telefono");
		telefono = Entrada.cadena();
		System.out.println("email");
		email = Entrada.cadena();
		System.out.println("Fecha de nacimiento");
		fechaNacimiento = Entrada.cadena();
		
		agendaContactos.add(new Agenda(nombre, apellido1, apellido2, telefono, email, fechaNacimiento));
		
		return "Añadido correctamente el contacto "+ nombre + apellido1 + apellido2 + ".";
		
	}
	
	//Se podrá modificar un contacto que esté metido en el arraylist agenda contactos
	public String modificarContacto(){
		
		// Buscamos el contacto que queremos modificar
		String contestacion = "";
		
		buscarContacto();		
		
		for (int i = 0; i < agendaContactos.size(); i++) {
			
			System.out.println("Introduzca el nuevo nombre de " + agendaContactoAux.get(posicion-1).nombre );
			agendaContactos.get(i).nombre = Entrada.cadena();
			System.out.println("Introduzca el nuevo primer apellido");
			agendaContactos.get(i).apellido1 = Entrada.cadena();
			System.out.println("Introduzca el nuevo segundo apellido");
			agendaContactos.get(i).apellido2 = Entrada.cadena();
			System.out.println("Introduzca el nuevo telfono");
			agendaContactos.get(i).nombre = Entrada.cadena();
			System.out.println("Introduzca la nueva fecha de nacimeinto (dd/mm/yyyy)");
			agendaContactos.get(i).nombre = Entrada.cadena();
			
		}
		
		
			System.out.println("No lo he encontrado en la agenda de contactos... ¿Desea introducir un nuevo contacto? (Si, No)");
			contestacion = Entrada.cadena();
			
			if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
								
				anadirContacto();
				
			} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {

				//Añadir contacto
				
			}
		

		
		
	
		return "Modificado el contacto " + nombre + apellido1 + apellido2;
	}
	
}
