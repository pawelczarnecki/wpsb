package tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class AntenaDataButton extends JButton implements ActionListener {
	private static final long serialVersionUID = -51132147249950499L;
	
	private Tab2JPanel tab2JPanel;

	private List<Antena> antenas;

	public AntenaDataButton(Tab2JPanel tab2JPanel, List<Antena> antenas) {
		super("Zmien dane");
		this.tab2JPanel = tab2JPanel;
		this.antenas = antenas;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By zmieniæ dane anten");
		setText("Dane stacji bazowych");
	}

	public void actionPerformed(ActionEvent e) {

		AntenaData okno = new AntenaData(tab2JPanel,antenas);
		// okno.dispose();
	}

}
