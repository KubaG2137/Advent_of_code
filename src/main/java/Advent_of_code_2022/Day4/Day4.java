package Advent_of_code_2022.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

    public static void createArray (ArrayList<Integer> array, int num1, int num2) {
        int number = num1;
        for (int i = 0; i < num2 - num1 +1; i++) {
            array.add(number);
            number++;
        }
    }

    public static String processString (String str) {
        return str.replaceAll(",|-", " ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("..\\Advent_of_code\\src\\main\\java\\Advent_of_code_2022\\Day4\\input.txt");
        Scanner sc = new Scanner(file);
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        int counter = 0;

        while (sc.hasNext()) {

            String str = processString(sc.nextLine());
            Scanner sc2 = new Scanner(str);
            int num1 = sc2.nextInt();
            int num2 = sc2.nextInt();
            int num3 = sc2.nextInt();
            int num4 = sc2.nextInt();

            createArray(array1, num1, num2);
            createArray(array2, num3, num4);

            if (array1.size() > array2.size()) {
                for (Integer e: array1) {
                    if (array2.contains(e)) {
                        counter++;
                        break;
                    }
                }
            } else {
                for (Integer e: array2) {
                    if (array1.contains(e)) {
                        counter++;
                        break;
                    }
                }
            }
            array1.clear();
            array2.clear();
        }
        System.out.println(counter);
    }
}
