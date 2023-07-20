package Advent_of_code_2022.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("..\\Advent_of_code\\src\\main\\java\\Advent_of_code_2022\\Day2\\input.txt");
        Scanner sc = new Scanner(file);

        HashMap<String, String> loose = new HashMap<>();

        loose.put("A", "C");
        loose.put("B", "A");
        loose.put("C", "B");

        HashMap<String, String> win = new HashMap<>();

        win.put("C", "A");
        win.put("A", "B");
        win.put("B", "C");

        String opponent;
        String player = "";
        String scndRow;
        int score = 0;

        while (sc.hasNext()) {
            opponent = sc.next();
            scndRow = sc.next();


            switch (scndRow) {
                case "Y" -> player = opponent;
                case "X" -> player = loose.get(opponent);
                case "Z" -> player = win.get(opponent);
            }

            if (player.equals("C")) {
                score += 3;
            } else if (player.equals("B")) {
                score += 2;
            } else {
                score += 1;
            }
            if(player.equals("A") && opponent.equals("C") || player.equals("B") &&
                    opponent.equals("A") || player.equals("C") && opponent.equals("B")) {
                score += 6;
            } else if (player.equals("A") && opponent.equals("A") || player.equals("B") &&
                    opponent.equals("B") || player.equals("C") && opponent.equals("C")) {
                score += 3;
            }
        }
        System.out.println(score);
    }
}
