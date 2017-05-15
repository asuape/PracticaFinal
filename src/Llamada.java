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
	
}