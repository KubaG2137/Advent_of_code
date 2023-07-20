package Advent_of_code_2022.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("..\\Advent_of_code\\src\\main\\java\\Advent_of_code_2022\\Day2\\input.txt");
        Scanner sc = new Scanner(file);

        String opponent;
        String player;
        int score = 0;

        while (sc.hasNext()) {
            opponent = sc.next();
            player = sc.next();

            if (player.equals("Z")) {
                score += 3;
            } else if (player.equals("Y")) {
                score += 2;
            } else {
                score += 1;
            }
            if(player.equals("X") && opponent.equals("C") || player.equals("Y") &&
                    opponent.equals("A") || player.equals("Z") && opponent.equals("B")) {
                score += 6;
            } else if (player.equals("X") && opponent.equals("A") || player.equals("Y") &&
                    opponent.equals("B") || player.equals("Z") && opponent.equals("C")) {
                score += 3;
            }
        }
        System.out.println(score);
    }
}
