package tab4;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class BazaOkno extends JFrame {

	private JButton DodajButton;
	private JButton UsunButton;
	private JButton ZmienButton;
	public  JLabel jLabel1;
	public  JLabel jLabel2;
	public  JLabel jLabel3;
	public  JLabel jLabel4;
	public  JLabel jLabel5;
	public  JLabel jLabel6;
	public  JLabel jLabel7;
	public  JLabel jLabel8;
	public static JTextField jTextField1;
	public static JTextField jTextField2;
	public static JTextField jTextField3;
	public static JTextField jTextField4;
	public static JTextField jTextField5;
	public static JTextField jTextField6;
	public static JTextField jTextField7;
	public static JTextField jTextField8;
	public Zakladka4 zakladka4;

	public BazaOkno(Zakladka4 zakladka4) {
		this.zakladka4 = zakladka4;

		jTextField1 = new JTextField(7);
		jTextField2 = new JTextField(7);
		jTextField3 = new JTextField(7);
		jTextField4 = new JTextField(7);
		jTextField5 = new JTextField(7);
		jTextField6 = new JTextField(7);
		jTextField7 = new JTextField(7);
		jTextField8 = new JTextField(7);
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		//DodajButton = new JButton();
		ZmienButton = new JButton();
		UsunButton = new JButton();
		
		DodajButton dodajButton = new DodajButton(this);
		ZmienButton zmienButton = new ZmienButton(this);
		UsunButton usunButton = new UsunButton(this);

		String[] kolumny = new String[8];
		for (int i = 0; i < zakladka4.dtm.getColumnCount(); i++)
		{
			kolumny[i]=zakladka4.dtm.getColumnName(i);
			if ( kolumny[i].isEmpty()) 
				kolumny[i]="slowo";
		}
		jLabel1.setText(kolumny[0]);
		jLabel2.setText(kolumny[1]);
		jLabel3.setText(kolumny[2]);
		jLabel4.setText(kolumny[3]);
		jLabel5.setText(kolumny[4]);
		jLabel6.setText(kolumny[5]);
		jLabel7.setText(kolumny[6]);
		jLabel8.setText(kolumny[7]);
			
//		DodajButton.setText("Dodaj");

//		ZmienButton.setText("Zmien");

//		UsunButton.setText("Usun");

		
		ustawienie(dodajButton,zmienButton,usunButton);
	}

	private void ustawienie(DodajButton dodajButton,ZmienButton zmienButton, UsunButton usunButton) {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(50, 50, 50)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jLabel8,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel7,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel6,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel5,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel4,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel3,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2,
																						GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1,
																						GroupLayout.Alignment.LEADING))
																.addGap(157,
																		157,
																		157)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField1,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField2,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField3,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField4,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField5,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField6,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField7,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField8,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		dodajButton)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		zmienButton)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		usunButton)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField2,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField3,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField4,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField5,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField6,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(
														jTextField7,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														jTextField8,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(dodajButton)
												.addComponent(zmienButton)
												.addComponent(usunButton))
								.addContainerGap(25, Short.MAX_VALUE)));

		//DodajButton.getAccessibleContext().setAccessibleName("Dodaj");

		pack();
	}

}
