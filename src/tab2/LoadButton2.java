package tab2;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import praca.Okno;

public class LoadButton2 extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1749977171797811556L;
	private NewJPanel newJPanel;
	String user = "";
	String password = "";

	public LoadButton2(NewJPanel newJPanel) {
		super("LoadButton2");
		this.newJPanel = newJPanel;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Click to load antena details.");
	}

	public void actionPerformed(java.awt.event.ActionEvent evt) {
		String sql1 = "select a.* FROM ANTENA a WHERE a.ID_antena='"
				+ (newJPanel.jList2.getSelectedIndex() + 1) + "' ";
		String pom = "";
		System.out.println(sql1);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn;
			try {
				conn = DriverManager
						.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
								user, password);

				Statement stmt1 = conn.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
				while (rs1.next()) {
					NewJPanel.jTextField8.setText(rs1.getString("ID_antena"));
					NewJPanel.jTextField9.setText(rs1.getString("Producent"));
					NewJPanel.jTextField10.setText(rs1
							.getString("Numer_identyfikacyjny"));
					NewJPanel.jTextField11.setText(rs1
							.getString("Czestotliwosc"));
					NewJPanel.jTextField12
							.setText(rs1.getString("Polaryzacja"));
					NewJPanel.jTextField13.setText(rs1.getString("Moc"));
					NewJPanel.jTextField14.setText(rs1.getString("Rodzaj"));
				}
			} catch (SQLException e1) {
				System.out.println("tutaj 1");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			System.out.println("tutaj 2");
			e1.printStackTrace();
		}

	}

}