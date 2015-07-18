package tab5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import tab1.Building;
import tab1.OtherData;

public class LoadTextButton extends JButton implements ActionListener {

	private InfoCard infoCard;
	private String path;
	
	public LoadTextButton(InfoCard infoCard, String path) {
		super("Zmien dane");
		this.infoCard = infoCard;
		this.path = path;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Poka¿ ca³oœæ");
		setText("Artykul");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		TextFrame okno = new TextFrame(infoCard, path);
		}
	
}
