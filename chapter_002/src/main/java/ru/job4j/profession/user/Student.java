package ru.job4j.profession.user;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */
public class Student {
    private String name;
    private String answerStudent;

    /**
     * Конструктор
     * @param sign
     */
    public Student(String sign) {
        this.name = sign;
    }

    /**
     * Метод возвращает ответ студента на вопрос
     * @param questions
     * @return ответ студета
     */
    public String getAnswerStudent(String questions) {
        String answerStudent = "Это ставит меня в тупик. Спросите другой вопрос.";

        if (questions.equals("Привет, студент")) {
            answerStudent = "Здравствуйте, сер.";
        } else if (questions.equals("Как звать первого президета Америки?")) {
            answerStudent = "Джордж Вашингтон";
        }

        return answerStudent;
    }
}
