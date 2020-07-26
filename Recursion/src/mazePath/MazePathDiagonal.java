package mazePath;

import java.util.ArrayList;
import java.util.Collections;

public class MazePathDiagonal {
    public static void main(String[] args) {
        int size = 3; // size X size Grid
        MazePath.Pair<Integer, Integer> start = new MazePath.Pair<>(0,0);
        MazePath.Pair<Integer, Integer> end = new MazePath.Pair<>(size - 1, size - 1);

        ArrayList<String> mazePaths = getAllMazePaths(size, start, end);
        System.out.println(mazePaths);
        System.out.println(mazePaths.size());
    }

    public static ArrayList<String> getAllMazePaths(
        int size,
        MazePath.Pair<Integer,Integer> start,
        MazePath.Pair<Integer,Integer> end
    ) {

        if (MazePath.isOutsideGrid(start, size)) {
            return new ArrayList<>();
        }

        if (start.equals(end)) {
            return new ArrayList<>(Collections.singleton(""));
        }

        MazePath.Pair<Integer, Integer> right = new MazePath.Pair<>(start.x + 1, start.y);
        MazePath.Pair<Integer, Integer> down = new MazePath.Pair<>(start.x , start.y + 1);
        MazePath.Pair<Integer, Integer> diagonal = new MazePath.Pair<>(start.x + 1, start.y + 1);

        ArrayList<String> rightPaths = getAllMazePaths(size, right, end);
        ArrayList<String> downPaths  = getAllMazePaths(size, down, end);
        ArrayList<String> diagonalPaths = getAllMazePaths(size, diagonal, end);

        ArrayList<String> allPaths = new ArrayList<>();

        for (String path: rightPaths) {
            allPaths.add("H" + path);
        }

        for (String path: downPaths) {
            allPaths.add("V" + path);
        }

        for (String path: diagonalPaths) {
            allPaths.add("D" + path);
        }

        return allPaths;
    }
}
