package tab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zakladka4 extends JPanel implements ActionListener {
	private static final long serialVersionUID = -1770893618931199909L;
	
	static String item;
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;


	public static DefaultTableModel dtm;
     static JTextField jTextField1;
     JTextField jTextField2;
     JTextField jTextField3;
     JTextField jTextField4;
     JTextField jTextField5;
     JTextField jTextField6;

    public JTable table = null;
    //private JTextField 
    private JComboBox jComboBox11;

	public Zakladka4() {
//		ImageIcon image = new ImageIcon("thing.gif");
//		JLabel label = new JLabel("zakladka4", image, JLabel.CENTER);
//		add(label, BorderLayout.CENTER);
		
		
		 jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel11 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        
	        jComboBox11 = new JComboBox();
	        jTextField2 = new JTextField();
	        jTextField3 = new JTextField();
	        jTextField4 = new JTextField();
	        jTextField5 = new JTextField();
	        jTextField6 = new JTextField();


	        jLabel1.setText("Rozwiñ zapytanie do bazy danych:");
	        jLabel2.setText("jLabel2");
	        jLabel3.setText("jLabel3");
	        jLabel4.setText("jLabel4");
	        jLabel5.setText("jLabel5");
	        jLabel6.setText("jLabel6");
	        jLabel7.setText("jLabel7");
	        jLabel8.setText("jLabel8");
	        jLabel9.setText("jLabel9");
	        jLabel10.setText("jLabel10");
	        jTextField1.setText("Liczba wynikow");
	        jLabel11.setText("Liczba wynikow");
	        jButton1.setText("Wyswietl");
	        jButton2.setText("Edytuj");
	        WyswietlButton wyswietlButton = new WyswietlButton(this);
			//add(wyswietlButton);
			EdytujButton edytujButton = new EdytujButton(this);
			//add(edytujButton);
			jButton3.setText("Dodaj");
	        jButton4.setText("Usun");
	        jTextField2.setText("Kat > 50 OR Czestotliwosc=800");

	        wyswietlButton.setText("Wyswietl");
	        try{
	        	
	        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Antena", "Adres", "Instalacja", "Lokacje"}));

	        }
	        catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null,
						"B³¹d przy wybieraniu tabeli");
			}
	        
	        jComboBox11.addActionListener(this);
	        
	        
	        ustawienie(wyswietlButton, edytujButton);
	    }
	private void ustawienie(WyswietlButton wyswietlButton,
			EdytujButton edytujButton) {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edytujButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wyswietlButton)
                                        .addGap(134, 134, 134)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edytujButton)
                    .addComponent(wyswietlButton)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }
public String getTextFromTextField(){
	
	return jTextField2.getText();
	
}
	public void actionPerformed(ActionEvent evt) {
		Object[][] products = null;
		item = String.valueOf(jComboBox11.getSelectedItem());
        if( item.contains("Antena"))
        {
        String[] colName = new String[] {
        		"ID_antena", "Producent", "Numer_identyfikacyjny", "Czestotliwosc", "Kat", "Zysk", "Rodzaj"
            };
        System.out.println("wybrany:"+item);
        dtm = new DefaultTableModel(products,colName);
        }
        else if( item.contains("Adres"))
        {
        String[] colName = new String[] {
        		"ID_adres", "Miejscowosc", "Ulica", "Numer_dzialki", "Kodpocztowy", "Wojewodztwo", "Miejsce_dzierzawione", "Dodatkowy_opis_po³o¿enia"
            };
        System.out.println("wybrany:"+item);
        dtm = new DefaultTableModel(products,colName);
        }
        else if( item.contains("Instalacja"))
        {
        String[] colName = new String[] {
        		"ID_instalacja", "Data_instyalacji", "Zatwierdzil_Imie", "Zatwierdzil_Nazwisko", "Zatwierdzil_ID"
            };
        System.out.println("wybrany:"+item);
        dtm = new DefaultTableModel(products,colName);
        }
        else if( item.contains("Lokacje"))
        {
        String[] colName = new String[] {
        		"ID_lokacja","ID_instalacja", "ID_adres", "ID_antena"
            };
        System.out.println("wybrany:"+item);
        dtm = new DefaultTableModel(products,colName);
        }
        else{	String[] colName = new String[] {
        		"brak"
            };
        System.out.println("wybrany:"+item);
        dtm = new DefaultTableModel(products,colName);
        }
		table = new JTable(dtm);
        
		jScrollPane1.setViewportView(table);
	  }
}
