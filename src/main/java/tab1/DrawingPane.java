package tab1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/** The component inside the scroll pane. */
public class DrawingPane extends JPanel {
	private static final long serialVersionUID = 2969086361974514775L;
	public BufferedImage backGroundImage;
	private Vector<Shape> shapes;
	private List<AntennaDrawable> antennas;
	private List<Building> buildings;



	public double BoundaryX;
	public double BoundaryY;


	public DrawingPane(Vector<Shape> shapes, List<AntennaDrawable> antennas, List<Building> buildings) {
		this.shapes = shapes;
		this.antennas = antennas;
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
		for(AntennaDrawable antenna : antennas){
			antenna.draw(g2, buildings,backGroundImage);
		}
		
	}
	public BufferedImage getBackGroundImage() {
		return backGroundImage; 
	}

	public void setBoundaries()
	{
		 BoundaryX = backGroundImage.getWidth();
		 BoundaryY = backGroundImage.getHeight();
	}

	public double getBoundaryX()
	{
		return BoundaryX;
	}
	public double getBoundaryY()
	{
		return BoundaryY;
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
			setBoundaries();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
