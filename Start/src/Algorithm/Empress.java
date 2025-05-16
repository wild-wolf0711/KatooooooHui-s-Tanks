package Algorithm;

class Empress {
    private static final int N = 10;

    public boolean isSafe(int[][] arr, int m, int n) {
        // 检查坐标是否越界
        if (m < 0 || m >= N || n < 0 || n >= N)
            return false;
        // 检查列
        for (int i = 0; i < N; i++) {
            if (arr[i][n] == 1)
                return false;
        }
        // 检查行
        for (int i = 0; i < N; i++) {
            if (arr[m][i] == 1)
                return false;
        }
        // 检查左上对角线
        for (int i = m, j = n; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        // 检查右上对角线
        for (int i = m, j = n; i >= 0 && j < N; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public void queue(int[][] arr, int row) {
        if (row == N) {
            printSolution(arr);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(arr, row, col)) {
                arr[row][col] = 1;
                queue(arr, row + 1);
                arr[row][col] = 0;
            }
        }
    }

    private void printSolution(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = new int[N][N];
        Empress t = new Empress();
        t.queue(arr, 0);
    }
}