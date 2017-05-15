import java.util.ArrayList;

public class Registro {

	//Almacenamos los registros de llamada como objetos
	ArrayList<Llamada> registroLlamadas = new ArrayList<Llamada>();
	
	//Mostraremos el registro de llamadas
	public String mostrarRegistro(ArrayList<Llamada> registroLlamadas){
		
		//Recorremos el arrayList del registro de llamadas para mostrarlo
		for (int i = 0; i < registroLlamadas.size(); i++) {
			
			System.out.println("-----------------");
			System.out.println("Registro " + (i+1));
			System.out.println("Contacto: " + registroLlamadas.get(i).nombre + registroLlamadas.get(i).apellido1 + registroLlamadas.get(i).apellido2);
			System.out.println("Número de teléfono: " + registroLlamadas.get(i).telefono);
			System.out.println("Fecha de realización: " + registroLlamadas.get(i).date);
			
		}
				
		return "Fin del registro.";
		
	}
	
	public String borrarRegistro(ArrayList<Llamada> registroLlamadas) {
		
		registroLlamadas.clear();
		
		return "Borrado de registro completado";	
	}
	
}
