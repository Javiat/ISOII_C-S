
import dominio.Contacto;
import presentacion.AplicacionPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionAñadirContacto {
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
				Contacto contactos=new Contacto(txtNombre.getText());
				modelo.addElement(contactos.getNombre());
		}
	}
}
