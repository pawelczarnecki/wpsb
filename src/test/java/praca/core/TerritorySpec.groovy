package praca.core

import spock.lang.Specification

import static praca.core.FieldAntennaParams.enableAntennaParams

class TerritorySpec extends Specification {
    private int power = 10
    private int angle = 10
    private int frequency = 10
    private AntennaCharacteristic antennaCharacteristic = new AntennaCharacteristic([])
    private Antenna antenna = new Antenna(power, 10, angle, frequency, antennaCharacteristic)

    def "Should calculate cover"() {
        given:
        def territory = new Territory(1, 1)

        and:
        territory.setAntennaPossiblePlaces(new Rectangle(0, 0, 1, 1), enableAntennaParams)

        when:
        def cover = territory.cover(antenna)

        then:
        cover.isFull()
    }
}
