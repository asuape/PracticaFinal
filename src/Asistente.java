public class Asistente {
	
	//Metodo principal
	public static void main(String[] args) {
		
		//Variables
		String texto="";
		boolean fin = false;
		
		//Bucle que contiene todo el programa
		while(fin==false) {
			
			//Se muestra por pantalla
			System.out.println("Hola, soy tu Asistente personal. Dime que necesitas.");
			texto = Entrada.cadena();
			String [] cadena = texto.split(" "); 
			
			for (int i=0; i<cadena.length; i++) {
				
				if (cadena[i].equals("buscar")) {
					
					String contestacion;
					//PONER WHILE AQUI
					System.out.println("¿Desea buscar un nombre de contacto o un número? (Escriba 'Contacto' o 'Número')");
					contestacion = Entrada.cadena();
					
					if (contestacion.equals("Contacto") || contestacion.equals("contacto")){
						Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux,Agenda.posicionList);
					} else if (contestacion.equals("Número") || contestacion.equals("número") || contestacion.equals("Numero") || contestacion.equals("numero")){
						Agenda.buscarNumero(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
					} else {
						System.out.println("Lo siento, no le he entendido");
					}
					
				} else if (cadena[i].equals("añadir")){
					
					Agenda.anadirContacto(Agenda.agendaContactos);
					
				} else if (cadena[i].equals("modificar")){
					
					Agenda.modificarContacto();			
					
				} else if (cadena[i].equals("eliminar ")){
					
					Agenda.eliminarContacto();
					
				} else if (cadena[i].equals("llamar")){
					
					String contestacion;
					//PONER WHILE AQUI	
					System.out.println("¿Desea llamar a un contacto o un número de teléfono? (Escriba 'Contacto' o 'Número')");
					contestacion = Entrada.cadena();
						
					if (contestacion.equals("Contacto") || contestacion.equals("contacto")){
						Llamada.llamarContacto();
					} else if (contestacion.equals("Número") || contestacion.equals("número") || contestacion.equals("Numero") || contestacion.equals("numero")){
						Llamada.llamarNumero();
					} else {
						System.out.println("Lo siento, no le he entendido");
					}
					
				} else if (cadena[i].equals("mostrar")){
					
					Llamada.mostrarRegistro(Llamada.registroLlamadas);
					
				} else if (cadena[i].equals("enviar")){
													
					Correo.enviarCorreo();
					
				} else if (cadena[i].equals("ver")){
				
					Correo.verCorreos(Correo.bandejaSalida);
					
				} else if (cadena[i].equals("borrar")){
					
					boolean fin1 = false;
					String contestacion;
					while (fin1 = false) {
					
						System.out.println("¿Desea llamar a un contacto o un número de teléfono? (Escriba 'Contacto' o 'Número')");
						contestacion = Entrada.cadena();
							
						if (contestacion.equals("X") || contestacion.equals("X")){
							Llamada.borrarRegistro(Llamada.registroLlamadas);
							fin1=true;
						} else if (contestacion.equals("X") || contestacion.equals("X")){
							Correo.borrarBandeja(Correo.bandejaSalida);
							fin1=true;
						} else {
							System.out.println("Lo siento, no le he entendido");
						}
						
					}
									
				}
			}	
			
		}
		
	}

}