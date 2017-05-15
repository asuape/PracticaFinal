import java.util.ArrayList;

public class Llamada {
	
	String nombre = "";
	String apellido1= "";
	String apellido2= "";
	int telefono= 0;
	String date;
	
	ArrayList<Llamada> registroLlamadas = new ArrayList<Llamada>();
	
	public Llamada() {}
	
	public Llamada(String nombre, String apellido1, String apellido2, int telefono, String date) {
		
		nombre=this.nombre;
		apellido1=this.apellido1;
		apellido2=this.apellido2;
		telefono = this.telefono;
		date=this.date;
		
	}
	
	public String llamarContacto(){
		
		Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
		
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {

			if (Agenda.agendaContactos.get(i).nombre.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).nombre) & Agenda.agendaContactos.get(i).apellido1.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).apellido1)){
			
				System.out.println("Llamando a " + Agenda.nombre + " al " + Agenda.telefono);
				registroLlamadas.add(new Llamada(nombre, apellido1,apellido2, telefono, date));
				
			} else {
				System.out.println("Contacto desconocido");
			}
			
			
		}
		return "Llamada a " + Agenda.nombre + " finalizada";
	}
	
	public String llamarNumero(){
		
		Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
		
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {

			if (Agenda.agendaContactos.get(i).telefono.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).telefono)){
			
				System.out.println("Llamando a " + Agenda.nombre + " al " + Agenda.telefono);
				registroLlamadas.add(new Llamada(nombre, apellido1,apellido2, telefono, date));
				
			} else {
				System.out.println("Numero desconocido");
			}
			
			
		}
		return "Llamada a " + Agenda.nombre + " finalizada";
	}
	
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