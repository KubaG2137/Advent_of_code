package Advent_of_code_2022.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("..\\Advent_of_code\\src\\Advent_of_code_2022\\Day1\\input.txt");
        Scanner sc = new Scanner(file);

        int calories = 0;
        int maxCalories = 0;
        String current;

        while (sc.hasNext()) {
            current = sc.nextLine();

            if (!current.isEmpty()) {
                calories += Integer.parseInt(current);

            } else {

                if (calories > maxCalories) {
                    maxCalories = calories;
                }

                calories = 0;
            }
        }
        System.out.println(maxCalories);
    }
}

