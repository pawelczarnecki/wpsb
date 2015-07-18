package tab3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tab4.Edytuj;

public class AddAntenaButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 4806104302614326494L;
	private Zakladka3 zakladka3;
	private Edytuj edytuj;
	protected String IDanteny;
	protected String Producent;
	protected String NrIdentyfikacyjny;
	protected String Czestotliwosc;
	protected String Polaryzacja;
	protected String Zysk;
	protected String Rodzaj;
	protected String IDadres;
	protected String IDinstalacja;
	private boolean ok = true;
	String user="SYSTEM";
	String password="Csevgy32167";
	

	public AddAntenaButton(Zakladka3 zakladka3) {
		super("Zapisz antene");
		this.zakladka3 = zakladka3;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By zapisac.");

	}

	public AddAntenaButton(Edytuj edytuj) {
		super("Zapisz antene");
		this.edytuj = edytuj;
		setVisible(true);
		addActionListener(this);
		setToolTipText("By zapisac.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ok = true;
		// String pom="";
		// pom=pom+(Zakladka3.jTextField1.getText());
		//
		// PrintWriter writer = null;
		// //if(!pom.equals(""))
		// {
		// try {
		//
		// writer = new PrintWriter("dane/anteny/antena"+pom+".txt", "UTF-8");
		//
		//
		// } catch (FileNotFoundException | UnsupportedEncodingException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// }
		// //else
		// System.out.println("pusty wiersz, nie dodam");
		// //NewJPanel.jTextField1.selectAll();
		//
		// writer.println(Zakladka3.jTextField1.getText());
		// writer.println(Zakladka3.jTextField2.getText());
		// writer.println(Zakladka3.jTextField3.getText());
		// writer.println(Zakladka3.jTextField4.getText());
		// writer.println(Zakladka3.jTextField5.getText());
		// writer.println(Zakladka3.jTextField6.getText());
		// writer.println(Zakladka3.jTextField7.getText());
		// writer.println(Zakladka3.jTextField8.getText());
		// writer.println(Zakladka3.jTextField9.getText());
		//
		// //NewJPanel.jTextField1.selectAll();
		// writer.close();
		//

		ok=ChcekFields(ok);
		
		
		
		if (ok) {
			String sql1 = "INSERT INTO Antena (ID_antena, Producent, Numer_Identyfikacyjny,Czestotliwosc,Polaryzacja,Zysk,Rodzaj,ID_adres,ID_instalacja) VALUES ('"+IDanteny+"','"+Producent+"','"+NrIdentyfikacyjny+"','"+Czestotliwosc+"','"+Polaryzacja+"','"+Zysk+"','"+Rodzaj+"','"+IDadres+"','"+IDinstalacja+"')";
		
			System.out.println(sql1);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", user, password);
				
				Statement stmt1 = conn.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally
			{
				JOptionPane.showMessageDialog(null, "Dodano antene, jego numer ID to: "+IDanteny);
			}
			}

	}

	private boolean ChcekFields(boolean ok) {
		ok=true;
		try {
			IDanteny = Zakladka3.IDantenyField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: ID anteny");
			ok = false;
		}
		if (IDanteny.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj ID anteny!");
			ok = false;
		}
		
		try {
			Producent = Zakladka3.ProducentField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Producent");
			ok = false;
		}
		if (Producent.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj nazwe producenta!");
			ok = false;
		}
		
		try {
			NrIdentyfikacyjny = Zakladka3.NrIdentyfikacyjnyField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Numer identyfikacyjny");
			ok = false;
		}
		if (NrIdentyfikacyjny.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj Numer identyfikacyjny!");
			ok = false;
		}
		
		try {
			Czestotliwosc = Zakladka3.CzestotliwoscField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Czestotliwosc");
			ok = false;
		}
		if (Czestotliwosc.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj czestotliwosc!");
			ok = false;
		}
		
		try {
			Polaryzacja = Zakladka3.PolaryzacjaField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Polaryzacja");
			ok = false;
		}
		if (Polaryzacja.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj polaryzacje anteny!");
			ok = false;
		}
		
		try {
			Zysk = Zakladka3.ZyskField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Zysk");
			ok = false;
		}
		if (Zysk.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj Zysk anteny!");
			ok = false;
		}
		
		try {
			Rodzaj = Zakladka3.RodzajField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Rodzaj");
			ok = false;
		}
		if (Rodzaj.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj rodzaj anteny!");
			ok = false;
		}
		
		try {
			IDadres = Zakladka3.IDadresField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: IDadres");
			ok = false;
		}
		if (IDadres.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj ID adresu!");
			ok = false;
		}
		
		try {
			IDinstalacja = Zakladka3.IDinstalacjaField.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: ID instalacja");
			ok = false;
		}
		if (IDinstalacja.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj ID instalacji!");
			ok = false;
		}
		return ok;
	}
	
	

}
