package praca.core;

public class FiledBuildingParams {
    final int height;
    final int absorption;

    public FiledBuildingParams(int height, int absorption) {
        this.height = height;
        this.absorption = absorption;
    }

    public static FiledBuildingParams defaultFieldParams() {
        return new FiledBuildingParams(0,Integer.MAX_VALUE);
    }
}
