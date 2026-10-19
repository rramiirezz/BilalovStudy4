import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import test.inno.study.BasicJava;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondExampleTests {

    private static final Random random = new Random();
    private static final List<String> NAMES = Arrays.asList("Анна", "Борис", "Виктор", "Иван", "Мария", "Петр", "Ольга");

    @Tag("replay")
    @RepeatedTest(10)
    void isEvenTest(){
        int randomNumber = random.nextInt(101);
        boolean result = BasicJava.isEven(randomNumber);
        boolean expected = randomNumber % 2 == 0;

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для числа: " + randomNumber);
    }

    @Tag("replay")
    @RepeatedTest(10)
    void checkAccessTest(){
        int randomAge = random.nextInt(101);
        String result = BasicJava.checkAccess(randomAge);
        String expected = randomAge >= 18 ? "Allowed" : "Denied";

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для возраста " + randomAge);
    }

    @Tag("replay")
    @RepeatedTest(10)
    void isPositiveTest(){
        int randomNumber = random.nextInt(201) - 100;
        boolean result = BasicJava.isPositive(randomNumber);
        boolean expected = randomNumber > 0;

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для числа " + randomNumber);
    }

    @Tag("replay")
    @RepeatedTest(10)
    void findMaxTest() {
        int[] randomArray = random.ints(5, -100, 101).toArray();
        int expected = Arrays.stream(randomArray).max().getAsInt();
        int result = BasicJava.findMax(randomArray);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для массива: " + Arrays.toString(randomArray));
    }

    @Test
    void getGradeTest(){
        int randomPoint = random.nextInt(101);
        String result = BasicJava.getGrade(randomPoint);
        String expected;

        if (randomPoint < 0 || randomPoint > 100) {
            expected = "Error";
        } else if (randomPoint <= 20) {
            expected = "E";
        } else if (randomPoint <= 40) {
            expected = "D";
        } else if (randomPoint <= 60) {
            expected = "C";
        } else if (randomPoint <= 80) {
            expected = "B";
        } else {
            expected = "A";
        }

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для баллов " + randomPoint);
    }

    @Test
    void sumTonTest(){
        int randomNumber = random.nextInt(10);
        int result = BasicJava.sumToN(randomNumber);
        int expected = randomNumber * (randomNumber + 1) / 2;

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + ", полученное значение: " + result + " для n = " + randomNumber);
    }

    @Test
    void calcAverageTest() {
        List<Integer> randomList = new Random()
                .ints(4, 1, 100)
                .boxed()
                .toList();
        double result = BasicJava.calcAverage(randomList);
        double expected = randomList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        assertEquals(expected, result, 0.001,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для списка: " + randomList);
    }

    @Test
    void removeSpecificNameTest() {
        List<String> allNames = new ArrayList<>(NAMES);
        Collections.shuffle(allNames, random);
        List<String> inputList = allNames.subList(0, 5);

        String nameToRemove = inputList.get(random.nextInt(inputList.size()));

        List<String> expected = new ArrayList<>(inputList);
        expected.removeIf(nameToRemove::equals);

        List<String> result = BasicJava.removeSpecificName(inputList, nameToRemove);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для списка: " + inputList);
    }

    @ParameterizedTest
    @CsvSource({
            "There is a bug in the login module, false",
            "System is running smoothly, false",
            "Bug detected in database connection, true",
            "All tests passed successfully, false",
            "Critical bug found in API endpoint, false",
            "No issues detected during execution, false",
            "Performance is optimal no bugs, false"
    })
    void hasBugTest(String text, boolean expected) {
        boolean result = BasicJava.hasBug(new String[]{text});
        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для текста: \"" + text + "\"");
    }


    @ParameterizedTest
    @CsvSource({
            "1, 1 Поехали!",
            "3, 3 2 1 Поехали!",
            "5, 5 4 3 2 1 Поехали!"
    })
    void blastOffTest(int start, String expected){
        String result = BasicJava.blastOff(start);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для строки: " + result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 10,0 2 4 6 8 10",
            "2, 2,2",
            "-4, 4,-4 -2 0 2 4",
            "7, 9,8",
    })
    void getEvenInRangeTest(int start, int end, String expected){
        String result = BasicJava.getEvenInRange(start,end);

        assertEquals(expected, result,
                "Ожидаемое значение: " + expected + "; полученное значение: " + result + " для строки: " + result);
    }

    @ParameterizedTest
    @MethodSource("reverseArrayTestData")
    void reverseTest(String[] input, String[] expected) {
        String[] result = BasicJava.reverse(input);

        assertArrayEquals(expected, result,
                "Ожидаемое значение: " + Arrays.toString(expected) + "; полученное значение: " + Arrays.toString(result));
    }

    static Stream<Arguments> reverseArrayTestData() {
        return Stream.of(
                Arguments.of(new String[]{"One", "Two", "Zero"}, new String[]{"Zero", "Two", "One"}),
                Arguments.of(new String[]{"Hello", "World"}, new String[]{"World", "Hello"})
        );
    }
}
