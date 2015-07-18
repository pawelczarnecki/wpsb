package tab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrawButton extends JButton implements ActionListener {
	private static final long serialVersionUID = -8082236412704993101L;
	
	private List<Antena> antenas;
	private JPanel drawingPane;

	private List<Building> buildings;

	public DrawButton(Tab2JPanel drawingPane, List<Antena> antenas, List<Building> buildings) {
		super("Narysuj");
		this.drawingPane = drawingPane;
		this.antenas = antenas;
		this.buildings = buildings;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Narysuj zasiêg");
		setText("Rysuj zasiêg");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Antena antena : antenas) {
			
			antena.drawLines(buildings);
		}
		drawingPane.revalidate();
		drawingPane.repaint();
	}

}
