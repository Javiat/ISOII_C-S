import dominio.Contacto;
import presentacion.AplicacionPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dominio.Contacto;

public class GestionModificarContacto {
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			modelo.remove(index);
			Contacto contactos=new Contacto(txtNombre.getText());
			modelo.add(index,contactos.getNombre());
			list.setModel(modelo);
		}
	}
}
