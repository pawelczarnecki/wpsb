package tab1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveButton extends JButton implements ActionListener{
	private static final long serialVersionUID = 863386783025708473L;
	
	private DrawingPane drawingPane;

	public SaveButton(DrawingPane drawingPane) {
		super("Zapisz plik");
		this.drawingPane = drawingPane;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Kliknij by zapisaæ mapê");
		setText("Zapisz mapê");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = fc.showSaveDialog(drawingPane);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			
			try {
				BufferedImage image = new BufferedImage(drawingPane.getWidth(), drawingPane.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				drawingPane.paintAll(g);
				
				ImageIO.write(image, "JPG",  file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
