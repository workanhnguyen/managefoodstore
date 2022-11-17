package com.nva.pojo;

public class TimeField {
    private int id;
    private String name;
    public TimeField() {

    }
    public TimeField(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
