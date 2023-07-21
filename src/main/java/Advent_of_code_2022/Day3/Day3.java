package Advent_of_code_2022.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("..\\Advent_of_code\\src\\main\\java\\Advent_of_code_2022\\Day3\\input.txt");
        Scanner sc = new Scanner(file);

        String str, str1, str2;
        List<Character> str1List;
        List<Character> str2List;
        List<Character> duplicates = new ArrayList<>();
        int count = 0;

        while (sc.hasNext()) {
            str = sc.nextLine();
            str1 = str.substring(0, str.length() / 2);
            str2 = str.substring(str.length() / 2);

            str1List = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            str2List = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            for (char e : str1List) {
                if (str2List.contains(e)) {
                    duplicates.add(e);
                }
            }
        }
        for (char e : duplicates) {
            if (Character.isUpperCase(e)) {
                count += (e - 38);
            } else {
                count += (e - 96);
            }
        }
        System.out.println(count);
    }
}
