package br.com.toloni.springbatchapp;

public class Numbers {

    public Integer number;

    public Numbers() {
    }

    public Numbers(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "number=" + number +
                '}';
    }
}
