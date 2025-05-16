package Algorithm;

public class Labyrinth {

    public void cal(int[][] arr, int m, int n) {
        if (m < 0 || m >= arr.length || n < 0 || n >= arr[0].length || arr[m][n] == 1 || arr[m][n] == 2) {
            return;
        }
        if (arr[m][n] == -1) {
            arr[m][n] = 2;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        arr[m][n] = 2;
        cal(arr, m + 1, n);
        cal(arr, m, n + 1);
        cal(arr,m-1,n);
        cal(arr,m,n-1);
        arr[m][n] = 3;
    }

    public static void main(String[] args) {
        Labyrinth tool = new Labyrinth();
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 1, -1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        tool.cal(arr, 1, 1);
    }
}