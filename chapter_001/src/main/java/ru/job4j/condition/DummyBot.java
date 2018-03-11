package ru.job4j.condition;

/**
 * Stupid bot class.
 *@author Popova Alena
 *@version 1.0
 *@since 06.03.18
 */
public class DummyBot {

    /**
     *Method for answer of DummyBot.
     *@param questions Input user questions.
     *@result strFromBot Answer from DummyBot.
     */
    public String answer(String questions) {
        String strFromBot = "Это ставит меня в тупик. Спросите другой вопрос.";

        if (questions.equals("Привет, Бот")) {
            strFromBot = "Привет, умник.";
        } else if (questions.equals("Как звать первого президета Америки?")) {
            strFromBot = "Джордж Вашингтон";
        }

        return strFromBot;
    }
}
