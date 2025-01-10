import java.util.*;

public class ArrayMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] arr = new int[2][3];
        // Accessing an element
        System.out.println(matrix[1][0]); // Output: 4
        System.out.println(arr[1][0]); // Output: 0

        // init array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }

        printArray(matrix);
        printArray(arr);

        int[][] grid = {
                {0, 0, 1},
                {1, 0, 1}
        };
        double prob = getHitProbability(2, 3, grid);
        System.out.println(prob);

        Set<Integer> set = new LinkedHashSet<>();
    }

    private static void printArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static double getHitProbability(int R, int C, int[][] G) {
        // Write your code here
        if (G.length == 0) return 0.0;

        int gridSize = R * C;
        double hitsCounter = 0.0;
        double prec = Math.pow(10, 6);

        for (int i=0; i<G.length; i++) {
            for (int j=0; j<G[i].length; j++) {
                if (G[i][j] == 1) hitsCounter++;
            }
        }

        double probability = hitsCounter / gridSize;

        return Math.round(probability * prec) / prec;
    }
}
