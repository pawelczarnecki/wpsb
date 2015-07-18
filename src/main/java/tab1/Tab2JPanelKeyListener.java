package tab1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

public class Tab2JPanelKeyListener implements KeyListener {

	private Vector<Shape> shapes;
	private Tab2JPanel drawingPane;
	private List<Antena> antenas;
	private List<Building> buildings;

	public Tab2JPanelKeyListener(Tab2JPanel drawingPane, Vector<Shape> rectangles,
			List<Antena> antenas, List<Building> buildings) {
		this.drawingPane = drawingPane;
		this.shapes = rectangles;
		this.antenas = antenas;
		this.buildings = buildings;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key RELEASED" + "");
		if (e.getKeyCode() == KeyEvent.VK_A) {
			int x = Math.max(0, Tab2JPanelMouseListener.mouseX);
			int y = Math.max(0, Tab2JPanelMouseListener.mouseY);
			antenas.add(new Antena(x, y, "dane/anteny/"+drawingPane.getCurrentFileName(),0, 10,-88,800));/*drawingPane.getCurrentAngle()*/
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			shapes.removeAllElements();
			antenas.clear();
		}
		if (e.getKeyCode() == KeyEvent.VK_B) {
			shapes.removeAllElements();
			buildings.clear();
		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			shapes.removeAllElements();
			buildings.clear();
			antenas.clear();
		}
		
		drawingPane.revalidate();
		drawingPane.repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
