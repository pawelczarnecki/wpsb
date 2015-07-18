package praca.core;

public class Antenna {
    public final int gain;
    public final int minGain;
    public final double angle;
    public final int frequency;
    public final AntennaCharacteristic characteristic;

    public Antenna(int gain, int minGain, double angle, int frequency, AntennaCharacteristic characteristic) {
        this.gain = gain;
        this.minGain = minGain;
        this.angle = angle;
        this.frequency = frequency;
        this.characteristic = characteristic;
    }

    public Antenna withAngle(double angle) {
        return new Antenna(gain, minGain, angle, frequency, characteristic);
    }

    public Antenna withGain(int gain) {
        return new Antenna(gain, minGain, angle, frequency, characteristic);
    }

    public Antenna withMinGain(int minGain) {
        return new Antenna(gain, minGain, angle, frequency, characteristic);
    }

    public Antenna withFrequency(int frequency) {
        return new Antenna(gain, minGain, angle, frequency, characteristic);
    }
}
