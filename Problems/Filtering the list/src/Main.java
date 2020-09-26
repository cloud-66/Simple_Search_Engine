import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> phones = new ArrayList<>();
        String tmp = scanner.nextLine();
        scanner = new Scanner(tmp);
        List<Integer> ind = new ArrayList<>();
        while (scanner.hasNextInt()) {
            phones.add(scanner.nextInt());
        }
        for (int i = 0; i < phones.size(); i = i + 2) {
            ind.add(phones.get(i));
        }
        phones.removeAll(ind);
        Collections.reverse(phones);
        for (Integer i : phones) {
            System.out.print(i + " ");
        }
    }
}