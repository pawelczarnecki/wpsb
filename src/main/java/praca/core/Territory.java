package praca.core;

import java.util.ArrayList;
import java.util.List;

public class Territory {

    final private List<List<Field>> fields;

    public Territory(int wight, int height) {
        fields = new ArrayList<>(height);
        for (int y = 0; y < height; y++) {
            ArrayList<Field> row = new ArrayList<>(wight);
            for (int x = 0; x < wight; x++) {
                row.add(new Field());
            }
            fields.add(row);
        }
    }

    Field getField(int x, int y) {
        return fields.get(y).get(x);
    }

    void setRectangleBuilding(Rectangle area, FiledBuildingParams filedBuildingParams) {
        for (int y = area.y; y < area.y + area.height; y++) {
            List<Field> row = this.fields.get(y);
            for (int x = area.x; x < area.x + area.width; x++) {
                row.get(x).filedBuildingParams = filedBuildingParams;
            }
        }
    }

    void setAntennaPossiblePlaces(Rectangle area, FieldAntennaParams fieldAntennaParams){
        for (int y = area.y; y < area.y + area.height; y++) {
            List<Field> row = this.fields.get(y);
            for (int x = area.x; x < area.x + area.width; x++) {
                row.get(x).fieldAntennaParams = fieldAntennaParams;
            }
        }
    }
}
