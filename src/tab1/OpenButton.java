package tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class OpenButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 863386783025708473L;

	private DrawingPane drawingPane;

	public OpenButton(DrawingPane drawingPane) {
		super("Otworz plik");
		this.drawingPane = drawingPane;
		setVisible(true);
		addActionListener(this);
		setToolTipText("Klkinij by wczytaæ mape");
		setText("Wczytaj mapê");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = fc.showOpenDialog(drawingPane);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			drawingPane.changePicture(file.getAbsolutePath());// file.getName());
		}
	}

}
