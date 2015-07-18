package tab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ZmienButton extends JButton implements ActionListener {

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

	public ZmienButton(BazaOkno bazaOkno) {
		super("Zmieñ");
		this.bazaOkno = bazaOkno;
		setVisible(true);
		addActionListener(this);
		setText("Zmieñ");
	}

	public void actionPerformed(ActionEvent e) {
		ok = true;

		if (Zakladka4.item.contains("Antena")) {
			ZmienAntena();
		} else if (Zakladka4.item.contains("Adres")) {
			ZmienAdres();
		} else if (Zakladka4.item.contains("Instalacja")) {
			ZmienInstalacja();
		} else if (Zakladka4.item.contains("Lokacje")) {
			ZmienLokacje();
		} else {
			System.out.println("wybrany:" + Zakladka4.item);
		}

	}

	private void ZmienLokacje() {
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
			String sql3 = "UPDATE  Lokacje l SET l.ID_instalacja='"+jTextField2+"',l.ID_adres='"+jTextField3+"',l.ID_antena='"+jTextField4+"' WHERE l.ID_lokacja ='"+jTextField1+"' ";
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

	private void ZmienInstalacja() {
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
	        
			String sql3 = "UPDATE  Instalacja  SET Data_instalacji='"+jTextField2+"',Zatwierdzil_Imie='"+jTextField3+"',Zatwierdzil_Nazwisko='"+jTextField4+"',Zatwierdzil_ID='"+jTextField5+"' WHERE ID_instalacja ='"+jTextField1+"' ";
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
			sql3 = "commit";
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

	private void ZmienAdres() {
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
			String sql3 = "UPDATE  Adres  SET Miejscowosc='"+jTextField2+"',Ulica='"+jTextField3+"',Numer_dzialki='"+jTextField4+"',Kod_pocztowy='"+jTextField5+"' ,Wojewodztwo='"+jTextField6+"' ,Miejsce_dzierzawione='"+jTextField7+"' ,Dodatkowy_opis_polozenia='"+jTextField8+"' WHERE ID_adres ='"+jTextField1+"' ";
			
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
			sql3 = "commit";
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

	private void ZmienAntena() {

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
			String sql3 = "UPDATE  Antena  SET Producent='"+jTextField2+"',Numer_identyfikacyjny='"+jTextField3+"',Czestotliwosc='"+jTextField4+"',Kat='"+jTextField5+"' ,Zysk='"+jTextField6+"' ,Rodzaj='"+jTextField7+"' WHERE ID_antena ='"+jTextField1+"' ";
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
			sql3 = "commit";
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
