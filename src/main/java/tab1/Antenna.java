package tab1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Antenna {

    // private static final int CHANGING_LINES_LENGHT = 2;
    private static final BufferedImage icon = antenaIcon();
    private final int x;
    private final int y;
    private double angle;
    private int Zysk;
    private int minZysk;
    private int czestotliwosc;
    private final List<Linia> lines = new ArrayList<>();
    private final List<Building> buildings = new ArrayList<>();
    private final List<AntennaCharacteristicSingleLine> characteristic;

    public static Antenna newAntenna(int x, int y, String filename) {
        return new Antenna(x, y, 0, 10, -88, 800, readCharacteristicFromFile(filename));
    }

    public Antenna(int x, int y, double angle, int Zysk, int minZysk, int czestotliwosc, List<AntennaCharacteristicSingleLine> characteristicFromFile) {
        this.Zysk = Zysk;
        this.minZysk = minZysk;
        this.czestotliwosc = czestotliwosc;
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.characteristic = characteristicFromFile;
    }

    private static List<AntennaCharacteristicSingleLine> readCharacteristicFromFile(String filename) {
        System.out.println(new File(filename).getAbsolutePath());
        List<AntennaCharacteristicSingleLine> characteristic = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                characteristic.add(AntennaCharacteristicSingleLine.fromLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characteristic;
    }

    public void draw(Graphics2D g2, List<Building> buildings) {
        g2.drawImage(icon, x - icon.getWidth() / 2, y - icon.getHeight() / 2,
                Color.WHITE, null);
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
        for (AntennaCharacteristicSingleLine singleLine : characteristic) {
            drawOneLine(buildings, singleLine);
        }
    }

    @Override
    public String toString() {
        return "Antenna on x:" + x + " y:" + y;
    }

    private void drawOneLine(List<Building> buildings, AntennaCharacteristicSingleLine singleLine) {
        double procentZysk = 20 * Math.log10(singleLine.powerOnDAngle / 100d);
        double kat = singleLine.dAngle + angle;
        //double radians = Math.toRadians(kat);
        Point2D point = new Point2D.Double(x, y);

        Linia line = new Linia(point, Zysk + procentZysk - minZysk, kat, czestotliwosc);
        lines.add(line);


    }

    private static BufferedImage antenaIcon() {
        try {
            File file = new File("dane/15.png");
            if (!file.exists())
                throw new RuntimeException("file not found:"
                        + file.getAbsolutePath());
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getZysk() {
        return "" + Zysk;
    }

    public void setZysk(String text) {
        Zysk = Integer.parseInt(text);
    }

    public String getMinZysk() {
        return "" + minZysk;
    }

    public void setMinZysk(String text) {
        minZysk = Integer.parseInt(text);
    }

    public String getCzestotliwosc() {
        return "" + czestotliwosc;
    }

    public void setCzestotliwosc(String text) {
        czestotliwosc = Integer.parseInt(text);
    }

    public String getKat() {
        return "" + angle;
    }



    public void setKat(String text) {
        angle = Integer.parseInt(text);

    }
}
