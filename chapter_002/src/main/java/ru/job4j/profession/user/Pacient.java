package ru.job4j.profession.user;
/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */
public class Pacient {

    private String name;
    private String desiase;


    /**
     * Конструктор для Пациента , если вбили только имя.
     * @param sign имя
     */
    public Pacient(String sign) {
        this.name = sign;
        this.desiase = "";
    }

    /**
     * Конструктор
     * @param sign имя
     * @param ill болезнь
     */
    public Pacient(String sign, String ill) {
        this.name = sign;
        this.desiase = ill;
    }

    /**
     * геттер бля поля Болезнь
     * @return название болезни
     */
    public String getDesiase() {
        return this.desiase;
    }


    /**
     * Возвращает имя пациента.
     * @return string name
     */
    public String getName() {
        return this.name;
    }
}
