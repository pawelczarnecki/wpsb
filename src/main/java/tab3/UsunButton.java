package tab3;

import tab4.Edytuj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsunButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3833828825407687637L;
	private boolean ok = true;
	protected String IDanteny;
	protected String Producent;
	protected String NrIdentyfikacyjny;
	protected String Czestotliwosc;
	protected String Polaryzacja;
	protected String Zysk;
	protected String Rodzaj;
	protected String IDadres;
	protected String IDinstalacja;
	String user = "SYSTEM";
	String password = "Csevgy32167";

	public UsunButton(Zakladka3 zakladka3) {
		super("Usuñ antene");
		setVisible(true);
		addActionListener(this);
		setToolTipText("By usun¹æ.");

	}

	public UsunButton(Edytuj edytuj) {
		super("Usuñ antene");
		setVisible(true);
		addActionListener(this);
		setToolTipText("By usun¹æ.");

	}

	public void actionPerformed(ActionEvent arg0) {
		ok = true;
		ok = ChcekFields(ok);

		if (ok) {

			String sql1 = "DELETE FROM SaZyskhod  WHERE ID_antena='" + IDanteny
					+ "'";
			String sql2 = "commit";

			System.out.println(sql1);

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl", user,
							password);
					java.sql.Statement stmt = conn.createStatement();
					stmt.executeQuery(sql1);
					java.sql.Statement stmt1 = conn.createStatement();
					stmt1.executeQuery(sql2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Antena usuniêta z bazy!");
		}

	}

	private boolean ChcekFields(boolean ok) {
		ok = true;
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
			NrIdentyfikacyjny = Zakladka3.NrIdentyfikacyjnyField.getText()
					.toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: Numer identyfikacyjny");
			ok = false;
		}
		if (NrIdentyfikacyjny.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj Numer identyfikacyjny!");
			ok = false;
		}
		//
		// try {
		// Czestotliwosc = Zakladka3.CzestotliwoscField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: Czestotliwosc");
		// ok = false;
		// }
		// if (Czestotliwosc.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj czestotliwosc!");
		// ok = false;
		// }
		//
		// try {
		// Polaryzacja = Zakladka3.PolaryzacjaField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: Polaryzacja");
		// ok = false;
		// }
		// if (Polaryzacja.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj polaryzacje anteny!");
		// ok = false;
		// }
		//
		// try {
		// Zysk = Zakladka3.ZyskField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: Zysk");
		// ok = false;
		// }
		// if (Zysk.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj Zysk anteny!");
		// ok = false;
		// }
		//
		// try {
		// Rodzaj = Zakladka3.RodzajField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: Rodzaj");
		// ok = false;
		// }
		// if (Rodzaj.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj rodzaj anteny!");
		// ok = false;
		// }
		//
		// try {
		// IDadres = Zakladka3.IDadresField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: IDadres");
		// ok = false;
		// }
		// if (IDadres.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj ID adresu!");
		// ok = false;
		// }
		//
		// try {
		// IDinstalacja = Zakladka3.IDinstalacjaField.getText().toString();
		// } catch (NumberFormatException n) {
		// JOptionPane.showMessageDialog(null,
		// "B³êdny format danych w polu: ID instalacja");
		// ok = false;
		// }
		// if (IDinstalacja.length() == 0) {
		// JOptionPane.showMessageDialog(null, "Podaj ID instalacji!");
		// ok = false;
		// }
		return ok;
	}

}
