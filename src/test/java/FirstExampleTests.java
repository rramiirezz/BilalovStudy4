import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import test.inno.study.BasicJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstExampleTests {

    private static final Random random = new Random();

    @BeforeEach
    void beforeEach() {
        System.out.println("""
                ========================
                Test method start""");
    }

    @AfterEach
    void afterEach() {
        System.out.println("""
                Test method end
                ========================""");
    }

    //Задание 3.1 - возвращает булево значение
    @Test
    void isEvenTest(){
        int randomNumber = random.nextInt(101);
        boolean result = BasicJava.isEven(randomNumber);
        boolean expected = randomNumber % 2 == 0;
        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для числа: " + randomNumber);
    }

    //Задание 3.1 - должен вернуть неверное значение (ассерт должен падать)
    @ParameterizedTest
    @CsvSource({
            "5, 4 4 3 2 1 Поехали!"
    })
    void blastOffTest(int start, String expected){
        String result = BasicJava.blastOff(start);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для строки: " + result);
    }

    //Задание 3.1 - должен возвращать список
    @Test
    void testGenerateSequenceReturnsListWithCorrectValues() {
        List<Integer> result = BasicJava.generateSequence(5);
        List<Integer> expected = List.of(1, 2, 3, 4, 5);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для числа: " + result);
    }

    //Задание 3.1 - возвращает булево значение
    @RepeatedTest(20)
    void checkAccessTest(){
        int age = random.nextInt(100);
        String result = BasicJava.checkAccess(age);
        String expected = age >= 18 ? "Allowed" : "Denied";

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для возраста " + age);
    }

    private static Stream<Integer> generateRandomScores() {
        return Stream.generate(() -> random.nextInt(101)).limit(10);}

    @ParameterizedTest
    @MethodSource("generateRandomScores")
    void getGradeTest(int score){
        String result = BasicJava.getGrade(score);
        System.out.println("getGrade(" + score + ") = " + result);
    }
}