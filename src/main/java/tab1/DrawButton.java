package tab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrawButton extends JButton implements ActionListener {
	private static final long serialVersionUID = -8082236412704993101L;
	
	private List<AntennaDrawable> antennas;
	private JPanel drawingPane;

	private List<Building> buildings;

	public DrawButton(Tab2JPanel drawingPane, List<AntennaDrawable> antennas, List<Building> buildings) {
		super("Narysuj");
		this.drawingPane = drawingPane;
		this.antennas = antennas;
		this.buildings = buildings;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Narysuj zasiêg");
		setText("Rysuj zasiêg");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (AntennaDrawable antenna : antennas) {
			
			antenna.drawLines(buildings);
		}
		drawingPane.revalidate();
		drawingPane.repaint();
	}

}
