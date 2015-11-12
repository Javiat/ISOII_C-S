package Comunicacion;
import  presentacion.AplicacionPrincipal;
public class Comunicacion {
	public boolean comprobarComunicacion(int llamada){
		if(llamada==1){
			System.out.println("La comunicacion se ha producido correctamente");
			return true;
		}
		else{
			System.out.println("La comunicacion se ha producido correctamente");
			return false;
		}
	}
}
