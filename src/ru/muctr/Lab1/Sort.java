package ru.muctr.Lab1;

import java.util.Arrays;
import java.util.Random;

/*
    Задание 1.
    Создайте массив int[] на 1000 элементов, заполните его случайными числами.
    Отсортируйте массив, используя метод быстрой сортировки.
    Какова асимптотическая сложность данного алгоритма?
        -- Сложность алгоритма O(n*log(n)).
    Сравните время выполнения сортировки со стандартным методом sort() класса Arrays.
*/

public class Sort {
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        int prop = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < prop) {
                i++;
            }

            while (array[j] > prop) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void printArray (int[] array, String text){
        System.out.printf(text);
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        int[] arrayCopied = Arrays.copyOf(array, array.length);

        long startTime1 = System.currentTimeMillis();
        printArray(array, "QuickSort Before ");
        quickSort(array, 0, array.length - 1);
        printArray(array, "QuickSort After ");
        System.out.printf("QuickSort time = " + (System.currentTimeMillis() - startTime1));
        System.out.println("\n");

        long startTime2 = System.currentTimeMillis();
        printArray(arrayCopied, "DefaultSort Before ");
        Arrays.sort(arrayCopied);
        printArray(arrayCopied, "DefaultSort After ");
        System.out.printf("DefaultSort time = " + (System.currentTimeMillis() - startTime2));
    }
}
