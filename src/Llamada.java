import java.util.ArrayList;

public class Llamada {
	
	String nombre = "";
	String apellido1= "";
	String apellido2= "";
	int telefono= 0;
	String fecha= "";
	
	public Llamada() {}
	
	public Llamada(String nombre, String apellido1, String apellido2, int telefono, String fecha) {
		
		nombre=this.nombre;
		apellido1=this.apellido1;
		apellido2=this.apellido2;
		telefono = this.telefono;
		fecha=this.fecha;
		
	}
	
	ArrayList<Llamada> arrayLlamadas= new ArrayList<>();
	
	public static void llamadaContacto(Agenda c1) {
		
		System.out.println("Llamando a " + c1.nombre + " al número " + c1.telefono);
		arrayLlamadas.add(c1.nombre);
		
	}
	
	public static void llamadaNumero(int numero) {
		
		System.out.println("Llamando al número " + numero);
		
	}
	
	public static void mostrarRegistro() {
		
		for(int i=0; i<arrayLlamadas.size(); i++) {
			
			
			
		}
		
	}
	

}
