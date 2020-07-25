package subSequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSequences {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String inputString = scanner.nextLine();
        ArrayList<String> subsequences = getSubsequences(inputString);

        System.out.println(subsequences);
    }

    public static ArrayList<String> getSubsequences(String string) {
        if (string.isEmpty()) {
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        char currentChar = string.charAt(0);
        String remainingString = string.substring(1);

        ArrayList<String> subSeqList = new ArrayList<>();
        ArrayList<String> subResult = getSubsequences(remainingString);

        subSeqList.addAll(subResult);

        for(String s: subResult) {
            subSeqList.add(currentChar + s);
        }

        return subSeqList;
    }

}
