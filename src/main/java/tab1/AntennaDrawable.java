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

    public static AntennaDrawable newAntenna(int x, int y, String filename) {
        return new AntennaDrawable(x, y, new Antenna(10, -88, 0, 800, AntennaCharacteristic.readCharacteristicFromFile(filename)));
    }

    public AntennaDrawable(int x, int y, Antenna antenna) {
        this.x = x;
        this.y = y;
        this.antenna = antenna;
    }

    public void draw(Graphics2D g2, List<Building> buildings) {
        g2.drawImage(icon, x - icon.getWidth() / 2, y - icon.getHeight() / 2,  Color.WHITE, null);
        Graphics2D create = (Graphics2D) g2.create();
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
            drawOneLine(buildings, singleLine);
        }
    }

    @Override
    public String toString() {
        return "Antenna on x:" + x + " y:" + y;
    }

    private void drawOneLine(List<Building> buildings, AntennaCharacteristicSingleLine singleLine) {
        double procentZysk = 20 * Math.log10(singleLine.power / 100d);
        double kat = singleLine.angle + antenna.angle;
        //double radians = Math.toRadians(kat);
        Point2D point = new Point2D.Double(x, y);

        Linia line = new Linia(point, antenna.gain + procentZysk - antenna.minGain, kat, antenna.frequency);
        lines.add(line);
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
