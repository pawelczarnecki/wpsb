package tab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import tab2.NewJPanel;
import tab4.Zakladka4;

public class WyswietlButton extends JButton implements ActionListener {
	private Zakladka4 zakladka4;
	String user = "SYSTEM";
	String password = "Csevgy32167";
	
	public WyswietlButton(Zakladka4 zakladka4) {
		super("Wyswietl");
		this.zakladka4 = zakladka4;
		setVisible(true);
		addActionListener(this);
	
	setToolTipText("By wyswietlic.");
	}

public void actionPerformed(ActionEvent e) {

	 
	String sql1 = "select a.* FROM "+ Zakladka4.item +" a ";
	if(!zakladka4.getTextFromTextField().isEmpty()){
		sql1+="WHERE ";
		sql1+=zakladka4.getTextFromTextField();
	}
	System.out.println(Zakladka4.item);
	System.out.println(sql1);
	int count=0;
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
				
				
				if( Zakladka4.item.contains("Antena"))
		        {
					Zakladka4.dtm.addRow(new Object[]{rs1.getString("ID_antena"), rs1.getString("Producent"), rs1.getString("Numer_identyfikacyjny"), rs1.getString("Czestotliwosc"), rs1.getString("Kat"), rs1.getString("Zysk"), rs1.getString("Rodzaj")});
		        }
		        else if( Zakladka4.item.contains("Adres"))
		        {
		        	Zakladka4.dtm.addRow(new Object[]{rs1.getString("ID_adres"), rs1.getString("Miejscowosc"), rs1.getString("Ulica"), rs1.getString("Numer_dzialki"), rs1.getString("Kod_pocztowy"), rs1.getString("Wojewodztwo"), rs1.getString("Miejsce_dzierzawione"),rs1.getString("Dodatkowy_opis_polozenia")});
		        }
		        else if( Zakladka4.item.contains("Instalacja"))
		        {
		        	Zakladka4.dtm.addRow(new Object[]{rs1.getString("ID_instalacja"), rs1.getString("Data_instalacji"), rs1.getString("Zatwierdzil_Imie"), rs1.getString("Zatwierdzil_Nazwisko"), rs1.getString("Zatwierdzil_ID")});
		        }
		        else if( Zakladka4.item.contains("Lokacje"))
		        {
		        	Zakladka4.dtm.addRow(new Object[]{rs1.getString("ID_lokacja"), rs1.getString("ID_instalacja"), rs1.getString("ID_adres"), rs1.getString("ID_antena")});
		        }
		        else{
		        System.out.println("wybrany:"+Zakladka4.item );
		        }
				count++;
				
			}
			Zakladka4.jTextField1.setText(""+count);
			count=0;
		} catch (SQLException e1) {
			System.out.println("tutaj 1");
			//e1.printStackTrace();
		}
	} catch (ClassNotFoundException e1) {
		System.out.println("tutaj 2");
		//e1.printStackTrace();
	}
}
}