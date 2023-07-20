package Advent_of_code_2022.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("..\\Advent_of_code\\src\\main\\java\\Advent_of_code_2022\\Day1\\input.txt");
        Scanner sc = new Scanner(file);

        int calories = 0;
        int maxCalories = 0;
        String current;
        HashMap<String, Integer> elves = new HashMap<>();
        int elfNum = 1;
        while (sc.hasNext()) {
            current = sc.nextLine();

            if (!current.isEmpty()) {
                calories += Integer.parseInt(current);

            } else {

                elves.put("elf " + elfNum, calories);
                elfNum++;

                if (calories > maxCalories) {
                    maxCalories = calories;
                }

                calories = 0;
            }
        }
        List<String> keys = elves.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int topElvesTotal = elves.get(keys.get(0)) + elves.get(keys.get(1)) + elves.get(keys.get(2));

        System.out.printf("""
                        Max calories is: %d. First top 3 elves with biggest calories are:\s
                        %s with %d, %s with %d and %s with %d.\s
                        Total of top 3 elves is %d""",
                maxCalories, keys.get(0), elves.get(keys.get(0)),
                keys.get(1), elves.get(keys.get(1)), keys.get(2), elves.get(keys.get(2)), topElvesTotal);
    }
}
