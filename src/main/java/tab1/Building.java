package tab1;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Building {

	private Rectangle rec;
	private double tlumienie;

	
	public Building(Rectangle rec,double tlumienie) {
		this.rec = rec;
		this.tlumienie=tlumienie;
	}

	public void draw(Graphics2D g2) {
		Graphics2D create = (Graphics2D) g2.create();
		create.setColor(Color.magenta);
		create.fill(rec);
	}

	public Rectangle2D getBounds2D() {
		return rec.getBounds2D();
	}

	public boolean contains(double poprzednipunktX, double poprzednipunktY) {
		return rec.contains(poprzednipunktX, poprzednipunktY);
	}

	public boolean intersects(Line2D line) {

		return rec.intersectsLine(line);
	}

	public double getX() {
		// TODO Auto-generated method stub
		return rec.getX();
	}

	public double getY() {
		// TODO Auto-generated method stub
		return rec.getY();
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return rec.getWidth();
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return rec.getHeight();
	}

	public List<Point2D> getIntersectionPoint(Line2D line) {
		//System.out.println("wywoluje z this ");
		return getIntersectionPoint(line, this);
	}

	private List<Point2D> getIntersectionPoint(Line2D line, Building building) {
		List<Point2D> points = new ArrayList<>();

		Point2D point = (getIntersectionPoint(
				line,
				new Line2D.Double(building.getX(), building.getY(), building
						.getX() + building.getWidth(), building.getY())));
		if (point != null){
			points.add(point);
		// System.out.println("znalazl pkt gora ");
			}

		point = (getIntersectionPoint(
				line,
				new Line2D.Double(building.getX(), building.getY()
						+ building.getHeight(), building.getX()
						+ building.getWidth(), building.getY()
						+ building.getHeight())));
		if (point != null){
			points.add(point);
		//System.out.println("znalazl pkt dol ");
			}

		point = (getIntersectionPoint(
				line,
				new Line2D.Double(building.getX(), building.getY(), building
						.getX(), building.getY() + building.getHeight())));
		if (point != null){
			points.add(point);
		//System.out.println("znalazl pkt lewo ");
		}

		point = (getIntersectionPoint(line, new Line2D.Double(building.getX()
				+ building.getWidth(), building.getY(), building.getX()
				+ building.getWidth(), building.getY() + building.getHeight())));
		if (point != null){
			points.add(point);
		//System.out.println("znalazl pkt prawo ");
		}
		//System.out.println("wspolrzedne punktu : " + point.getX() + " y " + point.getY());
		return points;

	}

	public Point2D getIntersectionPoint(Line2D lineA, Line2D lineB) {
		if (lineA.intersectsLine(lineB) || lineB.intersectsLine(lineA)) {
			double x1 = lineA.getX1();
			double y1 = lineA.getY1();
			double x2 = lineA.getX2();
			double y2 = lineA.getY2();

			double x3 = lineB.getX1();
			double y3 = lineB.getY1();
			double x4 = lineB.getX2();
			double y4 = lineB.getY2();

			double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
			if (d != 0) {
				double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2)
						* (x3 * y4 - y3 * x4))
						/ d;

				double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2)
						* (x3 * y4 - y3 * x4))
						/ d;
				System.out.println("wspolrzedne punktu : " + xi + " y " + yi);

				return new Point2D.Double(xi, yi);

			}
		}
		return null;
	}

	public boolean containsMidPoint(Point2D from, Point2D to) {
		return rec.contains(new Point2D.Double((from.getX() + to.getX()) / 2,
				(from.getY() + to.getY()) / 2));
	}
	public Point2D MidPoint(Point2D from, Point2D to) {
		return (new Point2D.Double((from.getX() + to.getX()) / 2,
				(from.getY() + to.getY()) / 2));
	}

	public String getTlumienie() {
		return ""+tlumienie;
	}	
	public void setTlumienie(String text) {
		tlumienie=Double.parseDouble(text) ;
	}
	public String toString(){
		return ""+(rec.getX())+" "+rec.getY();
	}

}
