import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import test.inno.study.BasicJava;

import java.util.*;
import java.util.stream.Stream;

public class SecondExampleTests {

    private static final Random random = new Random();
    private static final List<String> NAMES = Arrays.asList("Анна", "Борис", "Виктор", "Иван", "Мария", "Петр", "Ольга");

    @RepeatedTest(3)
    void isEvenTest(){
        int randomNumber = random.nextInt(101);
        boolean result = BasicJava.isEven(randomNumber);
        System.out.println("isEven(" + randomNumber + ") = " + result);
        if (result){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(4)
    void checkAccessTest(){
        int randomAge = random.nextInt(101);
        String result = BasicJava.checkAccess(randomAge);
        System.out.println("checkAccess(" + randomAge + ") = " + result);
        if ("allowed".equals(result)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(8)
    void isPositiveTest(){
        int randomNumber = random.nextInt(201) - 100;
        boolean result = BasicJava.isPositive(randomNumber);
        System.out.println("isPositive(" + randomNumber+ ") = " + result);
        if (result){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(6)
    void findMaxTest() {
        int[] randomArray = random.ints(5, -100, 101).toArray();
        int expected = Arrays.stream(randomArray).max().getAsInt();
        int result = BasicJava.findMax(randomArray);

        System.out.println("findMax" + Arrays.toString(randomArray) + ") = " + result);
        if (result == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    void getGradeTest(){
        int randomPoint = random.nextInt(101);
        String result = BasicJava.getGrade(randomPoint);
        System.out.println("getGrade(" + randomPoint + ") = " + result);
        if (result.equals("A") || result.equals("B")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    void sumTonTest(){
        int randomNumber = random.nextInt(10);
        int result = BasicJava.sumToN(randomNumber);
        System.out.println("sumToN(" + randomNumber + ") = " + result);
        if (result == randomNumber * (randomNumber + 1)/2){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    void calcAverageTest() {
        List<Integer> randomList = new Random()
                .ints(4, 1, 100)
                .boxed()
                .toList();
        double result = BasicJava.calcAverage(randomList);
        int expected = (int) (randomList.stream().mapToInt(Integer::intValue).sum() / randomList.size());
        System.out.println("calcAverage(" + randomList + ") = " + result);
        if (result == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
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

        System.out.println("removeSpecificName(" + inputList + ", \"" + nameToRemove + "\") = " + result);
        if (result.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "There is a bug in the login module",
            "System is running smoothly",
            "Bug detected in database connection",
            "All tests passed successfully",
            "Critical bug found in API endpoint",
            "No issues detected during execution",
            "Performance is optimal, no bugs"
    })
    void hasBugTest(String text) {
        boolean result = BasicJava.hasBug(new String[]{text});
        System.out.print("hasBug(\"" + Arrays.toString(new String[]{text}) + "\") = " + result + " - ");
        if (result) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1 Поехали!",
            "3, 3 2 1 Поехали!",
            "5, 4 4 3 2 1 Поехали!"
    })
    void blastOffTest(int start, String expected){
        String result = BasicJava.blastOff(start);
        System.out.println("blastOff(" + start + ") = " + result);
        if (result.equals(expected)){
            System.out.println("TEST PASSED");
        } else{
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 10,0 2 4 6 8 10",
            "2, 2,2",
            "-4, 4,-4,-2 0 3",
            "7, 9,8",
    })
    void getEvenInRangeTest(int start, int end, String expected){
        String result = BasicJava.getEvenInRange(start,end);
        System.out.println("getEvenInRange(" + start + ";" + end +") = " + result);
        if (result.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @MethodSource("reverseArrayTestData")
    void reverseTest(String[] input, String[] expected) {
        String[] result = BasicJava.reverse(input);
        System.out.println("reverse(" + Arrays.toString(input) + ") = " + Arrays.toString(result));
        if (Arrays.equals(result, expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    static Stream<Arguments> reverseArrayTestData() {
        return Stream.of(
                Arguments.of(new String[]{"One", "Two", "Zero"}, new String[]{"Zero", "Two", "One"}),
                Arguments.of(new String[]{"Hello", "World"}, new String[]{"Hello", "World"})
        );
    }
}