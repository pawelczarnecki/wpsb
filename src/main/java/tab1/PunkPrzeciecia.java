package tab1;

import java.awt.geom.Point2D;

public class PunkPrzeciecia implements Comparable<PunkPrzeciecia> {
	private Double lenght;
	private Point2D point;

	public PunkPrzeciecia(Point2D p, double l) {
		this.setPoint(p);
		this.lenght = l;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return getPoint().getX();
	}

	public double getY() {
		// TODO Auto-generated method stub
		return getPoint().getY();
	}

	public double getLenght() {
		return lenght;
	}

	@Override
	public int compareTo(PunkPrzeciecia other) {
		return lenght.compareTo(other.lenght);
	}

	public Point2D getPoint() {
		return point;
	}

	public void setPoint(Point2D point) {
		this.point = point;
	}
}
