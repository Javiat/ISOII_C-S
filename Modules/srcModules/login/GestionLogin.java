import dominio.Contacto;
import presentacion.AplicacionPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import presentacion.AplicacionPrincipal;

public class GestionLogin {
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			AplicacionPrincipal segundaVentana = new AplicacionPrincipal();
			segundaVentana.setVisible(true);
		}
	}
	private class TxtUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//lblAviso.setText("Evento de acción: ActionPerformed"+e.getActionCommand() );
			//Activamos los de la contraseña
			pwdfPassword.setEnabled(true);
			lblPassword.setEnabled(true);
			//Pasamos el foco (el cursor) al campo de la contraseña
			pwdfPassword.requestFocus();
		}
	}
	private class PwdfPasswordKeyListener extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			if (pwdfPassword.getText().equals("iso2")) {
				pwdfPassword.setBorder(bordeVerde);
				//lblCheck.setIcon(new ImageIcon(agenda.class.getResource("/presentacion/tick.png")));
				btnEntrar.setEnabled(true);
				
			} else{
				pwdfPassword.setBorder(bordeRojo);
				//lblCheck.setIcon(new ImageIcon(agenda.class.getResource("/presentacion/cross.png"))); }
			}
		}
	}
}
