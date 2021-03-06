package tab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AntenaDataButton extends JButton implements ActionListener {
	private static final long serialVersionUID = -51132147249950499L;
	
	private Tab2JPanel tab2JPanel;

	private List<AntennaDrawable> antennas;

	public AntenaDataButton(Tab2JPanel tab2JPanel, List<AntennaDrawable> antennas) {
		super("Zmien dane");
		this.tab2JPanel = tab2JPanel;
		this.antennas = antennas;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By zmieni� dane anten");
		setText("Dane stacji bazowych");
	}

	public void actionPerformed(ActionEvent e) {

		AntenaData okno = new AntenaData(tab2JPanel, antennas);
		// okno.dispose();
	}

}
