package tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OtherData extends JFrame {
	private static final long serialVersionUID = -3400151084515157337L;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JComboBox jComboBox1;

	private JTextField TlumienieBudynkuField;
	private JTextField TlumieniePrzestrzeniField;
	private JTextField SkalaField;
	private double skala;
	private Tab2JPanel tab2jPanel;
	private List<Building> buildings;

	public OtherData(Tab2JPanel tab2jPanel, List<Building> buildings) {

		this.tab2jPanel = tab2jPanel; // nie bylo potrzebne
		this.buildings= buildings; // nie bylo potrzebne
		jButton1 = new JButton();
		jButton2 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jComboBox1 = new JComboBox();
		jLabel4 = new JLabel();

		TlumienieBudynkuField = new JTextField(10);
		TlumieniePrzestrzeniField = new JTextField(10);
		SkalaField = new JTextField(10);

		jButton2.setText("Wroc");

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		jLabel1.setText("Tlumienie budynku [db/piksel]");

		jLabel3.setText("Skala 1 km : ");

		jLabel4.setText("Budynek o wspo³rzêdnych");
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(buildings
				.toArray()));
		jComboBox1.setFocusable(false);
		jComboBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Building selectedBulding = (Building) jComboBox1
						.getSelectedItem();
				TlumienieBudynkuField.setText(selectedBulding.getTlumienie());
				SkalaField.setText(Double.toString(skala));

			}

		});
		if (!buildings.isEmpty())
			jComboBox1.setSelectedIndex(0);

		TlumienieBudynkuField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				Building selectedBulding = (Building) jComboBox1
						.getSelectedItem();
				selectedBulding.setTlumienie(TlumienieBudynkuField.getText());
			}

		});
		SkalaField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				Linia.setSkala(SkalaField.getText());
				skala = Double.parseDouble(SkalaField.getText());
			}

		});

		rozmieszczenie();
	}

	private void rozmieszczenie() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(80, 80, 80)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jButton2)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel3))
																.addGap(74, 74,
																		74)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						TlumienieBudynkuField,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						SkalaField,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jComboBox1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(25, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(31, 31, 31)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														SkalaField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														TlumienieBudynkuField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(24, 24, 24)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jComboBox1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4))
								.addGap(18, 18, 18).addComponent(jButton2)
								.addContainerGap(23, Short.MAX_VALUE)));

		pack();
		setVisible(true);
		setResizable(false);
		setLocation(200, 200);
	}

	
}