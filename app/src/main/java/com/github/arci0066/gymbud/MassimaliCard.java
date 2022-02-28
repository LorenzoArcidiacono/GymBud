package com.github.arci0066.gymbud;

import java.util.Date;

public class MassimaliCard {
    private String exercise;
    private Float maxWeight;
    private String date;

    public MassimaliCard(String exercise, float maxWeight, String date) {
        this.exercise = exercise;
        this.maxWeight = maxWeight;
        this.date = date;
    }

    public String getExercise() {
        return exercise;
    }

    public String getMaxWeight() {
        return maxWeight.toString() + " Kg";
    }

    public String getDate() {
        return date;
    }
}
