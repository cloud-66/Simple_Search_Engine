import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i =0;i< arr.length;i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int sum =0;
        for (int ar: arr) {
            if (ar > n) {
                sum +=ar;
            }
        }
        System.out.println(sum);
    }
}