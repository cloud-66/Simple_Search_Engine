import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int first = scanner.nextInt();
        int last = scanner.nextInt();
        System.out.println(s.substring(first, last + 1));
    }
}