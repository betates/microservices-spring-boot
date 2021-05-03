package com.infosys.learning.dto;

public class PersonRequest extends Person {
    private int yeaOfBirth;

    public PersonRequest() {

    }

    public int getYeaOfBirth() {
        return yeaOfBirth;
    }

    public void setYearOfBirth(int yeaOfBirth) {
        this.yeaOfBirth = yeaOfBirth;
    }
}
