package boardPath;

import java.util.ArrayList;
import java.util.Collections;

public class BoardPath {
    public static void main(String[] args) {
        ArrayList<String> allBoardPaths = getAllBoardPaths(0, 10);
        System.out.println(allBoardPaths);
        System.out.println(allBoardPaths.size());
    }

    public static ArrayList<String> getAllBoardPaths(int start, int end) {
        if (start > end) {
            return  new ArrayList<>();
        }

        if (start == end) {
            return new ArrayList<>(Collections.singleton(""));
        }

        ArrayList<String> allPaths = new ArrayList<>();
        for (int i = 1; i <= 6; ++i) {
            ArrayList<String> subPaths = getAllBoardPaths(start + i, end);
            for (String path: subPaths) {
                allPaths.add("" + i + path);
            }
        }

        return allPaths;
    }
}
