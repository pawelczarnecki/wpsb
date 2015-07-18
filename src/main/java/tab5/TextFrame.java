package tab5;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextFrame extends javax.swing.JFrame {

	public TextFrame(InfoCard infoCard, String path) {
	
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		fillTextAreaFromFile(jTextArea1,path); 
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 480,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 378,
								Short.MAX_VALUE).addContainerGap()));

		pack();
		setVisible(true);
		setResizable(true);
		setLocation(200, 200);
	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;

	private void fillTextAreaFromFile(JTextArea area, String path) {
		Scanner scanner;
		area.setText("");
		int i=0;
		try {
			scanner = new Scanner(new File(path));
			while(scanner.hasNextLine()){
				area.setText(area.getText()+scanner.nextLine()+"\n");			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
