package tab1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Tab2JPanel extends JPanel {
	private static final long serialVersionUID = -1073342979021233050L;
	private List<AntennaDrawable> antennas = new ArrayList<>();
	private List<Building> buildings = new ArrayList<>();
	private String filename;
	//CHANGE VECTOR TO LIST
	private Vector<Shape> shapes = new Vector<Shape>();
	public DrawingPane drawingPane;


	public Tab2JPanel() {
		super(new BorderLayout());
		//drawingPane = new DrawingPane(shapes,antenas);
		drawingPane = new DrawingPane(shapes, antennas, buildings);
		drawingPane.addMouseListener(new Tab2JPanelMouseListener(this,
				buildings));
		drawingPane.addKeyListener(new Tab2JPanelKeyListener(this,
				shapes, antennas, buildings));
		
		JScrollPane scroller = new JScrollPane(drawingPane);
		OpenButton openButton = new OpenButton(drawingPane);
		SaveButton saveButton = new SaveButton(drawingPane);
		DrawButton drawButton = new DrawButton(this, antennas, buildings);
		AntenaDataButton antenaDataButton = new AntenaDataButton(this, antennas);
		OtherDataButton otherDataButton = new OtherDataButton(this,buildings);
		
		extracted(scroller, openButton, saveButton, drawButton,
				antenaDataButton, otherDataButton);
	}
	
	public void setCurrentFileName(String filename) {
		this.filename = filename;
	}

	public String getCurrentFileName() {
		return filename;
	}
	
	public int getCurrentAngle() {
		return 0;
	}

	// -----------------------------------------------------------------------
	// -----------------------------------------------------------------------
	// -------------------------DO NOT LOOK UNDER THIS LINE-------------------
	// -----------------------------------------------------------------------
	// -----------------------------------------------------------------------
	private void extracted(JScrollPane scroller, OpenButton openButton,
			SaveButton saveButton, DrawButton drawButton,
			AntenaDataButton antenaDataButton, OtherDataButton otherDataButton) {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(scroller,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										576, Short.MAX_VALUE)
								// .addComponent(scroller,javax.swing.GroupLayout.PREFERRED_SIZE,backGroundImage.getWidth(),
								// 500)
								// .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,32,javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(openButton)
												.addComponent(saveButton)
												.addComponent(drawButton)
												.addComponent(antenaDataButton)
												.addComponent(otherDataButton))
								.addGap(66, 66, 66)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addGap(22, 22, 22)
								.addComponent(openButton).addGap(18, 18, 18)
								.addComponent(saveButton).addGap(20, 20, 20)
								.addComponent(drawButton).addGap(18, 18, 18)
								.addComponent(antenaDataButton)
								.addGap(18, 18, 18)
								.addComponent(otherDataButton)
								.addContainerGap(293, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
				// .addComponent(instructionPanel)
				// .addComponent(scroller,javax.swing.GroupLayout.PREFERRED_SIZE,backGroundImage.getHeight(),
				// 450)
						.addComponent(scroller).addContainerGap()));
		// </editor-fold>
	}
}