package ru.job4j.profession;

public class Pacient{

    private String name;
    private String desiase;

    public Pacient(String sign) {
        this.name = sign;
        this.desiase = "";
    }

    public Pacient(String sign, String ill) {
        this.name = sign;
        this.desiase = ill;
    }

    public String getDesiase() {
        return this.desiase;
    }
}
