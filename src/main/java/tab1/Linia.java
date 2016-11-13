package tab1;

import javafx.scene.layout.BackgroundImage;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Linia {
	private final Point2D punktpoczatku;
	private final double zysk;
	private final double radians;
	private final double czestotliwosc;
	private static double skala = 1;
	private double odleglosc;
	private BufferedImage tlo;
	private Point2D koniec;


	public Linia(Point2D p, double zysk, double kat, int czestotliwosc, BufferedImage backGroundImageAntennaDrawable) {
		this.punktpoczatku = p;
		this.zysk = zysk;
		this.radians = Math.toRadians(kat);
		this.czestotliwosc = czestotliwosc;
		this.tlo=backGroundImageAntennaDrawable;
	}

	public void drawOneLine(Graphics2D g2, List<Building> buildings) {
		double avaiablePower = zysk;
		Point2D poczatek = punktpoczatku;
		double stalaBudynkow = 0;


		for (Point2D point2d : getIntersectionPoints(buildings)) {
			if (point2d != null) {

				if (avaiablePower <= 0)
					break;

				if (getOsrodek(poczatek, point2d, buildings) == 1) {// wolna
																	// przestrzen
					odleglosc = (double) Math.pow(10, (avaiablePower
							- stalaBudynkow - 32.45 - 20 * Math
							.log10(czestotliwosc)) / 20)
							* skala; // *skala

					if (poczatek.distance(point2d) > odleglosc) {// max bez
																	// budynku
						int x2 = (int) (odleglosc * Math.cos(radians));
						int y2 = (int) (odleglosc * Math.sin(radians));
						Point2D punktK = new Point2D.Double(
								punktpoczatku.getX() + x2, punktpoczatku.getY()
										+ y2);

						if( punktK.getX() > tlo.getWidth())
							punktK.setLocation(tlo.getWidth(),punktK.getY());
						if (punktK.getY() > tlo.getHeight())
							punktK.setLocation(punktK.getX(),tlo.getHeight());

						if( punktK.getX() <0)
							punktK.setLocation(0,punktK.getY());
						if (punktK.getY() < 0)
							punktK.setLocation(punktK.getX(),0);


						g2.draw(new Line2D.Double(poczatek, punktK));
						g2.setColor(Color.green);
						g2.fill(new Ellipse2D.Double(punktK.getX() - 5, punktK
								.getY() - 5, 10, 10));
						avaiablePower = 0;
						koniec = new Point2D.Double(punktK.getX(),
								punktK.getY());

					} else {// rys do budynku

						g2.setColor(Color.blue);
						g2.draw(new Line2D.Double(poczatek, point2d));
						g2.setColor(Color.red);
						g2.fill(new Ellipse2D.Double(point2d.getX() - 5,
								point2d.getY() - 5, 10, 10));

						/*System.out.println("dostepna moc przed budynkiem  "
								+ (avaiablePower - stalaBudynkow - 32.45d - 20
										* Math.log10(czestotliwosc) - 20 * Math
										.log10(punktpoczatku.distance(point2d)
												/ skala)));*/
						koniec = new Point2D.Double(point2d.getX(),
								point2d.getY());
					}

					poczatek = point2d;
					g2.setColor(Color.blue);
				} else { // budynki
					odleglosc = (double) Math
							.pow(10,
									(avaiablePower
											- getRequiredPower(poczatek,
													point2d, buildings)
											- stalaBudynkow - 32.45 - 20 * Math
											.log10(czestotliwosc)) / 20)
							* skala;

					if ((avaiablePower
							- getRequiredPower(poczatek, point2d, buildings)
							- stalaBudynkow - 32.45d - 20
							* Math.log10(czestotliwosc) - 20 * Math
							.log10(punktpoczatku.distance(point2d) / skala)) < 0) {

						Point2D punktK = new Point2D.Double(point2d.getX(),
								point2d.getY());

						int x2 = (int) (poczatek.distance(punktK) * Math
								.cos(radians));
						int y2 = (int) (poczatek.distance(punktK) * Math
								.sin(radians));

						while ((avaiablePower
								- getRequiredPower(poczatek, punktK, buildings)
								- stalaBudynkow - 32.45d - 20
								* Math.log10(czestotliwosc) - 20 * Math
								.log10(punktpoczatku.distance(punktK) / skala)) < 0) {
							odleglosc = poczatek.distance(punktK) - 1;
							if (odleglosc > 0) {
								x2 = (int) (odleglosc * Math.cos(radians));
								y2 = (int) (odleglosc * Math.sin(radians));
								punktK = new Point2D.Double(poczatek.getX()
										+ x2, poczatek.getY() + y2);
							} else {
								break;
							}

						}
						if( punktK.getX() > tlo.getWidth())
							punktK.setLocation(tlo.getWidth(),punktK.getY());
						if (punktK.getY() > tlo.getHeight())
							punktK.setLocation(punktK.getX(),tlo.getHeight());

						if( punktK.getX() <0)
							punktK.setLocation(0,punktK.getY());
						if (punktK.getY() < 0)
							punktK.setLocation(punktK.getX(),0);

						//System.out.println("wspolrzedne konca (budynki) x " + punktK.getX()+" y "+ punktK.getY());
						g2.draw(new Line2D.Double(poczatek, punktK));
						g2.setColor(Color.green);
						g2.fill(new Ellipse2D.Double(punktK.getX() - 5, punktK
								.getY() - 5, 10, 10));
						avaiablePower = 0;
						koniec = new Point2D.Double(punktK.getX(),
								punktK.getY());

					} else {// narysuj do sciany

						g2.setColor(Color.blue);
						g2.draw(new Line2D.Double(poczatek, point2d));
						g2.setColor(Color.red);
						g2.fill(new Ellipse2D.Double(point2d.getX() - 5,
								point2d.getY() - 5, 10, 10));
						stalaBudynkow = stalaBudynkow
								+ getRequiredPower(poczatek, point2d, buildings);
						/*System.out.println("dostepna moc na koncu budynku  "
								+ (avaiablePower - stalaBudynkow - 32.45d - 20
										* Math.log10(czestotliwosc) - 20 * Math
										.log10(punktpoczatku.distance(point2d)
												/ skala)));*/
						koniec = new Point2D.Double(point2d.getX(),
								point2d.getY());
					}

					poczatek = point2d;
					g2.setColor(Color.blue);

				}

			}
		}
		//System.out.println("wspolrzedne konca x " + koniec.getX() +" y "+ koniec.getY());
		setKoniec(koniec);
	}

	private List<Point2D> getIntersectionPoints(List<Building> buildings) {
		double odleglosc = Math.pow(10,
				(zysk - 32.45 + 20 * Math.log10(czestotliwosc)) / 20)
				* skala; // *skala //zmienilem 4.12

		float x2 = (float) (odleglosc * Math.cos(radians));
		float y2 = (float) (odleglosc * Math.sin(radians));

		Point2D koniec = new Point2D.Double(punktpoczatku.getX() + x2,
				punktpoczatku.getY() + y2);
		Line2D line = new Line2D.Double(punktpoczatku, koniec);

		List<Point2D> intesectionPoints = new ArrayList<>();
		for (Building building : buildings) {
			intesectionPoints.addAll(building.getIntersectionPoint(line));
		}
		Collections.sort(intesectionPoints, new Comparator<Point2D>() {
			@Override
			public int compare(Point2D one, Point2D other) {
				return Double.compare(punktpoczatku.distance(one),
						punktpoczatku.distance(other));
			}
		});
		intesectionPoints.add(koniec);
		return intesectionPoints;
	}

	static void setSkala(String text) {
		skala = Double.parseDouble(text);
	}

	private double getRequiredPower(Point2D from, Point2D to,
			List<Building> buildings) {
		double osrodek = getOsrodek(from, to, buildings);
		return from.distance(to) * osrodek;// +32.54f;

	}

	private double getOsrodek(Point2D from, Point2D to, List<Building> buildings) {
		for (Building building : buildings) {

			if (building.containsMidPoint(from, building.MidPoint(from, to))) {

				return Double.parseDouble(building.getTlumienie());

			}
		}
		return 1;
	}
	public Point2D getKoniec()
	{
		return koniec;
	}

	private void setKoniec(Point2D koniecset) {
		koniec=koniecset;
	}


}