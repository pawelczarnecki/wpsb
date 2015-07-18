package tab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** The component inside the scroll pane. */
public class DrawingPane extends JPanel {
	private static final long serialVersionUID = 2969086361974514775L;
	public BufferedImage backGroundImage;
	private Vector<Shape> shapes;
	private List<Antena> antenas;
	private List<Building> buildings;

	public DrawingPane(Vector<Shape> shapes, List<Antena> antenas, List<Building> buildings) {
		this.shapes = shapes;
		this.antenas = antenas;
		this.buildings = buildings;
		setFocusable(true);
		requestFocus();
		changePicture("dane/mapa2.gif");
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);

		g.drawImage(backGroundImage, 0, 0, null);

		/*
		for (Shape shape : shapes) {
			if (shape instanceof Rectangle) {
				//g2.setColor(Color.magenta);
				//g2.fill(shape);
				throw new RuntimeException("Pawel tried moved this part of if to Building.class dont judge");
			} else if (shape instanceof Line2D) {
				throw new RuntimeException("Karol moved this part of if to Antea.class blame him for this exception");
			}
		}*/
		for(Building building : buildings ){
			building.draw(g2);
		}
		for(Antena antena : antenas ){
			antena.draw(g2, buildings);
		}
		
	}
	public BufferedImage getBackGroundImage() {
		return backGroundImage; 
	}
	
	public void changePicture(String name) {
		try {
			File file = new File(name);
			if (!file.exists())
				throw new RuntimeException("file not found:"
						+ file.getAbsolutePath());
			backGroundImage = ImageIO.read(file);

			setPreferredSize(new Dimension(backGroundImage
					.getWidth(), backGroundImage.getHeight()));
			repaint();
			revalidate();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
