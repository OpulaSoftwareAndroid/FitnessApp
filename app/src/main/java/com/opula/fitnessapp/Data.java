package com.opula.fitnessapp;

class Data {

    public String txt1;
    public String diet1,diet2,diet3;

    public Data(String txt1, String diet1, String diet2, String diet3) {
        this.txt1 = txt1;
        this.diet1 = diet1;
        this.diet2 = diet2;
        this.diet3 = diet3;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getDiet1() {
        return diet1;
    }

    public void setDiet1(String diet1) {
        this.diet1 = diet1;
    }

    public String getDiet2() {
        return diet2;
    }

    public void setDiet2(String diet2) {
        this.diet2 = diet2;
    }

    public String getDiet3() {
        return diet3;
    }

    public void setDiet3(String diet3) {
        this.diet3 = diet3;
    }
}
