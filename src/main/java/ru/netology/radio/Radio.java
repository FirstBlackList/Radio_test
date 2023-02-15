package ru.netology.radio;


public class Radio {

    int maxStation;
    int minStation = 0;
    int maxVolume = 100;
    int minVolume = 0;
    int currentStation;
    int currentVolume = 30;

    public Radio() {
        this.maxStation = 9;
    }

    public Radio(int selectStation) {
        this.maxStation = selectStation - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < minStation || newCurrentStation > maxStation) {
            return;
        }
        this.currentStation = newCurrentStation;
    }

    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
            return;
        }
        ++currentStation;
    }

    public void prevStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
            return;
        }
        --currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minVolume || newCurrentVolume > maxVolume) {
            return;
        }
        this.currentVolume = newCurrentVolume;

    }

    public void increaseTheVolume() {
        if (currentVolume >= maxVolume) {
            return;
        }
        ++currentVolume;
    }

    public void downTheVolume() {
        if (currentVolume <= minVolume) {
            return;
        }
        --currentVolume;
    }


}
