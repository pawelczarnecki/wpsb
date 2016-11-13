package tab1;

import praca.core.Antenna;
import praca.core.AntennaCharacteristic;
import praca.core.AntennaCharacteristicSingleLine;
import praca.utils.BufferedImageUtils;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AntennaDrawable {

    // private static final int CHANGING_LINES_LENGHT = 2;
    private static final BufferedImage icon = BufferedImageUtils.antenaIcon();
    private final int x;
    private final int y;
    private Antenna antenna;
    private final List<Linia> lines = new ArrayList<>();
    public BufferedImage backGroundImageAntennaDrawable;
    private Point2D pkt1;
    private Point2D pkt2;
    private double dlugoscab=1;
    private double dlugoscbc=1;
    private double Pole=0;

    public static AntennaDrawable newAntenna(int x, int y, String filename) {
        return new AntennaDrawable(x, y, new Antenna(10, -88, 0, 800, AntennaCharacteristic.readCharacteristicFromFile(filename)));
    }

    public AntennaDrawable(int x, int y, Antenna antenna) {
        this.x = x;
        this.y = y;
        this.antenna = antenna;
    }

    public void draw(Graphics2D g2, List<Building> buildings, BufferedImage backGroundImageAntennaDrawable) {
        g2.drawImage(icon, x - icon.getWidth() / 2, y - icon.getHeight() / 2,  Color.WHITE, null);
        Graphics2D create = (Graphics2D) g2.create();
        this.backGroundImageAntennaDrawable=backGroundImageAntennaDrawable;
        //create.rotate(Math.toRadians(angle));
        for (Linia line : lines) {
            create.setColor(Color.blue);
            line.drawOneLine(create, buildings);
        }
        create.dispose();
    }

    public void drawLines(List<Building> buildings) {
        lines.clear();
        for (AntennaCharacteristicSingleLine singleLine : antenna.characteristic.lines) {
            drawOneLine(buildings, singleLine, backGroundImageAntennaDrawable);
        }
        for(int i=0; i<10; i++) {
            pkt1 = lines.get(i).getKoniec();
            System.out.println("koniec kreski  x" + pkt1.getX() + " y" + pkt1.getY());
        }
    }

    @Override
    public String toString() {
        return "Antenna on x:" + x + " y:" + y;
    }

    private void drawOneLine(List<Building> buildings, AntennaCharacteristicSingleLine singleLine, BufferedImage backGroundImageAntennaDrawable) {
        double procentZysk = 20 * Math.log10(singleLine.power / 100d);
        double kat = singleLine.angle + antenna.angle;
        //double radians = Math.toRadians(kat);
        Point2D point = new Point2D.Double(x, y);

        Linia line = new Linia(point, antenna.gain + procentZysk - antenna.minGain, kat, antenna.frequency, backGroundImageAntennaDrawable);
        lines.add(line);
    }

    private void count()
    {
        //Linia line1;
        //for (AntennaCharacteristicSingleLine singleLine : antenna.characteristic.lines) {

            //line1=lines.get();
            for( int i =0;i<2;i++) {
                pkt1 = lines.get(i).getKoniec();
                pkt2 = lines.get(i++).getKoniec();
                dlugoscab = Math.sqrt(Math.pow(Math.abs(pkt1.getX() - x), 2) + Math.pow(Math.abs(pkt1.getY() - y), 2));
                dlugoscbc = Math.sqrt(Math.pow(Math.abs(pkt2.getX() - x), 2) + Math.pow(Math.abs(pkt2.getY() - y), 2));
                Pole = Pole + ((1 / 2) * dlugoscab * dlugoscbc * Math.sin(antenna.angle));
            }

        //}

        System.out.println("Zakreœlone pole " + Pole );
    }



    public String getGain() {
        return "" + antenna.gain;
    }

    public void setGain(String text) {
        antenna = antenna.withGain(Integer.parseInt(text));
    }

    public String getMinGain() {
        return "" + antenna.minGain;
    }

    public void setMinGain(String text) {
        antenna = antenna.withMinGain(Integer.parseInt(text));
    }

    public String getFrequency() {
        return "" + antenna.frequency;
    }

    public void setFrequency(String text) {
        antenna = antenna.withFrequency(Integer.parseInt(text));
    }

    public String getAngle() {
        return "" + antenna.angle;
    }

    public void setAngle(String text) {
        antenna = antenna.withAngle(Integer.parseInt(text));
    }
}
