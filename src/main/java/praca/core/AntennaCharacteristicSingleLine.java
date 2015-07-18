package praca.core;

public class AntennaCharacteristicSingleLine {

    public final int angle;
    public final int power;

    public AntennaCharacteristicSingleLine(int angle, int power) {
        this.angle = angle;
        this.power = power;
    }

    public static AntennaCharacteristicSingleLine fromLine(String line) {
        String[] words = line.split("\t");
        int dAngle = Integer.parseInt(words[0]);
        int powerOnDAngle = Integer.parseInt(words[1]);
        return new AntennaCharacteristicSingleLine(dAngle, powerOnDAngle);
    }
}
