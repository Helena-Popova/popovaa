package ru.job4j.profession;
import ru.job4j.profession.user.*;

/**
 * @author Helena
 * @version 1.0
 * @since 18.03.18
 */
public class Teacher extends Profession {

    private String question;

    public Teacher(String specialty, String sign) {
        this.position = specialty;
        this.name = sign;
    }

    public void setQuestion(String idea) {
        this.question = idea;
    }

    public String getQuestion() {
        return this.question;
    }

    public String teach(Student learner) {
        return learner.getAnswerStudent(this.getQuestion());
    }
}
