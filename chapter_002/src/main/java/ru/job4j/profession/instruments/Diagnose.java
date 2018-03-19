package ru.job4j.profession;

public class Diagnose {
    String disease;
    String prescribe;

    public void isDisease(){
        this.disease = "";
    }

    public void isDisease(String ill){
        this.disease = ill;
    }

    public String getPrescribe() {
        if(!this.disease.equals("")) {
            return "Please, take some medicine for you " + this.disease;
        }
        return "You are healthy!";
    }

}
