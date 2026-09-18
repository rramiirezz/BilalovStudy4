package test.inno.study;

import java.util.Arrays;
import java.util.List;

import static test.inno.study.BasicJava.*;

public class Main {
    static void main() {
        System.out.println(isEven( 6));
        System.out.println(isEven( 3));

        System.out.println(checkAccess( 17));
        System.out.println(checkAccess( 18));
        System.out.println(checkAccess( 19));

        System.out.println(isPositive( -4));
        System.out.println(isPositive( 0));
        System.out.println(isPositive( 10));

        System.out.println(getGrade( 40));
        System.out.println(getGrade( 81));
        System.out.println(getGrade( 150));

        System.out.println(blastOff( 5));
        System.out.println(blastOff( 0));

        System.out.println(sumToN( -11));
        System.out.println(sumToN( 0));
        System.out.println(sumToN( 1));
        System.out.println(sumToN( 7));

        System.out.println(hasBug(new String[]{"Error: something went wrong", "Bug: null pointer", "Info: all good"}));
        System.out.println(hasBug(new String[]{"Error: something went wrong"}));
        System.out.println(hasBug(new String[]{""}));

        System.out.println(getEvenInRange(2,7));
        System.out.println(getEvenInRange(3,3));

        System.out.println(findMax(new int[]{-35,0,31,13}));
        System.out.println(findMax(new int[0]));

        System.out.println(Arrays.toString(reverse(new String[]{"Hello world", "Now or never"})));
        System.out.println(Arrays.toString(reverse(new String[0])));

        System.out.println(calcAverage(Arrays.asList(2, 5, 3, 10, 6)));
        System.out.println(calcAverage(List.of()));

        System.out.println(removeSpecificName(Arrays.asList("Alice", "Bob", "Charlie", "Bob"), "Bob"));
        System.out.println(removeSpecificName(List.of(), ""));
        }
    }