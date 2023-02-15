package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     5; 5",
            "Invalid value test  1; -4; 0",
            "Invalid value test  2; 13; 0",
            "Boundary value test 1; -1; 0",
            "Boundary value test 2;  0; 0",
            "Boundary value test 3;  1; 1",
            "Boundary value test 4;  8; 8",
            "Boundary value test 5;  9; 9",
            "Boundary value test 6; 10; 0",
    }, delimiter = ';')
    void setSelectStationDirectly(String nameTest, int inputSelectStation, int expectedStation) {

        radio.setCurrentStation(inputSelectStation);
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
    void nextStationDefaultSetting(String nameTest, int сurrentStation, int expectedNextStation) {

        radio.setCurrentStation(сurrentStation);
        radio.nextStation();
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
    void prevStationDefaultSetting(String nameTest, int сurrentStation, int expectedPrevStation) {

        radio.setCurrentStation(сurrentStation);
        radio.prevStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedPrevStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;       5; 6",
            "Boundary value test 1;    0; 1",
            "Boundary value test 2;    1; 2",
            "Boundary value test 3; 99; 100",
            "Boundary value test 4;100; 100",
    }, delimiter = ';')
    void setVolumeUp(String nameTest, int сurrentVolume, int expectedVolume) {

        radio.setCurrentVolume(сurrentVolume);
        radio.increaseTheVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;      5; 4",
            "Boundary value test 1;   0; 0",
            "Boundary value test 2;   1; 0",
            "Boundary value test 3; 99; 98",
            "Boundary value test 4;100; 99",
    }, delimiter = ';')
    void setVolumeDown(String nameTest, int сurrentVolume, int expectedVolume) {

        radio.setCurrentVolume(сurrentVolume);
        radio.downTheVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     1;  0;  0",
            "Invalid value test  1;  1; -9;  0",
            "Invalid value test  2;  1;  3;  0",
            "Boundary value test 1;  1; -1;  0",
            "Boundary value test 2;  1;  1;  0",
            "Critical path test;    22; 13; 13",
            "Invalid value test  1; 22;-18;  0",
            "Invalid value test  2; 22; 35;  0",
            "Boundary value test 1; 22; -1;  0",
            "Boundary value test 2; 22;  0;  0",
            "Boundary value test 3; 22;  1;  1",
            "Boundary value test 4; 22; 20; 20",
            "Boundary value test 5; 22; 21; 21",
            "Boundary value test 6; 22; 22;  0",
    }, delimiter = ';')
    void setCurrentStationSetting(String nameTest, int counterStation, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(inputSelectStation);
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     1;  0;  0",
            "Critical path test;    22; 14; 15",
            "Boundary value test 1; 22;  0;  1",
            "Boundary value test 2; 22;  1;  2",
            "Boundary value test 3; 22; 20; 21",
            "Boundary value test 4; 22; 21;  0",
    }, delimiter = ';')
    void nextStationSetting(String nameTest, int counterStation, int currentStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;     1;  0;  0",
            "Critical path test;    22; 14; 13",
            "Boundary value test 1; 22;  0; 21",
            "Boundary value test 2; 22;  1;  0",
            "Boundary value test 3; 22; 20; 19",
            "Boundary value test 4; 22; 21; 20",
    }, delimiter = ';')
    void prevStationSetting(String nameTest, int counterStation, int currentStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path test;      50;  50",
            "Invalid value test:  1; -22;  30",
            "Invalid value test:  2; 888;  30",
            "Boundary value test: 1;  -1;  30",
            "Boundary value test: 2;   0;   0",
            "Boundary value test: 3;   1;   1",
            "Boundary value test: 4;  99;  99",
            "Boundary value test: 5; 100; 100",
            "Boundary value test: 6; 101;  30",
    }, delimiter = ';')
    void setCurrentVolume(String nameTest, int currentVolume, int expectedVolume) {

        radio.setCurrentVolume(currentVolume);
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}


