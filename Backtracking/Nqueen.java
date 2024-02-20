import java.util.Scanner;
import java.util.*;
import java.util.Stack;

public class eratosthenes {
    static int N = 11;
    static int res[][] = new int[N][N];

    public static void main(String[] args) {
        // N-Queen Visualizer
        Nqueen(0);
        for (int arr[] : res) {
            System.err.println(Arrays.toString(arr));
        }
    }

    public static boolean Nqueen(int col) {
        if (col == N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isFeasable(res, i, col)) {
                res[i][col] = 1;
                if (Nqueen(col + 1) == true)
                    return true;
                res[i][col] = 0;
            }
        }
        return false;
    }

    public static boolean isFeasable(int res[][], int row, int col) {
        for (int i = 0; i < col; i++)
            if (res[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; j--, i--)
            if (res[i][j] == 1)
                return false;
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (res[i][j] == 1)
                return false;
        return true;
    }
}
// [1, 0, 0, 0, 0, 0, 0, 0]
// [0, 0, 0, 0, 0, 0, 1, 0]
// [0, 0, 0, 0, 1, 0, 0, 0]
// [0, 0, 0, 0, 0, 0, 0, 1]
// [0, 1, 0, 0, 0, 0, 0, 0]
// [0, 0, 0, 1, 0, 0, 0, 0]
// [0, 0, 0, 0, 0, 1, 0, 0]
// [0, 0, 1, 0, 0, 0, 0, 0]

