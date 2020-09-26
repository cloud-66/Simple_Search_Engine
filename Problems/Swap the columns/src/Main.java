import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];
        for (int i =0; i<n;i++ ) {
            for (int j =0; j<m;j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int iIndex = scanner.nextInt();
        int jIndex = scanner.nextInt();
        int temp ;
        for (int i =0; i<n;i++ ) {
            temp = array[i][jIndex];
            array[i][jIndex] = array[i][iIndex];
            array[i][iIndex] = temp;
        }
        for (int i =0; i<n;i++ ) {
            for (int j =0; j<m;j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}