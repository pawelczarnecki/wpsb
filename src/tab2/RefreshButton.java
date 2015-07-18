package tab2;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import praca.FilesInLocation;

public class RefreshButton extends JButton implements ActionListener {

	private NewJPanel newJPanel;
	String user = "SYSTEM";
	String password = "Csevgy32167";
	
	public RefreshButton(NewJPanel newJPanel){
		super("Odswiez");
		this.newJPanel = newJPanel;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Click refresh");
	}
	public void  actionPerformed(java.awt.event.ActionEvent evt) {
		//newJPanel.refreshFilesInLocation();
		
		String sql1 = "select a.ID_antena FROM ANTENA a";
		String pom = "";
		System.out.println(sql1);
		newJPanel.listModel.removeAllElements();
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
					newJPanel.listModel.addElement(rs1.getString("ID_antena"));
					System.out.println(newJPanel.listModel);
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
