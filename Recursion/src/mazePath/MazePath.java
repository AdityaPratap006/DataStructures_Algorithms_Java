package mazePath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MazePath {
    public static void main(String[] args) {
        int size = 3; // size X size Grid
        Pair<Integer, Integer> start = new Pair<>(0, 0);
        Pair<Integer, Integer> end = new Pair<>(size - 1, size - 1);

        ArrayList<String> allMazePaths = getAllMazePaths(size, start, end);
        System.out.println(allMazePaths);
        System.out.println(allMazePaths.size());
    }

    public static ArrayList<String> getAllMazePaths(
            int size,
            Pair<Integer, Integer> start,
            Pair<Integer, Integer> end
    ) {
        if (start.equals(end)) {
            return new ArrayList<>(Collections.singleton(""));
        }

        if (isOutsideGrid(start, size)) {
            return new ArrayList<>();
        }

        Pair<Integer, Integer> right = new Pair<>(start.x + 1, start.y);
        Pair<Integer, Integer> down = new Pair<>(start.x, start.y + 1);

        ArrayList<String> rightPaths = getAllMazePaths(size, right, end);
        ArrayList<String> downPaths = getAllMazePaths(size, down, end);

        ArrayList<String> allPaths = new ArrayList<>();

        for (String path: rightPaths) {
            allPaths.add("H" + path);
        }

        for (String path: downPaths) {
            allPaths.add("V" + path);
        }

        return allPaths;
    }

    public static boolean isOutsideGrid(Pair<Integer, Integer> point, int size) {
        if (point.x >= size || point.x < 0) {
            return true;
        }

        return point.y >= size || point.y < 0;
    }

    private static class Pair<X, Y> {
        public final X x;
        public final Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!Objects.equals(x, pair.x)) return false;
            return Objects.equals(y, pair.y);
        }
    }
}
