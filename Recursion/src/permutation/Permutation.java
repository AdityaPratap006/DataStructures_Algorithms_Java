package permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Permutation {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String string = scanner.nextLine();
        System.out.println(getPermutations(string));
    }

    public static ArrayList<String> getPermutations(String string) {
        if (string.length() == 1) {
            return new ArrayList<>(Collections.singleton(string));
        }

        char currentChar = string.charAt(0);
        String remainingString = string.substring(1);

        ArrayList<String> subResult = getPermutations(remainingString);
        ArrayList<String> permutations = new ArrayList<>();

        for (String s: subResult) {
            for (int i = 0; i <= s.length(); ++i) {
                permutations.add(s.substring(0, i) + currentChar + s.substring(i));
            }
        }

        return permutations;
    }

}
