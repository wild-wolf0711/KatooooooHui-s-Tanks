package Grammar.SomeBase;

import java.util.Scanner;
public class TwoDimensionalArray {
    public static void main(String[] ars){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] arr = new int[size][];
        for(int i = 0;i < arr.length;i++){
            arr[i] = new int[i + 1];
            for(int j = 0;j < arr[i].length;j++){
                arr[i][j] = j + 1;
            }
        }

        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}