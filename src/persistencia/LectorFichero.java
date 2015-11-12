package persistencia;

import presentacion.AplicacionPrincipal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class LectorFichero {
	public static void leerFichero(){

		try{
			AplicacionPrincipal ap=new AplicacionPrincipal();

			// Apertura del fichero y creacion de BufferedReader

			URL is = ap.getClass().getResource("lista.txt");
			File archivo = new File(is.getPath());
			//File archivo = new File("/presentacion/lista.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			// Lectura del fichero linea a linea
			String linea;
			while((linea=br.readLine())!=null) {
				ap.getModelo().addElement(linea);
				ap.getList().setModel(ap.getModelo());
				
			}
			br.close();
			//System.out.println("Fichero leído : " + file.getName() + ".");
		}
		catch (IOException ioe){
			System.out.println("Problemas mientras se leía el archivo");
		} 
	}
}
