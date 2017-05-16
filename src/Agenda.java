import java.util.ArrayList;

public class Agenda {
	
	static String nombre = "";
	static String apellido1 = "";
	static String apellido2 = "";
	static String telefono = "";
	static String email = "";
	static String fechaNacimiento = "";
	static  int posicion;
	//Agenda general de contactos
		public static ArrayList<Agenda> agendaContactos = new ArrayList<Agenda>();
		//Agenda auxiliar de contactos
		public static ArrayList<Agenda> agendaContactoAux = new ArrayList<Agenda>();
		//ArrayList de posiciones
		public static ArrayList<Integer> posicionList = new ArrayList<Integer>();
	
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
	
	//Este metodo Busca contactos dentro del arraylist agendaContactos y los que coinciden los mete en un arraylist de objetos auxiliar y los muestra
	public static  int buscarContacto(ArrayList<Agenda> agendaContactos,ArrayList<Agenda> agendaContactoAux,ArrayList<Integer> posicionList){
		//Limpia ArrayList cada vez que se utiliza al inicio.
		agendaContactoAux.clear();
			
		String buscarNombre = "";
		String contestacion = "";
		int posicion = 0;
		Integer posicionAuto = 0;
		
		//Nombre que se comparar�
		System.out.println("�Que contacto necesitas? (nombre)");
		buscarNombre = Entrada.cadena();
		
		//Se recorre el ArrayList y se compara el nombre introducido con la agenda de contactos auxiliar (ArrayList agendaContactosAux)
		System.out.println("Contacto/s encontrado/s en las posici�n/posiciones: ");
		for (int i = 0; i < agendaContactos.size(); i++) {
			
			if (agendaContactos.get(i).nombre.equals(buscarNombre)) {
			
				System.out.println("Posici�n: " + (i+1));
				i = posicionAuto;
				posicionList.add(posicionAuto);
				agendaContactoAux.add(new Agenda(agendaContactos.get(i).nombre, agendaContactos.get(i).apellido1, agendaContactos.get(i).apellido2, agendaContactos.get(i).telefono, agendaContactos.get(i).email, agendaContactos.get(i).fechaNacimiento));
				
			}	
		}
		
		//Si la agenda de contactos auxiliar est� vac�a, le pregunta si quiere a�adir nuevos contactos.
		if (agendaContactoAux.size() == 0) {
			
			System.out.println("No he encontrado el contacto. �Desea introducirlo?");
			contestacion = Entrada.cadena();
			
			if (contestacion.equals("Si") || contestacion.equals("S�") || contestacion.equals("SI") || contestacion.equals("S�") || contestacion.equals("si") ||contestacion.equals("S�")) {
											
				anadirContacto(agendaContactos);
				
			} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
				
				//Aqu� volver�a a la clase asistente
			}
		//Si la agenda de contactos auxiliar contiene alg�n objeto contacto, se recorre y se muestran los que coinciden 	
		} else if (agendaContactoAux.size() > 0) {
			
			//Mostramos todos los contactos que coinciden

			for (int i = 0; i < agendaContactoAux.size(); i++) {
				
				System.out.println("----------------------");
				System.out.println("Contacto" + (i+1)+ ":");
				System.out.println("Nombre:" + agendaContactoAux.get(i).nombre);
				System.out.println("Apellidos:" + agendaContactoAux.get(i).apellido1 + agendaContactoAux.get(i).apellido2);			
			}
			
			//Una vez mostrada la lista, la persona selecciona un n�meor de la lista (Se le resta uno poque se visualiza desde 1 pero el array se guarda desde 0)
			try {
				
			} catch (NumberFormatException NFE) {
				
				
			}
			
			int limite = 1;
			int contador = 0;
			
			while(limite!=contador){
				try {
					System.out.println("Seleccione el n�mero de la lista. (1, 2, 3...)");
					posicion = Entrada.entero();			
					
				} catch (NumberFormatException n) {
					System.out.println("No has introducido un n�mero. Seleccione el n�mero de la lista. (1, 2, 3...)");
					posicion = Entrada.entero();
				}
				contador++;
			}
			
			
			//Se muestra el contacto con dicha posici�n
			System.out.println("Contacto " + posicion + "completo de " + agendaContactoAux.get(posicion-1).nombre );
			System.out.println("Nombre:" + agendaContactoAux.get(posicion-1).nombre);
			System.out.println("Apellidos:" + agendaContactoAux.get(posicion-1).apellido1 + agendaContactoAux.get(posicion-1).apellido2);
			System.out.println("Telefono: " + agendaContactoAux.get(posicion-1).telefono);
			System.out.println("Correo electr�nico: " + agendaContactoAux.get(posicion-1).email);
			System.out.println("Fecha de nacimiento: " + agendaContactoAux.get(posicion-1).fechaNacimiento);

		}
		//Devuelve la posici�n+1 del contacto encontrado en la agenda de contactos auxiliar
		return posicion;
			
	}
		
	//Se podr� modificar un contacto que est� metido en el arraylist agenda contactos
	public String modificarContacto(){
		
		
		String contestacion = "";
		
		//Buscamos el contacto que queremos modificar
		buscarContacto(agendaContactos,agendaContactoAux,posicionList);
		
		//Recorremos la agenda de contactos
		for (int i = 0; i < agendaContactos.size(); i++) {
			
			//Comparamos el contacto de la agenda de contactos auxiliar con la de la agenda de contactos real.
			if (agendaContactos.get(i).nombre.equals(agendaContactoAux.get(posicion-1).nombre) & agendaContactos.get(i).apellido1.equals(agendaContactoAux.get(posicion-1).apellido1)) {
				
				//Si coinciden la agenda de contactos con la agenda de contactos auxiliar, se modifican los datos de la agenda de contactos principal
				System.out.println("Introduzca el nuevo nombre de " + agendaContactoAux.get(posicion-1).nombre + agendaContactoAux.get(posicion-1).apellido1 + "" );
				agendaContactos.get(i).nombre = Entrada.cadena();
				System.out.println("Introduzca el nuevo primer apellido");
				agendaContactos.get(i).apellido1 = Entrada.cadena();
				System.out.println("Introduzca el nuevo segundo apellido");
				agendaContactos.get(i).apellido2 = Entrada.cadena();
				System.out.println("Introduzca el nuevo telfono");
				agendaContactos.get(i).nombre = Entrada.cadena();
				System.out.println("Introduzca la nueva fecha de nacimeinto (dd/mm/yyyy)");
				agendaContactos.get(i).nombre = Entrada.cadena();
				
			//Si no se encuentra ninguna realaci�n (Cosa que ser�a un error), se permite a�adir un contacto si el usuario lo desea.
			} else {

				System.out.println("No lo he encontrado en la agenda de contactos... �Desea introducir un nuevo contacto? (Si, No)");
				contestacion = Entrada.cadena();
				
				if (contestacion.equals("Si") || contestacion.equals("S�") || contestacion.equals("SI") || contestacion.equals("S�") || contestacion.equals("si") ||contestacion.equals("S�")) {
									
					anadirContacto(agendaContactos);
					
				} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {

					//Aqu� volver�a a la clase asistente
					
				}
				
			}
				
		}
		//Se confirma la modificaci�n
		return "Modificado el contacto " + nombre + apellido1 + apellido2;
	}
	
	//Este metodo a�ade un contacto en el arraylist agendaContactos en forma de objeto
		public static String anadirContacto(ArrayList<Agenda> agendaContactos){
			
			//Este metodo a�adrir� contactos a un array de objetos.
			
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
			
			//Se a�ade el objeto agenda a agendaContactos
			agendaContactos.add(new Agenda(nombre, apellido1, apellido2, telefono, email, fechaNacimiento));
			
			//Se confima la inserci�n
			return "A�adido correctamente el contacto "+ nombre + apellido1 + apellido2 + ".";
			
		}
		
		//Este metodo elimina un objeto en la lista de agenda Contactos
		public String eliminarContacto(){
			
			//Se busca un contacto el buscarContacto(), 
			buscarContacto(agendaContactos,agendaContactoAux,posicionList);
			
			//Se recorre la agenda de contactos 
			for (int i = 0; i < agendaContactos.size(); i++) {
				
				//Se compara el resultado de la busqueda con los nombres reales de la agenda de contactos
				if (agendaContactos.get(i).nombre.equals(agendaContactoAux.get(posicion-1).nombre) & agendaContactos.get(i).apellido1.equals(agendaContactoAux.get(posicion-1).apellido1));
			
				//Si coinciden se elimina dicho contacto.
				agendaContactos.remove(i);
				
			} 
			
			return apellido1;
			
		}
		
		public static  int buscarNumero(ArrayList<Agenda> agendaContactos,ArrayList<Agenda> agendaContactoAux,ArrayList<Integer> posicionList){
			//Limpia ArrayList cada vez que se utiliza al inicio.
			agendaContactoAux.clear();
				
			String buscarTelefono = "";
			String contestacion = "";
			int posicion = 0;
			Integer posicionAuto = 0;
			
			//Nombre que se comparar�
			System.out.println("�Que contacto necesitas? (nombre)");
			buscarTelefono = Entrada.cadena();
			
			//Se recorre el ArrayList y se compara el nombre introducido con la agenda de contactos auxiliar (ArrayList agendaContactosAux)
			System.out.println("Contacto/s encontrado/s en las posici�n/posiciones: ");
			for (int i = 0; i < agendaContactos.size(); i++) {
				
				if (agendaContactos.get(i).telefono.equals(buscarTelefono)) {
				
					System.out.println("Posici�n: " + (i+1));
					i = posicionAuto;
					posicionList.add(posicionAuto);
					agendaContactoAux.add(new Agenda(agendaContactos.get(i).nombre, agendaContactos.get(i).apellido1, agendaContactos.get(i).apellido2, agendaContactos.get(i).telefono, agendaContactos.get(i).email, agendaContactos.get(i).fechaNacimiento));
					
				}	
			}
			
			//Si la agenda de contactos auxiliar est� vac�a, le pregunta si quiere a�adir nuevos contactos.
			if (agendaContactoAux.size() == 0) {
				
				System.out.println("No he encontrado el contacto. �Desea introducirlo?");
				contestacion = Entrada.cadena();
				
				if (contestacion.equals("Si") || contestacion.equals("S�") || contestacion.equals("SI") || contestacion.equals("S�") || contestacion.equals("si") ||contestacion.equals("S�")) {
												
					anadirContacto(agendaContactos);
					
				} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
					
					//Aqu� volver�a a la clase asistente
				}
			//Si la agenda de contactos auxiliar contiene alg�n objeto contacto, se recorre y se muestran los que coinciden 	
			} else if (agendaContactoAux.size() > 0) {
				
				//Mostramos todos los contactos que coinciden

				for (int i = 0; i < agendaContactoAux.size(); i++) {
					
					System.out.println("----------------------");
					System.out.println("Contacto" + (i+1)+ ":");
					System.out.println("Nombre:" + agendaContactoAux.get(i).nombre);
					System.out.println("Apellidos:" + agendaContactoAux.get(i).apellido1 + agendaContactoAux.get(i).apellido2);			
				}
				
				//Una vez mostrada la lista, la persona selecciona un n�meor de la lista (Se le resta uno poque se visualiza desde 1 pero el array se guarda desde 0)
				try {
					
				} catch (NumberFormatException NFE) {
					
					
				}
				
				int limite = 1;
				int contador = 0;
				
				while(limite!=contador){
					try {
						System.out.println("Seleccione el n�mero de la lista. (1, 2, 3...)");
						posicion = Entrada.entero();			
						
					} catch (NumberFormatException n) {
						System.out.println("No has introducido un n�mero. Seleccione el n�mero de la lista. (1, 2, 3...)");
						posicion = Entrada.entero();
					}
					contador++;
				}
				
				
				//Se muestra el contacto con dicha posici�n
				System.out.println("Contacto " + posicion + "completo de " + agendaContactoAux.get(posicion-1).nombre );
				System.out.println("Nombre:" + agendaContactoAux.get(posicion-1).nombre);
				System.out.println("Apellidos:" + agendaContactoAux.get(posicion-1).apellido1 + agendaContactoAux.get(posicion-1).apellido2);
				System.out.println("Telefono: " + agendaContactoAux.get(posicion-1).telefono);
				System.out.println("Correo electr�nico: " + agendaContactoAux.get(posicion-1).email);
				System.out.println("Fecha de nacimiento: " + agendaContactoAux.get(posicion-1).fechaNacimiento);

			}
			//Devuelve la posici�n+1 del contacto encontrado en la agenda de contactos auxiliar
			return posicion;
		}
}