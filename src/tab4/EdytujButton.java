package tab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EdytujButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -7702368767951813540L;
	private Zakladka4 zakladka4;
	
	public EdytujButton(Zakladka4 zakladka4) {
		super("Edytuj");
		this.zakladka4 = zakladka4;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By dodaæ lub zmieniæ elementy bazy.");
		
	}
	public void actionPerformed(ActionEvent e) {

		BazaOkno okno = new BazaOkno(zakladka4);
		okno.setVisible(true);
		okno.setLocation(100, 100);
		}
	
}
