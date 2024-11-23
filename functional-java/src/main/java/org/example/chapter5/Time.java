package org.example.chapter5;

public record Time(int minutes, int seconds) {

    public Time {
        if (seconds >= 60) {
            int additionMinutes = seconds / 60;
            minutes += additionMinutes;
            seconds -= additionMinutes * 60;
        }
    }
}
