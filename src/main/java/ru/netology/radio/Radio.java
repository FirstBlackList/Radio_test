package ru.netology.radio;

public class Radio {

    int maxStation = 9;
    int minStation = 0;
    int maxVolume = 10;
    int minVolume = 0;
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        currentStation = newCurrentStation;
    }

    public void setTheRadioStationNumberDirectly(int selectStation) {
        if (selectStation < minStation || selectStation > maxStation) {
            return;
        }
        currentStation = selectStation;
    }

    public void setNextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
            return;
        }
        currentStation = currentStation + 1;
    }

    public void setPrevStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
            return;
        }
        currentStation = currentStation - 1;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        currentVolume = newCurrentVolume;
    }

    public void increaseTheVolume() {
        if (currentVolume >= maxVolume) {
            return;
        }
        currentVolume = currentVolume + 1;
    }

    public void downTheVolume() {
        if (currentVolume <= minVolume) {
            return;
        }
        currentVolume = currentVolume - 1;
    }
}
