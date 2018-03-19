package ru.job4j.profession;

import ru.job4j.profession.instruments.House;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */

public class Engineer extends Profession {

    public Engineer(String specialty, String sign) {
        this.position = specialty;
        this.name = sign;
    }

    /**
     * Построит ли инженер дом или нет
     * @param town
     * @return true or false
     */
    public boolean buildHouse(House town) {
        return (town.getAmount() >= town.getCost() ? true : false);
    }
}
