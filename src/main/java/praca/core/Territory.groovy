package praca.core

import groovy.transform.CompileStatic

@CompileStatic
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
        iterateOverArea(area, { Field field ->
            field.filedBuildingParams = filedBuildingParams;
        });
    }

    void setAntennaPossiblePlaces(Rectangle area, FieldAntennaParams fieldAntennaParams) {
        iterateOverArea(area, { Field field ->
            field.fieldAntennaParams = fieldAntennaParams;
        });
    }

    Cover cover(List<Antenna> antennas) {
        List<Cover> covers = antennas.collect(this.&cover)
        return new Cover();
    }

    Cover cover(Antenna antenna) {
        return new Cover()
    }

    private void iterateOverArea(Rectangle area, Closure task) {
        fields.subList(area.y, area.y + area.height).each { row ->
            row.subList(area.x, area.x + area.width).each { field ->
                task.call(field);
            }
        }
    }
}
