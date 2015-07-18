package praca.core;

public class FieldAntennaParams {

    final boolean canSetAntenna;

    private FieldAntennaParams(boolean canSetAntenna) {
        this.canSetAntenna = canSetAntenna;
    }

    public static FieldAntennaParams defaultAntennaParams() {
        return new FieldAntennaParams(false);
    }

    public static FieldAntennaParams getEnableAntennaParams() {
        return new FieldAntennaParams(true);
    }
}
