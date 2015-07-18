package praca.core;

import java.util.List;

public class AntennaCharacteristic {
    public final List<AntennaCharacteristicSingleLine> lines;

    public AntennaCharacteristic(List<AntennaCharacteristicSingleLine> lines) {
        this.lines = lines;
    }
}
