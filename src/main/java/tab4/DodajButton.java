package tab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DodajButton extends JButton implements ActionListener {
	String user = "SYSTEM";
	String password = "Csevgy32167";
	private BazaOkno bazaOkno;
	boolean ok;
	private String jTextField1;
	private String jTextField2;
	private String jTextField3;
	private String jTextField4;
	private String jTextField5;
	private String jTextField6;
	private String jTextField7;
	private String jTextField8;
	protected int maxId;
	protected int id;

	public DodajButton(BazaOkno bazaOkno) {
		super("Dodaj");
		this.bazaOkno = bazaOkno;
		setVisible(true);
		addActionListener(this);
		setText("Dodaj");
	}

	public void actionPerformed(ActionEvent e) {
		ok = true;

		if (Zakladka4.item.contains("Antena")) {
			DodajAntena();
		} else if (Zakladka4.item.contains("Adres")) {
			DodajAdres();
		} else if (Zakladka4.item.contains("Instalacja")) {
			DodajInstalacja();
		} else if (Zakladka4.item.contains("Lokacje")) {
			DodajLokacje();
		} else {
			System.out.println("wybrany:" + Zakladka4.item);
		}

	}

	private void DodajLokacje() {
		try {
			jTextField1 = BazaOkno.jTextField1.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 1");
			ok = false;
		}
		if (jTextField1.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 1!");
			ok = false;
		}

		try {
			jTextField2 = BazaOkno.jTextField2.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 2");
			ok = false;
		}
		if (jTextField2.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 2!");
			ok = false;
		}
		try {
			jTextField3 = BazaOkno.jTextField3.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 3");
			ok = false;
		}
		if (jTextField3.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 3!");
			ok = false;
		}
		try {
			jTextField4 = BazaOkno.jTextField4.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 4");
			ok = false;
		}
		if (jTextField4.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 4!");
			ok = false;
		}
		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "insert into  Lokacje l (l.ID_lokacja,l.ID_instalacja,l.ID_adres,l.ID_antena) values ('"
					+ jTextField1
					+ "','"
					+ jTextField2
					+ "','"
					+ jTextField3
					+ "','" + jTextField4 + "')";
			System.out.println(sql3);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl", user,
							password);
					Statement stmt1 = conn.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				// JOptionPane.showMessageDialog(null,
				// "Dodano klienta, jego numer ID to: "+maxId);
			}

		}
	}

	private void DodajInstalacja() {
		try {
			jTextField1 = BazaOkno.jTextField1.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 1");
			ok = false;
		}
		if (jTextField1.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 1!");
			ok = false;
		}

		try {
			jTextField2 = BazaOkno.jTextField2.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 2");
			ok = false;
		}
		if (jTextField2.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 2!");
			ok = false;
		}
		try {
			jTextField3 = BazaOkno.jTextField3.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 3");
			ok = false;
		}
		if (jTextField3.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 3!");
			ok = false;
		}
		try {
			jTextField4 = BazaOkno.jTextField4.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 4");
			ok = false;
		}
		if (jTextField4.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 4!");
			ok = false;
		}
		try {
			jTextField5 = BazaOkno.jTextField5.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 5");
			ok = false;
		}
		if (jTextField5.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 5!");
			ok = false;
		}

		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "insert into Instalacja i (i.ID_instalacja,i.Data_instalacji,i.Zatwierdzil_Imie,i.Zatwierdzil_Nazwisko,i.Zatwierdzil_ID) values ('"
					+ jTextField1
					+ "','"
					+ jTextField2
					+ "','"
					+ jTextField3
					+ "','" + jTextField4 + "','" + jTextField5 + "')";
			System.out.println(sql3);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl", user,
							password);
					Statement stmt1 = conn.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				// JOptionPane.showMessageDialog(null,
				// "Dodano klienta, jego numer ID to: "+maxId);
			}
		}
	}

	private void DodajAdres() {
		try {
			jTextField1 = BazaOkno.jTextField1.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 1");
			ok = false;
		}
		if (jTextField1.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 1!");
			ok = false;
		}

		try {
			jTextField2 = BazaOkno.jTextField2.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 2");
			ok = false;
		}
		if (jTextField2.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 2!");
			ok = false;
		}
		try {
			jTextField3 = BazaOkno.jTextField3.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 3");
			ok = false;
		}
		if (jTextField3.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 3!");
			ok = false;
		}
		try {
			jTextField4 = BazaOkno.jTextField4.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 4");
			ok = false;
		}
		if (jTextField4.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 4!");
			ok = false;
		}
		try {
			jTextField5 = BazaOkno.jTextField5.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 5");
			ok = false;
		}
		if (jTextField5.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 5!");
			ok = false;
		}
		try {
			jTextField6 = BazaOkno.jTextField6.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 6");
			ok = false;
		}
		if (jTextField6.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 6!");
			ok = false;
		}
		try {
			jTextField7 = BazaOkno.jTextField7.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 7");
			ok = false;
		}
		if (jTextField7.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 7!");
			ok = false;
		}
		try {
			jTextField8 = BazaOkno.jTextField8.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 8");
			ok = false;
		}
		if (jTextField8.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 8!");
			ok = false;
		}
		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "insert into Adres a (a.ID_adres,a.Miejscowosc,a.Ulica,a.Numer_dzialki,a.Kod_pocztowy,a.Wojewodztwo,a.Miejsce_dzierzawione,a.Dodatkowy_opis_polozenia) values ('"
					+ jTextField1
					+ "','"
					+ jTextField2
					+ "','"
					+ jTextField3
					+ "','"
					+ jTextField4
					+ "','"
					+ jTextField5
					+ "','"
					+ jTextField6
					+ "','"
					+ jTextField7
					+ "','"
					+ jTextField8
					+ "')";
			System.out.println(sql3);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl", user,
							password);
					Statement stmt1 = conn.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				// JOptionPane.showMessageDialog(null,
				// "Dodano klienta, jego numer ID to: "+maxId);
			}
		}
	}

	private void DodajAntena() {

		try {
			jTextField1 = BazaOkno.jTextField1.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 1");
			ok = false;
		}
		if (jTextField1.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 1!");
			ok = false;
		}

		try {
			jTextField2 = BazaOkno.jTextField2.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 2");
			ok = false;
		}
		if (jTextField2.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 2!");
			ok = false;
		}
		try {
			jTextField3 = BazaOkno.jTextField3.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 3");
			ok = false;
		}
		if (jTextField3.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 3!");
			ok = false;
		}
		try {
			jTextField4 = BazaOkno.jTextField4.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 4");
			ok = false;
		}
		if (jTextField4.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 4!");
			ok = false;
		}
		try {
			jTextField5 = BazaOkno.jTextField5.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 5");
			ok = false;
		}
		if (jTextField5.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 5!");
			ok = false;
		}
		try {
			jTextField6 = BazaOkno.jTextField6.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 6");
			ok = false;
		}
		if (jTextField6.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 6!");
			ok = false;
		}
		try {
			jTextField7 = BazaOkno.jTextField7.getText().toString();
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,
					"B³êdny format danych w polu: 7");
			ok = false;
		}
		if (jTextField7.length() == 0) {
			JOptionPane.showMessageDialog(null, "Podaj 7!");
			ok = false;
		}

		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "insert into Antena a (a.ID_antena,a.Producent,a.Numer_identyfikacyjny,a.Czestotliwosc,a.Kat,a.Zysk,a.Rodzaj) values ('"
					+ jTextField1
					+ "','"
					+ jTextField2
					+ "','"
					+ jTextField3
					+ "','"
					+ jTextField4
					+ "','"
					+ jTextField5
					+ "','"
					+ jTextField6 + "','" + jTextField7 + "')";
			System.out.println(sql3);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl", user,
							password);
					Statement stmt1 = conn.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				// JOptionPane.showMessageDialog(null,
				// "Dodano klienta, jego numer ID to: "+maxId);
			}
		}

	}
}
