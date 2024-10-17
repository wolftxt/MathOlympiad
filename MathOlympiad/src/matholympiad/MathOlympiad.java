package matholympiad;

import java.util.Arrays;

public class MathOlympiad {

    private static final int goal = 2024;
    private static int length;
    private static int[] numbers;

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            length = i;
            numbers = new int[length];
            System.out.println("Printing all solutions for length = " + i);
            recursion(0);
        }
    }

    private static void recursion(int index) {
        int start = index == 0 ? 1 : 2 * sum(index);
        for (int i = start; i <= goal; i++) {
            if (index != 0 && i % sum(index) != 0) {
                continue;
            }
            numbers[index] = i;
            checkCondition();
            if (index < length - 1) {
                recursion(index + 1);
            }
        }
    }

    private static void checkCondition() {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % sum(i) != 0) {
                return;
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        if (sum == 2024) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static int sum(int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
