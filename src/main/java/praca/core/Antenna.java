package praca.core;

public class Antenna {
    public final int power;
    public final int angle;
    public final int frequency;
    public final AntennaCharacteristic characteristic;

    public Antenna(int power, int angle, int frequency, AntennaCharacteristic characteristic) {
        this.power = power;
        this.angle = angle;
        this.frequency = frequency;
        this.characteristic = characteristic;
    }
}
