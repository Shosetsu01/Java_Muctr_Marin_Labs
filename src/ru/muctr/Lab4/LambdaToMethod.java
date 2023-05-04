package ru.muctr.Lab4;

import java.util.function.Function;

public class LambdaToMethod {
    public Function<Integer[], Integer> findMostFrequentNumber = arr -> {
        if (arr.length == 0) {
            return null;
        }
        int mostFrequentNum = arr[0];
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++) {
            int currentCount = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentNum = arr[i];
            }
        }
        return mostFrequentNum;
    };

    public int findAverage(Integer[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (int) (sum / arr.length);
    }

    public static int findSmallestElement(Integer[] arr) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public void lambdaMethod(Integer[] arr, Function<Integer[], Integer> lambda) {
        System.out.println(lambda.apply(arr));
    }

    public static void main(String[] args) {
        LambdaToMethod ltm = new LambdaToMethod();

        Integer[] arr = {1, 2, 3, 4, 4, 4, 4, 4, 5, 2, 3, 2, 1};

        System.out.print("чаще всего повторяется: ");
        ltm.lambdaMethod(arr, ltm.findMostFrequentNumber);

        System.out.print("среднее среди элементов массива: ");
        ltm.lambdaMethod(arr, ltm::findAverage);

        System.out.print("наименьшее среди элементов массива: ");
        ltm.lambdaMethod(arr, LambdaToMethod::findSmallestElement);
    }

}
