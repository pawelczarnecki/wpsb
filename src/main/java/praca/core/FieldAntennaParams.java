package praca.core;

public class FieldAntennaParams {

    final boolean canSetAntenna;

    public FieldAntennaParams() {
        canSetAntenna = false;
    }

    public static FieldAntennaParams defaultAntennaParams() {
        return new FieldAntennaParams();
    }
}
