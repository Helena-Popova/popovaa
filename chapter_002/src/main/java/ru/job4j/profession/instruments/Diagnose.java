package ru.job4j.profession.instruments;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */

public class Diagnose {
    String disease;
    String prescribe;

    /**
     * Конструктор для метода по умолчанию.
     * устанавливает пустую строку, если пациент без болезней.
     */
    public void isDisease() {
        this.disease = "";
    }

    /**
     * Конструктор метода. Устанавливает название болезни из пераметров
     * @param ill
     */
    public void isDisease(String ill) {
        this.disease = ill;
    }

    /**
     * Возвращает предписание врача
     * @return String
     */
    public String getPrescribe() {
        if (!this.disease.equals("")) {
            return "Please, take some medicine for you " + this.disease;
        }
        return "You are healthy!";
    }

}
