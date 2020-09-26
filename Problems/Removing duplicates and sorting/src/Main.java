import java.util.*;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Set<String> list = new TreeSet<>();
        final int size =  Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextLine());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}