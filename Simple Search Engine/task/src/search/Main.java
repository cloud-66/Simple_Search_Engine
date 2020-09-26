package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String... args) throws FileNotFoundException {
        if (args.length == 2) {
            if ("--data".equals(args[0])) {
                Search search = new Search();
                search.search(args[1]);
            }
        }

    }
}


class Search {
    ArrayList<String> data = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> invIndex = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int l = 0;

    void search(String inFileName) throws FileNotFoundException {
        File file = new File(inFileName);

        if (file.isFile()) {
            try (Scanner sc = new Scanner(file)) {


                while (sc.hasNextLine()) {
                    String line = sc.nextLine();

                    data.add(line);

                    for (String str : line.split("\\s+")) {
                        str = str.toLowerCase();

                        if (invIndex.containsKey(str)) {
                            invIndex.get(str).add(l);
                        } else {
                            invIndex.put(str, new ArrayList<>(List.of(l)));
                        }
                    }
                    l += 1;
                }
            }
        } else {
            System.out.println("Error! File not found.");
            return;
        }
        menu();

    }

    void find() {
        boolean match = false;
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = sc.nextLine().toUpperCase();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String query = sc.nextLine().toLowerCase();

        HashSet<Integer> found = new HashSet<>();

        switch (strategy) {
            case "ANY":
                for (String s : query.split(" ")) {
                    if (invIndex.containsKey(s)) {
                        match = true;
                        invIndex.get(s);
                        found.addAll(invIndex.get(s));

                    }
                }
                break;
            case "ALL":
                String[] strAll = query.split(" ");
                if (invIndex.containsKey(strAll[0])) {
                    found.addAll(invIndex.get(strAll[0]));
                }
                for (String s : strAll) {
                    if (invIndex.containsKey(s)) {
                        match = true;
                        found.retainAll(invIndex.get(s));
                    } else {
                        match = false;
                        break;
                    }
                }
                break;
            case "NONE":
                String[] strNone = query.split(" ");
                HashSet<Integer> allNumbers = new HashSet<>();
                for (int i = 0; i < l; i++) {
                    allNumbers.add(i);
                }
                found.addAll(allNumbers);
                for (String s : strNone) {
                    if (invIndex.containsKey(s)) {
                        match = true;
                        found.removeAll(invIndex.get(s));
                    } else {
                        match = false;
                    }
                }
                break;
        }

        if (!match) {
            System.out.println("No matching people found");
        } else {
            System.out.println(found.size() + " persons found:");
            for (Integer p : found) {
                System.out.println(data.get(p));
            }
        }
        System.out.println();
    }

    void print() {
        System.out.println("\n=== List of people ===");

        data.forEach(System.out::println);
        System.out.println();
    }

    void menu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");

        String key = sc.nextLine();

        switch (key) {
            case "1":
                find();
                menu();
                break;
            case "2":
                print();
                menu();
                break;
            case "0":
                exit();
                return;
            default:
                System.out.println("\nIncorrect option! Try again.\n");
                break;
        }
    }

    void exit() {
        System.out.println("\nBye!");
    }
}



