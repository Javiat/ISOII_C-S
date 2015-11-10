import dominio.Contacto;
import presentacion.AplicacionPrincipal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class GestionLeerFichero {
	try{
		
		// Apertura del fichero y creacion de BufferedReader

		URL is = getClass().getResource("lista.txt");
		File archivo = new File(is.getPath());
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		// Lectura del fichero linea a linea
		String linea;
		while((linea=br.readLine())!=null) {
			modelo.addElement(linea);
			list.setModel(modelo);
			
		}
		br.close();
		//System.out.println("Fichero leído : " + file.getName() + ".");
	}
	catch (IOException ioe){
		System.out.println("Problemas mientras se leía el archivo");
	} 
}
