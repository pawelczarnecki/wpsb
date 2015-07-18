package tab2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoadButton3 extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6707130560035440349L;
	private NewJPanel newJPanel;
	String user = "";
	String password = "";

	public LoadButton3(NewJPanel newJPanel) {
		super("LoadButton3");
		this.newJPanel = newJPanel;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Click to load antena details.");
	}

	public void actionPerformed(java.awt.event.ActionEvent evt) {
		String sql1 = "select a.* FROM ANTENA a WHERE a.ID_antena='"
				+ (newJPanel.jList3.getSelectedIndex() + 1) + "' ";
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
					NewJPanel.jTextField15.setText(rs1.getString("ID_antena"));
					NewJPanel.jTextField16.setText(rs1.getString("Producent"));
					NewJPanel.jTextField17.setText(rs1
							.getString("Numer_identyfikacyjny"));
					NewJPanel.jTextField18.setText(rs1
							.getString("Czestotliwosc"));
					NewJPanel.jTextField19
							.setText(rs1.getString("Polaryzacja"));
					NewJPanel.jTextField20.setText(rs1.getString("Moc"));
					NewJPanel.jTextField21.setText(rs1.getString("Rodzaj"));
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