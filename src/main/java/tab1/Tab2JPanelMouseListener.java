package tab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Tab2JPanelMouseListener implements MouseListener {

	private List<Building> buildings;
	
	private Tab2JPanel drawingPane;

	public static int mouseX;

	public static int mouseY;

	public Tab2JPanelMouseListener(Tab2JPanel drawingPane, List<Building> buildings) {
		this.drawingPane = drawingPane;
		//this.rectangle = rectangles;
		this.buildings = buildings;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	// Handle mouse events.
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			// This will clear the graphic objects.
			//rectangle.removeAllElements();
			mouseX = e.getX();
			mouseY = e.getY();
		} else {
			
			if (mouseX < 0)
				mouseX = 0;
			if (mouseY < 0)
				mouseY = 0;
			Rectangle rect = new Rectangle(mouseX, mouseY, CheckMaxValueOfPictureWidth( e.getX(), mouseX),CheckMaxValueOfPictureHeight( e.getY() , mouseY));
			buildings.add(new Building(rect,2));
			
			MarkedAreaData.Change(mouseX, mouseY, CheckMaxValueOfPictureWidth( e.getX(), mouseX),CheckMaxValueOfPictureHeight( e.getY() , mouseY));
			drawingPane.scrollRectToVisible(rect);
			

		}
		drawingPane.revalidate();
		drawingPane.repaint();
	}
	int CheckMaxValueOfPictureWidth(int LastMousePossision, int FirstMousePossison)
	{
		if(LastMousePossision>drawingPane.drawingPane.getBackGroundImage().getWidth())
			LastMousePossision=drawingPane.drawingPane.getBackGroundImage().getWidth();
			
		return LastMousePossision-FirstMousePossison;
		
	}
	int CheckMaxValueOfPictureHeight(int LastMousePossision, int FirstMousePossison)
	{
		if(LastMousePossision>drawingPane.drawingPane.getBackGroundImage().getHeight())
			LastMousePossision=drawingPane.drawingPane.getBackGroundImage().getHeight();
			
		return LastMousePossision-FirstMousePossison;
		
	}

	
}
