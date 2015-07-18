package praca.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AntennaCharacteristic {
    public final List<AntennaCharacteristicSingleLine> lines;

    public AntennaCharacteristic(List<AntennaCharacteristicSingleLine> lines) {
        this.lines = lines;
    }

    public static AntennaCharacteristic readCharacteristicFromFile(String filename) {
        System.out.println(new File(filename).getAbsolutePath());
        List<AntennaCharacteristicSingleLine> characteristic = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                characteristic.add(AntennaCharacteristicSingleLine.fromLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AntennaCharacteristic(characteristic);
    }
}
