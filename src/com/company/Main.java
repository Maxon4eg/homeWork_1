package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String answer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wake up Neo...");


        System.out.print("what do you want ?: \n" +
                "1. Find distance\n" +
                "2. Revert words\n" +
                "Your answer is :");
        answer = scanner.next();
        userInput(scanner, answer);
        userInput(scanner, "1");
        System.out.println("I'm done");


    }

    private static void userInput(Scanner scanner, String answer) {
        switch (answer) {
            case "1":
                System.out.println("How many integers you want ?  \n " +
                        "Please be sure that the array must be more than 1: ");
                int numbers[] = new int[scanner.nextInt()];
                System.out.println("Please type " + numbers.length + " integers:");
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println("Enter a number and press Enter:");
                    numbers[i] = scanner.nextInt();
                }
                findDistance(numbers);
//                tests
//                findDistance(new int[]{55, 22, 33, 5, 12, 88, 11, 4}); // 4
//                findDistance(new int[]{55, 0, 33, 5, 11, 88, 11, 88}); // 2
//                findDistance(new int[]{1, 40, 33, 55, 11, 88, 11, 8}); // 7
                break;
            case "2":
                System.out.println("please type some words separated by SPACE and press ENTER ");

                doRevert(scanner.next().split(" "));
                break;
            default:
                System.out.println("Please type 1 or 2 ");
                userInput(scanner, answer);
                break;
        }
    }

    private static void findDistance(int[] numbers) {
        System.out.println("THE RESULT " +
                calculateDistance(findMinimum(numbers, -1), findMinimum(numbers, findMinimum(numbers, -1))));

    }


    private static int findMinimum(int[] numbers, int excluded) {
        for (int i = 1; i < numbers.length; i++) {
            if (i == excluded) {
                //skip
                continue;
            }

            if (numbers[i - 1] < numbers[i]) {
                return startAt(numbers, i - 1, i, excluded);
            } else return startAt(numbers, i, i + 1, excluded);
        }
        return -1;
    }

    private static int startAt(int[] numbers, int minimum, int startAt, int excluded) {
        if (startAt == numbers.length) {
            return minimum;
        }
        if (minimum== excluded){
            minimum+=1;
        }

        for (int i = startAt; i < numbers.length; i++) {
            if (numbers[minimum] > numbers[i] &&
                    i != excluded) {
                return startAt(numbers, i, startAt + 1, excluded);
            }
        }
        return minimum;


    }

    private static int calculateDistance(int first, int second) {
        if (second == 0 || first == 0) {
            return first + second;
        }
        if (first > second) {
            return first - second;
        } else return second - first;

    }

    private static void doRevert(String... words) {

    }


}
