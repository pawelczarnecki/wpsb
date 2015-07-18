package tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class OtherDataButton extends JButton implements ActionListener {

	private Tab2JPanel tab2JPanel;
	private List<Building> buildings;
	
	public OtherDataButton(Tab2JPanel tab2JPanel,List<Building> buildings) {
		super("Zmien dane");
		this.tab2JPanel = tab2JPanel;
		this.buildings=buildings;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By zmieniæ dane przestrzeni");
		setText("Dane przestrzeni");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		OtherData okno = new OtherData(tab2JPanel,buildings);

		}
	
}
