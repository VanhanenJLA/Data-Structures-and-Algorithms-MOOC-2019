
import java.util.*;

public class Ruudukko {

    // Variables x and y are positions on a row or column respectively.
    // Cursor is the currently proposed value.
    
    int[][] muodosta(int n) {

        // Corner case.
        if (n == 1) return new int[][]{{0}};

        int[][] matrix = new int[n][n];
        matrix = FillMatrix(matrix);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                matrix[x][y] = FindNextInteger(matrix, x, y);
            }
        }
        return matrix;
    }

    int FindNextInteger(int[][] matrix, int x, int y) {
        int cursor = 0;

        while (true) {
            if (!Contains(RowToArray(matrix, y), cursor)) {
                if (!Contains(ColumnToArray(matrix, x), cursor)) {
                    return cursor;
                }
            }
            cursor++;
        }
    }

    boolean Contains(int[] row, int target) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == target) {
                return true;
            }
        }
        return false;
    }

    int[] ColumnToArray(int[][] matrix, int x) {
        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[x][i];
        }
        return arr;
    }

    int[] RowToArray(int[][] matrix, int y) {
        int[] arr = new int[matrix[1].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[i][y];
        }
        return arr;
    }

    int[][] FillMatrix(int[][] arr) {
        for (int y = 0; y < arr[1].length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                arr[x][y] = -1;
            }
        }
        return arr;
    }
}
