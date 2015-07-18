package praca;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tab1.Tab2JPanel;
import tab2.NewJPanel;
import tab3.Zakladka3;
import tab4.Zakladka4;
import tab5.InfoCard;

public class Okno extends JPanel {
	private static final long serialVersionUID = 4823301279983650071L;
	public final static String Menu = "Menu";
	public final static String Application = "Application";

	public Okno() {
		super(new CardLayout());
		JPanel card1 = new Kart1(this);

		JTabbedPane card2 = new JTabbedPane();
		
		
		
		ImageIcon icon = new ImageIcon("dane/11.png");
		ImageIcon icon2 = new ImageIcon("dane/12.png");
		ImageIcon icon3 = new ImageIcon("dane/15.png");
		ImageIcon icon4 = new ImageIcon("dane/14.png");

		JComponent panel1 = new Tab2JPanel();
		card2.setFocusable(false);
		
		card2.addTab("Projektowanie pokrycia", icon2, panel1,
				"Projektowanie pokrycia zasiêgiem");

		//JComponent panel2 = new NewJPanel();// Zakladka2();
		//card2.addTab("Porównanie anten", icon3, panel2,"Porównanie parametrów anten");

//		JComponent panel3 = new Zakladka3();
//		card2.addTab("Edycja bazy danych", icon4, panel3, "Edycja bazy danych");

		JComponent panel4 = new Zakladka4();
		card2.addTab("Baza danych", icon4, panel4, "Poka¿ bazê danych");
		
		JComponent panel5 = new InfoCard();
		card2.addTab("Informacje", icon, panel5, "Informacje");

		card2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		this.add(card1, Menu);
		this.add(card2, Application);
	}

}
