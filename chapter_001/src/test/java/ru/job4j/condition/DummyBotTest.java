package ru.job4j.condition;



import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DummyBotTest {

    @Test
    public void whenWeAscHelloBotBotAnsHelloSmartAss() {
        DummyBot robot = new DummyBot();
        String result = robot.answer("Привет, Бот");
        String expected = "Привет, умник.";
        assertThat(result, is(expected));
    }

    @Test
    public void whoisFirstPresidentOfAmerica() {
        DummyBot robot = new DummyBot();
        String result = robot.answer("Как звать первого президета Америки?");
        String expected = "Джордж Вашингтон";
        assertThat(result, is(expected));
    }

    @Test
    public void whenWeAscUnknowAnsBotAnsIDontUnderstend() {
        DummyBot robot = new DummyBot();
        String result = robot.answer("Сколько будет 2 + 2?");
        String expected = "Это ставит меня в тупик. Спросите другой вопрос.";
        assertThat(result, is(expected));
    }

}