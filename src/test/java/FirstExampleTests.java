import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test.inno.study.BasicJava;

import java.util.Random;
import java.util.stream.Stream;

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

    @Test
    void isEvenTest(){
        int randomNumber = random.nextInt(101);
        boolean result = BasicJava.isEven(randomNumber);
        System.out.println("isEven(" + randomNumber + ") = " + result);
    }

    @RepeatedTest(20)
    void checkAccessTest(){
        int age = random.nextInt(100);
        String result = BasicJava.checkAccess(age);
        System.out.println("checkAccess(" + age + ") = " + result);
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