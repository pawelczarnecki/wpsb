package tab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class IntersectPoint {

	public static void main(String[] args) {
		new IntersectPoint();
	}

	public IntersectPoint() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class TestPane extends JPanel {
		// private List<PunkPrzeciecia> punkPrzeciecias;

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 200);
		}

		protected void paintComponent(Graphics g) {// , List<PunkPrzeciecia>
													// punkPrzeciecias) {
			super.paintComponent(g);

			int x = (int) (getWidth() * 0.2f);
			int y = (int) (getHeight() * 0.2f);
			int width = (int) (getWidth() * 0.6f);
			int height = (int) (getHeight() * 0.6f);
			double zmienna;
			int pktpoczatkowyset = 0;
			int pktkonczowyset = 0;
			int oldX = 0;
			int oldY = 0;
			double[] odleglosc = new double[4];
			double pom = 0;
			
			// double odleglosc = 0;
			int licznik = 0;
			// this.punkPrzeciecias = punkPrzeciecias;

			int x1 = 10;// x;
			int y1 = 10;// 0;
			int x2 = 180;// x + width;
			int y2 = 190;// getHeight();
			double poprzednipunktX=x1;
			double poprzednipunktY=y1;
			Point2D punktKoncowy= new Point2D.Double(x2,y2);
			Line2D line = new Line2D.Double(x1, y1, x2, y2);
			Line2D line2 = new Line2D.Double(x1-5, y1, x2-5, y2);
			Line2D[] linetable =  new Line2D [4];
			Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
			Line2D linepoczatek = new Line2D.Double(x1, y1, x1, y1);
			Line2D linesrodek = new Line2D.Double(x2, y2, x2, y2);
			Line2D linekoniec = new Line2D.Double(x2, y2, x2, y2);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.draw(rect);
			// g2d.draw(line);

			g2d.setColor(Color.RED);
			// if (rect.intersectsLine(line))
			{

				Point2D[] ps = getIntersectionPoint(line, rect);
				
				
				//zbiera odleglosc
				for (int i = 0; i < 4; i++) {
					if (ps[i] != null)
						odleglosc[i] = ps[i].distance(x1, y1);
					else
						odleglosc[i] = 0;

				}
				//odleglosc[2]=punktKoncowy.distance(x1, y1);
				// sortuje od najmniejszej
				for (int m = 0; m < 4; m++) {
					for (int n = 0; n < 4; n++) {

						if (odleglosc[n] > odleglosc[m]) {
							pom = odleglosc[n];
							odleglosc[n] = odleglosc[m];
							odleglosc[m] = pom;
						}
					}
				}
				//wypisze i narysuje najblizsza
				for (int i = 0; i < 4; i++) {
					if (odleglosc[i] > 0) {
						System.out.println("odleglosc :" + odleglosc[i]);
						for (int k = 0; k < 4; k++) {
							if (ps[k] != null)
							{
								if (ps[k].distance(x1, y1) == odleglosc[i]) {
									System.out.println("przeciecie w :"
										+ ps[k].getX() + " y" + ps[k].getY());
									g2d.fill(new Ellipse2D.Double(ps[k].getX() - 4,
										ps[k].getY() - 4, 8, 8));
									
									if(rect.contains(poprzednipunktX,poprzednipunktY) && !rect.contains(ps[k].getX(),ps[k].getY()))
									{
										linetable[licznik]=new Line2D.Double(poprzednipunktX, poprzednipunktY, ps[k].getX(),ps[k].getY());
										poprzednipunktX=ps[k].getX();
										poprzednipunktY=ps[k].getY();
										
									}
									else
									{
										linetable[licznik]=new Line2D.Double(poprzednipunktX, poprzednipunktY, ps[k].getX(),ps[k].getY());
										poprzednipunktX=ps[k].getX();
										poprzednipunktY=ps[k].getY();
										x2=x2-15;
										y2=y2-15;
										
									}
									licznik++;
								}
							}
						}
						
					}

				}
				linetable[licznik]=new Line2D.Double(poprzednipunktX, poprzednipunktY, x2,y2);
				
				
				g2d.setColor(Color.CYAN);
				g2d.draw(line2);
				try{
				g2d.setColor(Color.blue);
				g2d.draw(linetable[0]);
				//g2d.draw(line);
				g2d.setColor(Color.MAGENTA);
				//g2d.draw(linetable[0]);
				g2d.draw(linetable[1]);
				// g2d.draw(linesrodek);
				g2d.setColor(Color.GREEN);
				//g2d.draw(line);
				g2d.draw(linetable[2]);
				}
				catch(Exception e)
				{
				
				}
				
				
				
				// g2d.draw(linekoniec);
				g2d.dispose();
			}

		}

		public Point2D[] getIntersectionPoint(Line2D line, Rectangle2D rectangle) {

			Point2D[] p = new Point2D[4];

			// Top line
			p[0] = getIntersectionPoint(
					line,
					new Line2D.Double(rectangle.getX(), rectangle.getY(),
							rectangle.getX() + rectangle.getWidth(), rectangle
									.getY()));
			// Bottom line
			p[1] = getIntersectionPoint(line,
					new Line2D.Double(rectangle.getX(), rectangle.getY()
							+ rectangle.getHeight(), rectangle.getX()
							+ rectangle.getWidth(), rectangle.getY()
							+ rectangle.getHeight()));
			// Left side...
			p[2] = getIntersectionPoint(
					line,
					new Line2D.Double(rectangle.getX(), rectangle.getY(),
							rectangle.getX(), rectangle.getY()
									+ rectangle.getHeight()));
			// Right side
			p[3] = getIntersectionPoint(
					line,
					new Line2D.Double(rectangle.getX() + rectangle.getWidth(),
							rectangle.getY(), rectangle.getX()
									+ rectangle.getWidth(), rectangle.getY()
									+ rectangle.getHeight()));

			return p;

		}

		public Point2D getIntersectionPoint(Line2D lineA, Line2D lineB) {

			double x1 = lineA.getX1();
			double y1 = lineA.getY1();
			double x2 = lineA.getX2();
			double y2 = lineA.getY2();

			double x3 = lineB.getX1();
			double y3 = lineB.getY1();
			double x4 = lineB.getX2();
			double y4 = lineB.getY2();

			Point2D p = null;

			if (lineA.intersectsLine(lineB) && lineB.intersectsLine(lineA)) {

				double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
				// System.out.println("zmeinna d" + d );
				if (d != 0) {
					double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2)
							* (x3 * y4 - y3 * x4))
							/ d;

					double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2)
							* (x3 * y4 - y3 * x4))
							/ d;
					// System.out.println("wspolrzedne punktu : " + xi+ " y "+
					// yi );
					p = new Point2D.Double(xi, yi);

				}
			}
			return p;
		}
	}
}