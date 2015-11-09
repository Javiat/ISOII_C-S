import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionBorrarContacto {
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			modelo.remove(index);
			list.setModel(modelo);
		}
	}
}
