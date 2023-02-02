/* 1. Реализовать алгоритм сортировки слиянием */

import java.util.Arrays;

public class task_1 {
    public static void main(String[] args) {
        int[] sourceArray = {9, 2, 18, 6, 3, 45, 24, 33, 25, 16, 0, 12, 29};
        int[] result = mergesort(sourceArray);
        System.out.println(Arrays.toString(result));        
    }

    public static int[] mergesort(int[] sourceArray) {
        int[] buffer1 = Arrays.copyOf(sourceArray, sourceArray.length); // Массив для сортировки.
        int[] buffer2 = new int[sourceArray.length]; // Буфер. Размер должен быть равен размеру buffer1.
        int[] result = mergesortInner(buffer1, buffer2, 0, sourceArray.length);
        return result;
    }

    /*  startIndex Начальный индекс в buffer1 для сортировки.
        endIndex Конечный индекс в buffer1 для сортировки.
    */
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}