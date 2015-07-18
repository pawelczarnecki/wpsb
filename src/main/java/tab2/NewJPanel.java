package tab2;

import praca.FilesInLocation;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Dom
 */
public class NewJPanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = -5470287241178628616L;
	private JList list;
	String user = "SYSTEM";
	String password = "Csevgy32167";

	public NewJPanel() {
		jPanel1 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField(10);
		jTextField2 = new javax.swing.JTextField(10);
		jTextField3 = new javax.swing.JTextField(10);
		jTextField4 = new javax.swing.JTextField(10);
		jTextField5 = new javax.swing.JTextField(10);
		jTextField6 = new javax.swing.JTextField(10);
		jTextField7 = new javax.swing.JTextField(10);
		jTextField8 = new javax.swing.JTextField(10);
		jTextField9 = new javax.swing.JTextField(10);
		jTextField10 = new javax.swing.JTextField(10);
		jTextField11 = new javax.swing.JTextField(10);
		jTextField12 = new javax.swing.JTextField(10);
		jTextField13 = new javax.swing.JTextField(10);
		jTextField14 = new javax.swing.JTextField(10);
		jTextField15 = new javax.swing.JTextField(10);
		jTextField16 = new javax.swing.JTextField(10);
		jTextField17 = new javax.swing.JTextField(10);
		jTextField18 = new javax.swing.JTextField(10);
		jTextField19 = new javax.swing.JTextField(10);
		jTextField20 = new javax.swing.JTextField(10);
		jTextField21 = new javax.swing.JTextField(10);
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList2 = new javax.swing.JList();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList3 = new javax.swing.JList();

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		LoadButton1 loadButton1 = new LoadButton1(this);
		add(loadButton1);
		LoadButton2 loadButton2 = new LoadButton2(this);
		add(loadButton2);
		LoadButton3 loadButton3 = new LoadButton3(this);
		add(loadButton3);
		RefreshButton refreshButton = new RefreshButton(this);
		add(refreshButton);

		jTextField1.setText("jTextField1");

		jTextField2.setText("jTextField2");

		jTextField3.setText("jTextField3");

		jTextField4.setText("jTextField4");

		jTextField5.setText("jTextField5");

		jTextField6.setText("jTextField6");

		jTextField7.setText("jTextField7");

		jTextField8.setText("jTextField8");

		jTextField9.setText("jTextField9");

		jTextField10.setText("jTextField10");

		jTextField11.setText("jTextField11");

		jTextField12.setText("jTextField12");

		jTextField13.setText("jTextField13");

		jTextField14.setText("jTextField14");

		jTextField15.setText("jTextField15");

		jTextField16.setText("jTextField16");

		jTextField17.setText("jTextField17");

		jTextField18.setText("jTextField18");

		jTextField19.setText("jTextField19");

		jTextField20.setText("jTextField20");

		jTextField21.setText("jTextField21");

		jLabel1.setText("ID anten");

		jLabel2.setText("Producent");

		jLabel3.setText("Numer identyfikacyjny");

		jLabel4.setText("Czestotliwosc");

		jLabel5.setText("Kat");

		jLabel6.setText("Zysk");

		jLabel7.setText("Rodzaj");

		listModel = new DefaultListModel();
		// listModel= new FilesInLocation().getFilesInLocation();
		// listModel.addElement(FilesInLocation.FilesInLocation());
		// listModel.addElement("John Smith");
		// listModel.addElement("Kathy Green");
		String sql1 = "select a.ID_antena FROM ANTENA a";
		String pom = "";
		System.out.println(sql1+ "tab2");
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn;
//			try {
//				conn = DriverManager
//						.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
//								user, password);
//
//				Statement stmt1 = conn.createStatement();
//				ResultSet rs1 = stmt1.executeQuery(sql1);
//				while (rs1.next()) {
//					listModel.addElement(rs1.getString("ID_antena"));
//					System.out.println(listModel);
//				}
//			} catch (SQLException e1) {
//				System.out.println("tutaj 1");
//				e1.printStackTrace();
//			}
//		} catch (ClassNotFoundException e1) {
//			System.out.println("tutaj 2");
//			e1.printStackTrace();
//		}

		jList1 = new JList(listModel);
		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList1.setSelectedIndex(0);
		jList1.addListSelectionListener(this);
		jList1.setVisibleRowCount(5);

		jScrollPane1.setViewportView(jList1);

		jList2 = new JList(listModel);
		jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList2.setSelectedIndex(1);
		jList2.addListSelectionListener(this);
		jList2.setVisibleRowCount(5);

		jScrollPane2.setViewportView(jList2);

		jList3 = new JList(listModel);
		jList3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList3.setSelectedIndex(2);
		jList3.addListSelectionListener(this);
		jList3.setVisibleRowCount(5);
		jScrollPane3.setViewportView(jList3);

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		setHorizontalGroup(loadButton1, loadButton2, loadButton3,
				refreshButton, layout);
		setVerticalGroup(loadButton1, loadButton2, loadButton3, refreshButton,
				layout);

		// pack();
	}// </editor-fold>

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	// private javax.swing.JButton LoadButton1;
	// private javax.swing.JButton LoadButton2;
	// private javax.swing.JButton LoadButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	javax.swing.JList jList1;
	static javax.swing.JList jList2;
	static javax.swing.JList jList3;
	private javax.swing.JPanel jPanel1;
	javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	static javax.swing.JTextField jTextField1;
	static javax.swing.JTextField jTextField10;
	static javax.swing.JTextField jTextField11;
	static javax.swing.JTextField jTextField12;
	static javax.swing.JTextField jTextField13;
	static javax.swing.JTextField jTextField14;
	static javax.swing.JTextField jTextField15;
	static javax.swing.JTextField jTextField16;
	static javax.swing.JTextField jTextField17;
	static javax.swing.JTextField jTextField18;
	static javax.swing.JTextField jTextField19;
	static javax.swing.JTextField jTextField2;
	static javax.swing.JTextField jTextField20;
	static javax.swing.JTextField jTextField21;
	static javax.swing.JTextField jTextField3;
	static javax.swing.JTextField jTextField4;
	static javax.swing.JTextField jTextField5;
	static javax.swing.JTextField jTextField6;
	static javax.swing.JTextField jTextField7;
	static javax.swing.JTextField jTextField8;
	static javax.swing.JTextField jTextField9;
	public DefaultListModel listModel;

	private void setVerticalGroup(LoadButton1 loadButton1,
			LoadButton2 loadButton2, LoadButton3 loadButton3,
			RefreshButton refreshButton, GroupLayout layout) {
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(loadButton1)
												.addComponent(loadButton2)
												.addComponent(loadButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										77, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane2,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						82,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						82,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						82,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(53, 53,
																		53)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField8,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField15,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel1))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jTextField2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jLabel2))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jTextField9,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jTextField16,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jTextField10,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jTextField17,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel3))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jTextField4,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jLabel4))
																				.addComponent(
																						jTextField11,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField18,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField12,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField19,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel5))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										jTextField6,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										jLabel6))
																				.addComponent(
																						jTextField13,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField20,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField14,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField21,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel7)))
												.addComponent(refreshButton))
								.addGap(125, 125, 125)));
	}

	private void setHorizontalGroup(LoadButton1 loadButton1,
			LoadButton2 loadButton2, LoadButton3 loadButton3,
			RefreshButton refreshButton, GroupLayout layout) {
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(34, 34,
																		34)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						jLabel7)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(56, 56,
																		56)
																.addComponent(
																		refreshButton)))
								.addGap(87, 87, 87)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(
																		loadButton1)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		73,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField6,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField7,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jTextField14,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField10,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField9,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField8,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						loadButton2)
																				.addComponent(
																						jScrollPane2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						73,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(45,
																										45,
																										45)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														jTextField16)
																												.addComponent(
																														jTextField15)
																												.addComponent(
																														jTextField17)
																												.addComponent(
																														jTextField18)
																												.addComponent(
																														jTextField19)
																												.addComponent(
																														jTextField20)
																												.addComponent(
																														jTextField21)))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addPreferredGap(
																														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																												.addComponent(
																														jScrollPane3,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														65,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addGroup(
																										javax.swing.GroupLayout.Alignment.LEADING,
																										layout.createSequentialGroup()
																												.addGap(29,
																														29,
																														29)
																												.addComponent(
																														loadButton3)))))
												.addComponent(
														jTextField11,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField12,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField13,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(142, Short.MAX_VALUE)));
	}

	public void refreshFilesInLocation() {
		listModel = new FilesInLocation().getFilesInLocation();
		jList1 = new JList(listModel);
		jScrollPane1.setViewportView(jList1);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}