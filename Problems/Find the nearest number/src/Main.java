import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (String s : scanner.nextLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }
        int a = scanner.nextInt();
        int minDistance = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (Math.abs(i - a) < minDistance) {
                minDistance = Math.abs(i - a);
            }
        }
        for (Integer i : list) {
            if (Math.abs(i - a) == minDistance) {
                result.add(i);
            }
        }
        Collections.sort(result);
        for (Integer i: result) {
            System.out.print(i + " ");
        }
    }
}