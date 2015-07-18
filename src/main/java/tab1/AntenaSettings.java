package tab1;

public class AntenaSettings {
    private final double gain;
    private final double angle;
    private final String file;

    public AntenaSettings(double gain, double angle, String file) {
        this.gain = gain;
        this.angle = angle;
        this.file = file;
    }
}