package tab1;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class AntenaData extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1652112702303772109L;

	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField ZyskField;
	private JTextField CzestotliwoscField;
	private JTextField KatField;
	private JTextField MinZyskField;
	//private JTextField WysokoscField;
	private JComboBox jComboBox1;
	private JComboBox jComboBox2;
	public String Propagacja = "";
	private Tab2JPanel tab2jPanel;

	private List<Antena> antenas;

	public AntenaData(Tab2JPanel tab2jPanel, List<Antena> antenas) {
		this.tab2jPanel = tab2jPanel;
		this.antenas = antenas;

		jButton1 = new JButton();
		jButton2 = new JButton();
		jLabel1 = new JLabel("EIRP [dB]");
		jLabel2 = new JLabel("Czestotliwosc [MHz]");
		jLabel3 = new JLabel("K¹t (stopnie)");
		jLabel4 = new JLabel("Charakterystyka anteny");
		jLabel5 = new JLabel("Minimalna moc odbierana [dB]");
		ZyskField = new JTextField(10);
		CzestotliwoscField = new JTextField(10);
		KatField = new JTextField(10);
		MinZyskField = new JTextField(10);

		jComboBox1 = new JComboBox();
		jComboBox2 = new JComboBox();


		jButton2.setText("Wroc");

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});


		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(antenas
				.toArray()));
		
		jComboBox1.setFocusable(false);

		jComboBox1.addItemListener(new ItemListener() {
			
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//System.out.println(e.getItem() + " " + e.getStateChange() );
				Antena selectedAntena = (Antena) jComboBox1.getSelectedItem();
				ZyskField.setText(selectedAntena.getZysk());
				MinZyskField.setText(selectedAntena.getMinZysk());
				CzestotliwoscField.setText(selectedAntena.getCzestotliwosc());
				KatField.setText(selectedAntena.getKat());
			}
	

		});
		if(!antenas.isEmpty())
		jComboBox1.setSelectedIndex(0);
	
		ZyskField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				Antena selectedAntena = (Antena) jComboBox1.getSelectedItem();
				selectedAntena.setZysk(ZyskField.getText());
			}

		});
		MinZyskField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				Antena selectedAntena = (Antena) jComboBox1.getSelectedItem();
				selectedAntena.setMinZysk(MinZyskField.getText());
			}

		});
		CzestotliwoscField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}
			@Override
			public void focusLost(FocusEvent e) {
				Antena selectedAntena = (Antena) jComboBox1.getSelectedItem();
				selectedAntena.setCzestotliwosc(CzestotliwoscField.getText());
			}
		});
		KatField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}
			@Override
			public void focusLost(FocusEvent e) {
				Antena selectedAntena = (Antena) jComboBox1.getSelectedItem();
				selectedAntena.setKat(KatField.getText());
			}
		});
		
		
		
		try {
			// create new file

			String current = new java.io.File("").getCanonicalPath();
			current += "/dane/anteny/";
			System.out.println("Current dir:" + current);
			File f = new File(current);
			// array of files and directory
			String[] paths = f.list();
			jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(paths));
		} catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null, "B³¹d przy listowaniu plikow");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jComboBox2.addActionListener(this);

		rozmieszczenie();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		JComboBox source = (JComboBox) evt.getSource();
		String item = (String) source.getSelectedItem();
		tab2jPanel.setCurrentFileName(item);
	}
	
	private void rozmieszczenie() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(ZyskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KatField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MinZyskField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CzestotliwoscField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(ZyskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(MinZyskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CzestotliwoscField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
		setVisible(true);
		setResizable(false);
		setLocation(200, 200);
	}

	

}
