package praca.core;

public class AntennaCharacteristicSingleLine {

    public final int dAngle;
    public final int powerOnDAngle;

    public AntennaCharacteristicSingleLine(int dAngle, int powerOnDAngle) {
        this.dAngle = dAngle;
        this.powerOnDAngle = powerOnDAngle;
    }

    public static AntennaCharacteristicSingleLine fromLine(String line) {
        String[] words = line.split("\t");
        int dAngle = Integer.parseInt(words[0]);
        int powerOnDAngle = Integer.parseInt(words[1]);
        return new AntennaCharacteristicSingleLine(dAngle, powerOnDAngle);
    }
}
