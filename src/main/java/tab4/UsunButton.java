package tab4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UsunButton extends JButton implements ActionListener {

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

	public UsunButton(BazaOkno bazaOkno) {
		super("Usuñ");
		this.bazaOkno = bazaOkno;
		setVisible(true);
		addActionListener(this);
		setText("Usuñ");
	}

	public void actionPerformed(ActionEvent e) {
		ok = true;

		if (Zakladka4.item.contains("Antena")) {
			UsunAntena();
		} else if (Zakladka4.item.contains("Adres")) {
			UsunAdres();
		} else if (Zakladka4.item.contains("Instalacja")) {
			UsunInstalacja();
		} else if (Zakladka4.item.contains("Lokacje")) {
			UsunLokacje();
		} else {
			System.out.println("wybrany:" + Zakladka4.item);
		}

	}

	private void UsunLokacje() {
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

		
		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "DELETE FROM  Lokacje WHERE ID_lokacja ='"+jTextField1+"' ";
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

	private void UsunInstalacja() {
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

		System.out.println("ok jest " + ok);
		if (ok) {
	        
			String sql3 = "DELETE FROM  Instalacja WHERE ID_instalacja ='"+jTextField1+"' ";
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

	private void UsunAdres() {
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
		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "DELETE FROM  Adres WHERE ID_adres ='"+jTextField1+"' ";
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

	private void UsunAntena() {

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

		System.out.println("ok jest " + ok);
		if (ok) {
			String sql3 = "DELETE FROM  Antena WHERE ID_antena ='"+jTextField1+"' ";
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
