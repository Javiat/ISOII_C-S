import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dominio.Contacto;

public class GestionAñadirContacto {
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
				Contacto contactos=new Contacto(txtNombre.getText());
				modelo.addElement(contactos.getNombre());
		}
	}
}
