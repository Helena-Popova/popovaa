package ru.job4j.profession;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */

public class Profession {

    public String position;
    public String name;

    public Profession() {

    }

    public Profession(String work, String sign) {
        this.position = work;
        this.name = sign;
    }

    public void setPosition(String work) {
        this.position = work;
    }

    public void setName(String sign) {
        this.name = sign;
    }

    public String getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

}
