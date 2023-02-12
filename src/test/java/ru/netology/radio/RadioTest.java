package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     5; 5",
            "Invalid value test 1;  -4; 0",
            "Invalid value test 2;  13; 0",
            "Boundary value test 1; -1; 0",
            "Boundary value test 2;  0; 0",
            "Boundary value test 3;  1; 1",
            "Boundary value test 4;  8; 8",
            "Boundary value test 5;  9; 9",
            "Boundary value test 6; 10; 0",
    }, delimiter = ';')
    void setSelectStationDirectly(String nameTest, int inputSelectStation, int expectedStation) {

        radio.setTheRadioStationNumberDirectly(inputSelectStation);
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;    5; 6",
            "Boundary value test 1; 0; 1",
            "Boundary value test 2; 1; 2",
            "Boundary value test 3; 8; 9",
            "Boundary value test 4; 9; 0",
    }, delimiter = ';')
    void setNextStation(String nameTest, int сurrentStation, int expectedNextStation) {

        radio.setCurrentStation(сurrentStation);
        radio.setNextStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedNextStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;    5; 4",
            "Boundary value test 1; 0; 9",
            "Boundary value test 2; 1; 0",
            "Boundary value test 3; 8; 7",
            "Boundary value test 4; 9; 8",
    }, delimiter = ';')
    void setPrevCurrentStation(String nameTest, int сurrentStation, int expectedPrevStation) {

        radio.setCurrentStation(сurrentStation);
        radio.setPrevStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedPrevStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;      5; 6",
            "Boundary value test 1;   0; 1",
            "Boundary value test 2;   1; 2",
            "Boundary value test 3;  9; 10",
            "Boundary value test 4; 10; 10",
    }, delimiter = ';')
    void setVolumeUp(String nameTest, int сurrentVolume, int expectedVolume) {

        radio.setCurrentVolume(сurrentVolume);
        radio.increaseTheVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     5; 4",
            "Boundary value test 1;  0; 0",
            "Boundary value test 2;  1; 0",
            "Boundary value test 3;  9; 8",
            "Boundary value test 4; 10; 9",
    }, delimiter = ';')
    void setVolumeDown(String nameTest, int сurrentVolume, int expectedVolume) {

        radio.setCurrentVolume(сurrentVolume);
        radio.downTheVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}


